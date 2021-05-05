package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.service.ExperimentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("experimentService")
public class ExperimentServiceImpl implements ExperimentService {
    @Resource(name = "experimentDao")
    ExperimentDao experimentDao;

    @Override
    public List<Experiment> queryAllExperiments() {
        return experimentDao.queryAllExperiments();
    }

    @Override
    public Experiment queryExperimentById(long experimentId) {
        return experimentDao.queryExperimentById(experimentId);
    }

    @Override
    public List<Experiment> queryExperimentByName(String experimentName) {
        return experimentDao.queryExperimentByName(experimentName);
    }

    @Override
    public List<Experiment> queryExperimentByKeyWords(String words) {
        return experimentDao.queryExperimentsByKeyWords(words);
    }

    @Override
    public List<Experiment> queryTeacherExperimentsById(long teacherId) {
        return experimentDao.queryTeacherExperiments(teacherId);
    }

    @Override
    public List<Experiment> queryAllowSelectedExperiments() {
        return experimentDao.queryAllowSelectedExperiments();
    }

    @Override
    public List<Experiment> queryNotAllowSelectedExperiments() {
        return experimentDao.queryNotAllowSelectedExperiments();
    }

    @Override
    public List<Experiment> queryFinishedExperiments() {
        return experimentDao.queryFinishedExperiments();
    }

    @Override
    public int addNewExperiment(Experiment experiment) {
        return experimentDao.insertExperiment(experiment);
    }

    @Override
    public int deleteExperimentById(long experimentId) {
        return experimentDao.deleteExperimentBy(experimentId);
    }

    @Override
    public int modifyExperiment(Experiment experiment) {
        return experimentDao.updateExperimentInfo(experiment);
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
        return experimentDao.setExperimentFinished(experimentId);
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
