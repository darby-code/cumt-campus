package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExperimentSelectedDaoTest extends BaseTest {

    @Autowired
    ExperimentSelectedDao experimentSelectedDao;
    @Autowired
    ExperimentDao experimentDao;

    @Test
    public void queryAllSelectedExperiments() {
        List<ExperimentSelected> list = experimentSelectedDao.queryAllSelectedExperiments();
        System.out.println(list);
    }

    @Test
    public void queryOneSelectedExperiments() {
        List<ExperimentSelected> list = experimentSelectedDao.queryOneSelectedExperiments(1013L);
        System.out.println(list);
    }

    @Test
    public void queryOneSelectedExperiment() {
        ExperimentSelected selected = experimentSelectedDao.queryOneSelectedExperiment(1009, 1001011013);
        System.out.println(selected);
    }

    @Test
    public void queryExperimentSelectedBy() {
        int experimentId = 1009;
        List<Student> list = experimentSelectedDao.queryExperimentSelectedStudentBy(experimentId);
        System.out.println(list);
    }

    @Test
    public void queryStudentSelectedExperimentsBy() {
        long studentId = 1001031122L;
        List<Experiment> list = experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
        System.out.println(list);
    }

    @Test
    public void queryScore() {
        long studentId = 1001031122;
        List<ExperimentSelected> scores = experimentSelectedDao.queryScore(studentId);
        System.out.println(scores);
        studentId = 1001011013;
        scores = experimentSelectedDao.queryScore(studentId);
        System.out.println(scores);
    }

    @Test
    public void updateScore() {
        int result = experimentSelectedDao.updateScore(1014, 1001011013, 80, true);
        System.out.println(result);
    }

    @Test
    public void insertExperimentSelected() {
        int result = experimentSelectedDao.insertExperimentSelected(1016, 1001151172);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentBy() {
        int result = experimentSelectedDao.deleteExperimentBy(1016, 1001151172);
        System.out.println(result);
    }

    @Test
    public void deleteStudentBy() {
        int result = experimentSelectedDao.deleteStudentBy(1017);
        System.out.println(result);
    }

    @Test
    public void queryIsAllowModifiedScore() {
        boolean result = experimentSelectedDao.queryIsAllowModifiedScore(1014, 1001011013);
        boolean resultOne = experimentSelectedDao.queryIsAllowModifiedScore(1016, 1001031125);
        System.out.println(result + "    " + resultOne);
    }
}
