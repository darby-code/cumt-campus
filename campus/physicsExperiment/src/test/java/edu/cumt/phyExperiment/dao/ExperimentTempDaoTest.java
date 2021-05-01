package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.ExperimentTemp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ExperimentTempDaoTest extends BaseTest {

    @Autowired
    ExperimentTempDao experimentTempDao;

    @Test
    public void newExperimentSubmitByTeacher() {
        ExperimentTemp experimentTemp = new ExperimentTemp("测试名字", new Date(), "测试星期", "测试地点", 1002502L, 7);
        int result = experimentTempDao.newExperimentSubmitByTeacher(experimentTemp);
        System.out.println(result);
    }

    @Test
    public void queryAllNewExperiments() {
        List<ExperimentTemp> list = experimentTempDao.queryAllNewExperiments();
        System.out.println(list);
    }

    @Test
    public void queryAllNewExperimentsCount() {
        int count = experimentTempDao.queryAllNewExperimentsCount();
        System.out.println(count);
    }

    @Test
    public void updateSubmitExperimentInfo() {
        ExperimentTemp experimentTemp = new ExperimentTemp("测试名字1", new Date(), "测试星期1", "测试地点1", 1002502L, 9);
        experimentTemp.setTempId(2L);
        int result = experimentTempDao.updateSubmitExperimentInfo(experimentTemp);
        System.out.println(result);
    }

    @Test
    public void deleteTempTableExperimentByAdmin() {
        int result = experimentTempDao.deleteTempTableExperimentByAdmin(2L);
        System.out.println(result);
    }
}
