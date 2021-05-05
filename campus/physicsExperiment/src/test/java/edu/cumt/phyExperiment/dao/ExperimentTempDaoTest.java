package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.ExperimentTemp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExperimentTempDaoTest extends BaseTest {

    @Autowired
    ExperimentTempDao experimentTempDao;

    @Test
    public void submitNewExperiment() {
        ExperimentTemp temp = new ExperimentTemp(1002501L, "测试实验名称3", new Date(), "测试时间3",
                "测试实验地点3", 1002501L, 10);
        int result = experimentTempDao.submitNewExperiment(temp);
        System.out.println(result);
    }

    @Test
    public void queryAllAuditExperiments() {
        List<ExperimentTemp> experimentTemps = experimentTempDao.queryAllAuditExperiments();
        System.out.println(experimentTemps);
    }

    @Test
    public void queryAllNotPassExperiments() {
        List<ExperimentTemp> experimentTemps = experimentTempDao.queryAllNotPassExperiments();
        System.out.println(experimentTemps);
    }

    @Test
    public void queryAllPassExperiments() {
        List<ExperimentTemp> experimentTemps = experimentTempDao.queryAllPassExperiments();
        System.out.println(experimentTemps);
    }

    @Test
    public void queryAuditExperimentsCount() {
        int results = experimentTempDao.queryAuditExperimentsCount();
        System.out.println(results);
    }

    @Test
    public void queryNotPassExperimentsCount() {
        int results = experimentTempDao.queryNotPassExperimentsCount();
        System.out.println(results);
    }

    @Test
    public void queryPassExperimentsCount() {
        int results = experimentTempDao.queryPassExperimentsCount();
        System.out.println(results);
    }

    @Test
    public void queryTeacherSubmitExperiments() {
        List<ExperimentTemp> experimentTemps = experimentTempDao.queryTeacherSubmitExperiments(1002501L);
        System.out.println(experimentTemps);
        experimentTemps = experimentTempDao.queryTeacherSubmitExperiments(1002502);
        System.out.println(experimentTemps);
    }


}
