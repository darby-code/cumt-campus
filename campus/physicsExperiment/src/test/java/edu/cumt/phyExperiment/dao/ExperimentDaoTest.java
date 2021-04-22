package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Experiment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ExperimentDaoTest extends BaseTest {

    @Autowired
    ExperimentDao experimentDao;

    @Test
    public void queryTeacherExperimentBy() {
        int teacherId = 1002501;
        List<Experiment> experiments = experimentDao.queryTeacherExperimentBy(teacherId);
        System.out.println(experiments);
    }

    @Test
    public void queryExperimentById() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void queryExperimentByName() {
        String experimentName = "实验";
        List<Experiment> list = experimentDao.queryExperimentByName(experimentName);
        System.out.println(list);
    }

    @Test
    public void queryAllowSelectedExperiments() {
        List<Experiment> list = experimentDao.queryAllowSelectedExperiments();
        System.out.println(list);
    }

    @Test
    public void queryNotAllowSelectedExperiments() {
        List<Experiment> list = experimentDao.queryNotAllowSelectedExperiments();
        System.out.println(list);
    }

    @Test
    public void queryFinishedExperiments() {
        List<Experiment> list = experimentDao.queryFinishedExperiments();
        System.out.println(list);
    }

    @Test
    public void queryNotFinishedExperiments() {
        List<Experiment> list = experimentDao.queryNotFinishedExperiments();
        System.out.println(list);
    }

    @Test
    public void queryExperimentIsFinished() {
        int ex01 = 1016;
        int ex02 = 1017;
        boolean ex1 = experimentDao.queryExperimentIsFinished(ex01);
        boolean ex2 = experimentDao.queryExperimentIsFinished(ex02);
        System.out.println("ex01=" + ex1 + ", ex02=" + ex2);
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
    public void updateExperimentTime() {
        Experiment experiment = experimentDao.queryExperimentById(1009);
        Experiment newExperiment = new Experiment();
        int result = experimentDao.updateExperimentTime(experiment.getExperimentId(), new Date());
        System.out.println(result);
        newExperiment = experimentDao.queryExperimentById(1009);
        System.out.println(newExperiment);
        experimentDao.updateExperimentTime(experiment.getExperimentId(), experiment.getExperimentTime());
    }

    @Test
    public void updateExperimentPlace() {
        Experiment experiment = experimentDao.queryExperimentById(1009);
        Experiment newExperiment = new Experiment();
        int result = experimentDao.updateExperimentPlace(experiment.getExperimentId(), "用于测试");
        System.out.println(result);
        newExperiment = experimentDao.queryExperimentById(1009);
        System.out.println(newExperiment);
        experimentDao.updateExperimentPlace(experiment.getExperimentId(), experiment.getExperimentPlace());
    }

    @Test
    public void updateExperimentCapacity() {
        Experiment experiment = experimentDao.queryExperimentById(1009);
        Experiment newExperiment = new Experiment();
        int result = experimentDao.updateExperimentCapacity(experiment.getExperimentId(), 100);
        System.out.println(result);
        newExperiment = experimentDao.queryExperimentById(1009);
        System.out.println(newExperiment);
        experimentDao.updateExperimentCapacity(experiment.getExperimentId(), experiment.getCapacity());
    }

    @Test
    public void experimentSelectedNumberPlusOne() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
        experimentDao.experimentSelectedNumberPlusOne(experimentId);
        experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void experimentSelectedNumberReduceOne() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
        experimentDao.experimentSelectedNumberReduceOne(experimentId);
        experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void insertExperiment() {
        Experiment newExperiment = new Experiment(0, "替换实验"
                , new Date(), "B428", 10, 1002509
                , 0, null, true, false);
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
