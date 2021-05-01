package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.service.ExperimentService;
import org.springframework.stereotype.Service;

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


    @Override
    public int setExperimentNotAllowSelected(long experimentId) {
        return experimentDao.setExperimentNotAllowSelected(experimentId);
    }

    @Override
    public int setExperimentFinished(long experimentId) {
        return experimentDao.setExperimentFinished(experimentId);
    }
}
