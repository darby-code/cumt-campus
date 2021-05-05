package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.dao.ExperimentLimitDao;
import edu.cumt.phyExperiment.dao.ExperimentSelectedDao;
import edu.cumt.phyExperiment.dao.UserDao;
import edu.cumt.phyExperiment.dto.DropExperimentExecution;
import edu.cumt.phyExperiment.dto.SelectedExecution;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.enums.ExperimentStateEnum;
import edu.cumt.phyExperiment.exception.*;
import edu.cumt.phyExperiment.service.ExperimentSelectedService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Service("experimentSelectedService")
public class ExperimentSelectedServiceImpl implements ExperimentSelectedService {

    @Resource(name = "experimentSelectedDao")
    ExperimentSelectedDao experimentSelectedDao;
    @Resource(name = "experimentDao")
    ExperimentDao experimentDao;
    @Autowired
    ExperimentLimitDao experimentLimitDao;
    @Autowired
    UserDao userDao;

    public static final int TIME_WAITING_FOR_SELECT_EXPERIMENT = 5;

    @Override
    public List<Experiment> querySelectedExperiments(long studentId) {
        return experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
    }

    @Override
    public List<ExperimentSelected> queryOneSelectedExperiments(long experimentId) {
        List<ExperimentSelected> selectedList = null;
        try {
            selectedList = experimentSelectedDao.queryOneSelectedExperiments(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("查询选课记录时发生一个错误");
        }
        return selectedList;
    }

    @Override
    public List<ExperimentSelected> queryExperimentsScore(long studentId) {
        List<ExperimentSelected> selectedList = null;
        try {
            selectedList = experimentSelectedDao.queryScore(studentId);
        } catch (Exception ex) {
            throw new RuntimeException("成绩查询时遇到一个未知错误");
        }
        //成功查询
        return selectedList;
    }

    @Override
    public SelectedExecution experimentSelectedNumberPlusOne(long experimentId, long studentId) {
        Semaphore experimentSelectedPermit = null;
        try {
            //采用Semaphore控制并发
            //尝试5s获取许可，如果5s获取不到许可，说明该实验人数过多
            if ((experimentSelectedPermit = ClickNumberControl.getCountClickNumber().get(experimentId)).tryAcquire(TIME_WAITING_FOR_SELECT_EXPERIMENT, TimeUnit.SECONDS)) {
                //获取选课许可成功
                Experiment experiment = experimentDao.queryExperimentById(experimentId);
                if (experiment == null) {
                    throw new NotExistsException("所选实验编号：" + experimentId + "对应的实验不存在");
                }

                List<Experiment> selectedExperiments = experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
                if (selectedExperiments.size() >= 5) {
                    throw new SelectedLimitException("已达到实验选课数量上限");
                }
                //判断是否已选上该实验，如果是，说明出现了重复选
                for (Experiment e : selectedExperiments) {
                    if (e.getExperimentId() == experimentId) {
                        throw new RepeatSelectedException("请勿重复实验选课");
                    }
                }
                if (!experiment.isAllowSelected()) {
                    throw new NotAllowSelectedException("该实验已关闭选课");
                }
                if(experiment.getCapacity().intValue() == experiment.getSelectedNumber().intValue()) {
                    throw new NoMarginException("实验已选人数达到上限");
                }
                List<Long> colleges = experimentLimitDao.queryExperimentLimitCollegeIdById(experimentId);
                Student student = userDao.queryStudentById(studentId);
                if (colleges != null) {
                    for (Long collegeId : colleges) {
                        if (collegeId == student.getCollege().getCollegeId()) {
                            throw new CollegeLimitException("实验不对你所在学院开放");
                        }
                    }
                }
                //判断实验时间是否冲突
                String dateStr = experiment.getExperimentTime().toString();
                for (Experiment e : selectedExperiments) {
                    if (dateStr.equals(e.getExperimentTime().toString())) {
                        //出现了实验时间冲突
                        throw new ConflictException("实验时间冲突");
                    }
                }
                //到这里说明是可以该学生是可以选该实验的
                int result = selectedExperiment(experimentId, studentId);
                if (result == 0) {
                    throw new SelectedException("服务器内部出现错误，该选课操作无法进行");
                }
                ExperimentSelected selected = experimentSelectedDao.queryOneSelectedExperiment(experimentId, studentId);
                //实验选课成功,释放选课许可
                experimentSelectedPermit.release();
                return new SelectedExecution(experimentId, ExperimentStateEnum.SUCCESS
                        , selected);
            }
        } catch (NotExistsException | SelectedLimitException | RepeatSelectedException
                | NotAllowSelectedException | NoMarginException | ConflictException
                | SelectedException | CollegeLimitException e1) {
            //选实验失败，也必须释放选课许可
            experimentSelectedPermit.release();
            throw e1;
        } catch (Exception e8) {
            //选实验失败，也必须释放选课许可
            experimentSelectedPermit.release();
            throw new RuntimeException("选课时出现了一个未知的错误");
        }
        //到这里，说明该学生没有获取到选课许可，返回一个TOO_MANY_HITS
        return new SelectedExecution(experimentId, ExperimentStateEnum.TOO_MANY_HITS);
    }

    @Transactional
    //加事务管理，失败回滚
    //这里不存在竞态，所以不用加锁
    public int selectedExperiment(long experimentId, long studentId) {
        int plusOne = experimentDao.experimentSelectedNumberPlusOne(experimentId);
        int addOne = experimentSelectedDao.insertExperimentSelected(experimentId, studentId);
        //必须为plusOne = 1   addOne = 1
        if (plusOne != 1 || addOne != 1) {
            //实验选课失败
            return 0;
        }
        //实验选课成功
        return 1;
    }

    @Transactional
    @Override
    public DropExperimentExecution experimentSelectedNumberReduceOne(long experimentId, long studentId) {
        try {
            int isReduce = experimentDao.experimentSelectedNumberReduceOne(experimentId);
            int isDelete = experimentSelectedDao.deleteExperimentBy(experimentId, studentId);
            if (isReduce != 1 || isDelete != 1) {
                throw new DropExperimentException("退选实验发生错误，请重试");
            }
        } catch (DropExperimentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("服务器内部发生一个未知异常");
        }
        //到这里，退选实验成功
        return new DropExperimentExecution(experimentId, ExperimentStateEnum.DROP_SUCCESS);
    }

    @Override
    public List<Student> queryExperimentStudents(long experimentId) {
        return experimentSelectedDao.queryExperimentSelectedStudentBy(experimentId);
    }

    @Override
    public ExperimentSelected queryOneSelectedExperiment(long experimentId, long studentId) {
        ExperimentSelected selected = null;
        try {
            selected = experimentSelectedDao.queryOneSelectedExperiment(experimentId, studentId);
        } catch (Exception ex) {
            throw new RuntimeException("查询学生一条已选实验信息时出现错误");
        }
        return selected;
    }

    @Transactional
    @Override
    public int inputExperimentScore(long experimentId, long studentId, int score) {
        //录入成绩后教师就不可再更改学生成绩
        try {
            experimentSelectedDao.updateScore(experimentId, studentId, score, false);
            //检查一个实验是否所有成绩都录完，如果是则将实验置为结束状态
            List<ExperimentSelected> selectedList = experimentSelectedDao.queryOneSelectedExperiments(experimentId);
            boolean isFinished = true; // 假设可以结束
            for (ExperimentSelected es : selectedList) {
                if (es.getAllowModified()) {
                    isFinished = false; //假设不成立，成绩未录完，实验不能为结束状态
                    break;
                }
            }
            if (isFinished) {
                experimentDao.setExperimentFinished(experimentId); //假设成立
            }
            //到这里，说明都成功了，如果实验结束返回2，实验没有结束，但成绩更新成功返回1
            return isFinished ? 2 : 1;
        } catch (Exception ex) {
            throw new RuntimeException("成绩更新失败，请重新尝试");
        }
    }
}
