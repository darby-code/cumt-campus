package edu.cumt.phyExperiment.service.impl;

import com.sun.jmx.snmp.tasks.ThreadService;
import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.service.ExperimentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service("experimentService")
public class ExperimentServiceImpl implements ExperimentService {
    @Resource(name = "experimentDao")
    ExperimentDao experimentDao;

    @Override
    public List<Experiment> queryAllExperiments() {
        try {
            return experimentDao.queryAllExperiments();
        } catch (Exception ex) {
            throw new RuntimeException("查询所有实验信息时遇到错误");
        }
    }

    @Override
    public Experiment queryExperimentById(long experimentId) {
        try {
            return experimentDao.queryExperimentById(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("查询一条实验信息时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryExperimentByName(String experimentName) {
        try {
            return experimentDao.queryExperimentByName(experimentName);
        } catch (Exception ex) {
            throw new RuntimeException("根据实验名称查询实验时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryExperimentByKeyWords(String words) {
        try {
            return experimentDao.queryExperimentsByKeyWords(words);

        } catch (Exception ex) {
            throw new RuntimeException("根据关键词查找实验时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryTeacherExperimentsById(long teacherId) {
        try {
            return experimentDao.queryTeacherExperiments(teacherId);
        } catch (Exception ex) {
            throw new RuntimeException("查询一个老师的实验课程信息时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryAllowSelectedExperiments() {
        try {
            return experimentDao.queryAllowSelectedExperiments();
        } catch (Exception ex) {
            throw new RuntimeException("查询所有可选实验信息时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryNotAllowSelectedExperiments() {
        try {
            return experimentDao.queryNotAllowSelectedExperiments();
        } catch (Exception ex) {
            throw new RuntimeException("查询所有不可选实验信息时遇到错误");
        }
    }

    @Override
    public List<Experiment> queryFinishedExperiments() {
        try {
            return experimentDao.queryFinishedExperiments();
        } catch (Exception ex) {
            throw new RuntimeException("查询已经出成绩的实验时遇到错误");
        }
    }

    @Override
    public int addNewExperiment(Experiment experiment) {
        try {
            return experimentDao.insertExperiment(experiment);
        } catch (Exception ex) {
            throw new RuntimeException("新增一个新的实验给学生选课时遇到错误");
        }
    }

    @Override
    public int deleteExperimentById(long experimentId) {
        try {
            return experimentDao.deleteExperimentBy(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("删除一个实验时遇到错误");
        }
    }

    @Override
    public int modifyExperiment(Experiment experiment) {
        try {
            return experimentDao.updateExperimentInfo(experiment);
        } catch (Exception ex) {
            throw new RuntimeException("修改一个实验信息时遇到错误");
        }
    }


    @Transactional
    @Override
    public int setExperimentNotAllowSelected(long experimentId) {
        int result = 0;
        try {
            result = experimentDao.setExperimentNotAllowSelected(experimentId);
            if (result != 1) {
                //实验的截止选课设置操作重复操作
                throw new RuntimeException();
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("实验的截止选课设置操作失败");
        }
    }

    @Override
    public int setExperimentFinished(long experimentId) {
        try {
            return experimentDao.setExperimentFinished(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("设置实验为结束状态时遇到错误");
        }
    }

    @Override
    public List<String> queryExperimentName() {
        List<String> experimentNames = null;
        try {
            experimentNames = experimentDao.queryExperimentName();
            return experimentNames;
        } catch (Exception ex) {
            throw new RuntimeException("查询实验名称时遇到异常");
        }
    }

    @Override
    public List<String> queryExperimentPlace() {
        List<String> experimentPlaces = null;
        try {
            experimentPlaces = experimentDao.queryExperimentPlace();
            return experimentPlaces;
        } catch (Exception ex) {
            throw new RuntimeException("查询实验教室时遇到异常");
        }
    }
}
