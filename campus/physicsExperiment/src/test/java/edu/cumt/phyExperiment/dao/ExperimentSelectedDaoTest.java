package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExperimentSelectedDaoTest extends BaseTest {

    @Autowired
    ExperimentSelectedDao experimentSelectedDao;
    @Autowired
    ExperimentDao experimentDao;


    @Test
    public void queryExperimentSelectedBy() {
        int experimentId = 1009;
        List<ExperimentSelected> list = experimentSelectedDao.queryExperimentSelectedBy(experimentId);
        System.out.println(list);
    }

    @Test
    public void queryStudentSelectedExperimentsBy() {
        int studentId = 100111033;
        List<ExperimentSelected> list = experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
        System.out.println(list);
    }

    @Test
    public void queryScore() {
        int studentId = 100111033;
        int experimentId = 1011;
        int score = experimentSelectedDao.queryScore(studentId, experimentId);
        System.out.println(score);
    }

    public void queryIsFinishedExperimentScore() {

    }

    @Test
    public void updateScore() {
        ExperimentSelected selected = new ExperimentSelected();
        selected.setExperimentId(1011);
        selected.setStudentId(100131023);
        selected.setScore(90);
        experimentSelectedDao.updateScore(1011, 100131023, 90);
        int score = experimentSelectedDao.queryScore(100111033, 1011);
        System.out.println(score);
    }

    @Test
    public void insertExperimentSelected() {
        ExperimentSelected selected = new ExperimentSelected();
        selected.setExperimentId(1018);
        selected.setStudentId(100131025);
        experimentSelectedDao.insertExperimentSelected(selected);
        experimentDao.experimentSelectedNumberPlusOne(1018);
    }

    @Test
    public void deleteStudentBy() {
        int result = experimentSelectedDao.deleteStudentBy(1017);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentBy() {
        int result = experimentSelectedDao.deleteExperimentBy(1009, 100111012);
        System.out.println(result);
    }
}
