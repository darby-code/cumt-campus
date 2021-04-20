package com.doug.ssm.dao;

import com.doug.ssm.BaseTest;
import com.doug.ssm.entity.ExperimentSelected;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExperimentSelectedDaoTest extends BaseTest {

    @Autowired
    ExperimentSelectedDao experimentSelectedDao;
//    @Autowired
//    ExperimentDao experimentDao;

    @Test
    public void insertExperimentSelected() {
//        ExperimentSelected one = new ExperimentSelected(0, 100111012, 1009, 0);
//        ExperimentSelected two = new ExperimentSelected(0, 100111033, 1011, 0);
//        ExperimentSelected three = new ExperimentSelected(0, 100131022, 1009, 0);
//        ExperimentSelected four = new ExperimentSelected(0, 100131023, 1011, 0);
//        ExperimentSelected five = new ExperimentSelected(0, 100131024, 1016, 0);
//        ExperimentSelected six = new ExperimentSelected(0, 100141131, 1009, 0);

//        experimentSelectedDao.insertExperimentSelected(one);
//        experimentDao.experimentSelectedNumberPlusOne(1009);
//        experimentSelectedDao.insertExperimentSelected(two);
//        experimentDao.experimentSelectedNumberPlusOne(1011);
//        experimentSelectedDao.insertExperimentSelected(three);
//        experimentDao.experimentSelectedNumberPlusOne(1009);
//        experimentSelectedDao.insertExperimentSelected(four);
//        experimentDao.experimentSelectedNumberPlusOne(1011);
//        experimentSelectedDao.insertExperimentSelected(five);
//        experimentDao.experimentSelectedNumberPlusOne(1016);
//        experimentSelectedDao.insertExperimentSelected(six);
//        experimentDao.experimentSelectedNumberPlusOne(1009);
    }

    @Test
    public void queryExperimentSelectedBy() {
        int experimentId = 1009;
        List<ExperimentSelected> list = experimentSelectedDao.queryExperimentSelectedBy(experimentId);
        System.out.println(list);
    }

    @Test
    public void queryStudentSelectedExperimentsBy() {
        int studentId = 100111033;
        List<Integer> list = experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
        System.out.println(list);
    }

    @Test
    public void queryScore() {
        int studentId = 100111033;
        int experimentId = 1011;
        int score = experimentSelectedDao.queryScore(studentId, experimentId);
        System.out.println(score);
    }

    @Test
    public void updateScore() {
        ExperimentSelected selected = new ExperimentSelected(0, 100111033, 1011, 90);
        experimentSelectedDao.updateScore(selected);
        int score = experimentSelectedDao.queryScore(100111033, 1011);
        System.out.println(score);
    }

    @Test
    public void deleteStudentBy() {
        int result = experimentSelectedDao.deleteStudentBy(1017);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentBy() {
        int serialId = 101;
        ExperimentSelected selected = new ExperimentSelected(serialId, 0, 0, 0);
        int result = experimentSelectedDao.deleteExperimentBy(selected);
        System.out.println(result);
    }
}
