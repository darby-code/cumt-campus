package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.ExperimentLimit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExperimentLimitDaoTest extends BaseTest {

    @Autowired
    ExperimentLimitDao experimentLimitDao;

    @Test
    public void queryExperimentLimitCollegeIdBy() {
        int experimentId = 1012;
        List<Integer> list = experimentLimitDao.queryExperimentLimitCollegeIdBy(experimentId);
        System.out.println(list);
    }

    @Test
    public void insertCollegeLimit() {
        ExperimentLimit experimentLimit = new ExperimentLimit(0, 1009, 10012);
        int result = experimentLimitDao.insertCollegeLimit(experimentLimit);
        System.out.println(result);
    }

    @Test
    public void deleteCollegeLimit() {
        int result = experimentLimitDao.deleteCollegeLimit(1009, 10013);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentLimitBy() {
        int experimentId = 1009;
        int result = experimentLimitDao.deleteExperimentLimitBy(experimentId);
        System.out.println(result);
    }
}
