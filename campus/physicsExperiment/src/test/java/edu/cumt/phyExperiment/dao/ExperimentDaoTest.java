package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Experiment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExperimentDaoTest extends BaseTest {

    @Autowired
    ExperimentDao experimentDao;

    @Test
    public void queryAllExperiments() {
        List<Experiment> experiments = experimentDao.queryAllExperiments();
        System.out.println(experiments);
    }

    @Test
    public void queryAllowSelectedExperiments() {
        List<Experiment> experiments = experimentDao.queryAllowSelectedExperiments();
        System.out.println(experiments);
    }

    @Test
    public void queryNotAllowSelectedExperiments() {
        List<Experiment> experiments = experimentDao.queryNotAllowSelectedExperiments();
        System.out.println(experiments);
    }

    @Test
    public void queryFinishedExperiments() {
        List<Experiment> experiments = experimentDao.queryFinishedExperiments();
        System.out.println(experiments);
    }

    @Test
    public void queryTeacherExperiments() {
        int teacherId = 1002501;
        List<Experiment> experiments = experimentDao.queryTeacherExperiments(teacherId);
        System.out.println(experiments);
    }

    @Test
    public void queryExperimentsByKeyWords() {
        List<Experiment> experiments = experimentDao.queryExperimentsByKeyWords("星期日");
        System.out.println(experiments);
    }

    @Test
    public void queryExperimentById() {
        int experimentId = 1010;
        Experiment experiment = experimentDao.queryExperimentById(experimentId);
        System.out.println(experiment);
    }

    @Test
    public void queryExperimentDateById() {
        Date dateOne = experimentDao.queryExperimentDateById(1010L);
        Date dateTwo = experimentDao.queryExperimentDateById(1009L);
        Date dateThree = experimentDao.queryExperimentDateById(1012L);
        System.out.println(dateOne);
        System.out.println(dateTwo);
        System.out.println(dateThree);
        String one = dateOne.toString();
        String two = dateTwo.toString();
        String three = dateThree.toString();
        System.out.println(dateOne.toString());
        System.out.println(dateTwo.toString());
        System.out.println(dateThree.toString());
        System.out.println("" + one.equals(two) + two.equals(three) + three.equals(one));
    }

    @Test
    public void queryExperimentByName() {
        String experimentName = "霍尔效应";
        List<Experiment> list = experimentDao.queryExperimentByName(experimentName);
        System.out.println(list);
    }

    @Test
    public void queryMaxExperimentId() {
        int maxExperimentId = experimentDao.queryMaxExperimentId();
        System.out.println(maxExperimentId);
    }

    @Test
    public void insertExperiment() {
        Experiment experiment = new Experiment("测试", new Date(), "测试", "测试地点", (long) 1002506, "张悬", "11223344556", 10);
        int result = experimentDao.insertExperiment(experiment);
        System.out.println(result);
    }

    @Test
    public void updateExperimentInfo() {
        Experiment experiment = new Experiment("测试修改", new Date(), "测试11", "测试地点11", (long) 1002506, "张悬", "11223344556", 10);
        experiment.setExperimentId((long) 1022);
        int result = experimentDao.updateExperimentInfo(experiment);
        System.out.println(result);
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
    public void deleteExperimentBy() {
        int maxExperimentId = experimentDao.queryMaxExperimentId();
        int result = experimentDao.deleteExperimentBy(maxExperimentId);
        System.out.println(result + "    " + maxExperimentId);
    }

    @Test
    public void setExperimentNotAllowSelected() {
        int result = experimentDao.setExperimentNotAllowSelected(1009);
        System.out.println(result);
    }

    @Test
    public void setExperimentFinished() {
        int result = experimentDao.setExperimentFinished(1009);
        System.out.println(result);
    }
}
