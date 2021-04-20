package com.doug.ssm.dao;

import com.doug.ssm.BaseTest;
import com.doug.ssm.entity.Experiment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ExperimentDaoTest extends BaseTest {

    @Autowired
    ExperimentDao experimentDao;

    @Test
    public void queryExperimentsBy() {
        int teacherId = 1002501;
        List<Experiment> experiments = experimentDao.queryExperimentsBy(teacherId);
        System.out.println(experiments);
    }

    @Test
    public void queryExperimentBy() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentBy(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void queryMaxExperimentId() {
        int maxExperimentId = experimentDao.queryMaxExperimentId();
        System.out.println(maxExperimentId);
    }

    @Test
    public void queryAllExperiments() {
        List<Experiment> allExperiments = experimentDao.queryAllExperiments();
        System.out.println(allExperiments);
    }

    @Test
    public void updateExperiment() {
        Experiment experiment = experimentDao.queryExperimentBy(1009);
        Experiment newExperiment = new Experiment(1009, "替换实验"
                , new Date(), "B428", 10, 1002509
                , 0, null, null, null);
        int result = experimentDao.updateExperiment(newExperiment);
        System.out.println(result);
        newExperiment = experimentDao.queryExperimentBy(1009);
        System.out.println(newExperiment);
        experimentDao.updateExperiment(experiment);
    }

    @Test
    public void experimentSelectedNumberPlusOne() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentBy(experimentId);
        System.out.println(experiment);
        experimentDao.experimentSelectedNumberPlusOne(experimentId);
        experiment = experimentDao.queryExperimentBy(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void experimentSelectedNumberReduceOne() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentBy(experimentId);
        System.out.println(experiment);
        experimentDao.experimentSelectedNumberReduceOne(experimentId);
        experiment = experimentDao.queryExperimentBy(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void insertExperiment() {
        Experiment newExperiment = new Experiment(1009, "替换实验"
                , new Date(), "B428", 10, 1002509
                , 0, null, null, null);
        int result = experimentDao.insertExperiment(newExperiment);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentBy() {
        int maxExperimentId = experimentDao.queryMaxExperimentId();
        int result = experimentDao.deleteExperimentBy(maxExperimentId);
        System.out.println(result + "    " + maxExperimentId);
    }
}
