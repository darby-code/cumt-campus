package edu.cumt.phyExperiment.service.impl;


import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.dao.ExperimentTempDao;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentTemp;
import edu.cumt.phyExperiment.service.ExperimentTempService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

@Service("ExperimentTempService")
public class ExperimentTempServiceImpl implements ExperimentTempService {
    @Autowired
    ExperimentTempDao experimentTempDao;
    @Autowired
    ExperimentDao experimentDao;

    @Override
    public int submitNewExperiment(ExperimentTemp experimentTemp) {
        int result = 0;
        try {
            result = experimentTempDao.submitNewExperiment(experimentTemp);
            if (result == 0) {
                throw new RuntimeException("新增一个实验失败");
            }
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("新增实验时，系统内部出现错误，请检查信息或稍后重试");
        }
        return result;
    }

    @Override
    public List<ExperimentTemp> queryAllTempExperiments() {
        List<ExperimentTemp> experimentTemps = null;
        try {
            experimentTemps = experimentTempDao.queryAllTempExperiments();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return experimentTemps;
    }

    @Override
    public List<ExperimentTemp> queryAllAuditExperiments() {
        List<ExperimentTemp> experimentTemps = null;
        try {
            experimentTemps = experimentTempDao.queryAllAuditExperiments();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return experimentTemps;
    }

    @Override
    public List<ExperimentTemp> queryAllNotPassExperiments() {
        List<ExperimentTemp> experimentTemps = null;
        try {
            experimentTemps = experimentTempDao.queryAllNotPassExperiments();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return experimentTemps;
    }

    @Override
    public List<ExperimentTemp> queryAllPassExperiments() {
        List<ExperimentTemp> experimentTemps = null;
        try {
            experimentTemps = experimentTempDao.queryAllPassExperiments();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return experimentTemps;
    }

    @Override
    public int queryAuditExperimentsCount() {
        int result = 0;
        try {
            result = experimentTempDao.queryAuditExperimentsCount();
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return result;
    }

    @Override
    public int queryNotPassExperimentsCount() {
        int result = 0;
        try {
            result = experimentTempDao.queryNotPassExperimentsCount();
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return result;
    }

    @Override
    public int queryPassExperimentsCount() {
        int result = 0;
        try {
            result = experimentTempDao.queryPassExperimentsCount();
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return result;
    }

    @Override
    public List<ExperimentTemp> queryTeacherSubmitExperiments(long submitTeacherId) {
        List<ExperimentTemp> experimentTemps = null;
        try {
            experimentTemps = experimentTempDao.queryTeacherSubmitExperiments(submitTeacherId);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return experimentTemps;
    }


    @Override
    public int updateSubmitExperimentInfo(ExperimentTemp experimentTemp) {
        int result = 0;
        try {
            result = experimentTempDao.updateSubmitExperimentInfo(experimentTemp);
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return result;
    }

    @Override
    public int updateExperimentState(long tempId, int state, String auditAdminAccount) {
        int result = 0;
        try {
            result = experimentTempDao.updateExperimentState(tempId, state, auditAdminAccount);
        } catch (Exception ex) {
            throw new RuntimeException("系统内部出现错误");
        }
        return result;
    }

    //添加事务
    @Transactional
    @Override
    public int auditPassAndRelease(long tempId, String auditAdminAccount) {
        int result = 0;
        try {
            result = experimentTempDao.updateExperimentState(tempId, 2, auditAdminAccount);
            if (result != 1) {
                throw new RuntimeException("请勿重复修改");
            }
            ExperimentTemp temp = experimentTempDao.queryOneTempExperiment(tempId);
            Experiment experiment = new Experiment(temp);
            result += experimentDao.insertExperiment(experiment);
            if (result != 2) {
                throw new RuntimeException("插入待审核实验失败");
            }
            //添加该实验的许可证明,控制并发性
            ClickNumberControl.getCountClickNumber().put(experimentDao.queryMaxExperimentId(), new Semaphore(ClickNumberControl.MAX_PERMITS));
            //到这里，都成功
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("审核失败，请重试");
        }
    }
}
