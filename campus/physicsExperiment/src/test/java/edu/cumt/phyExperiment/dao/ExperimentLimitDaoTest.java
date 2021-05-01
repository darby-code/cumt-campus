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
        int experimentId = 1011;
        List<Long> list = experimentLimitDao.queryExperimentLimitCollegeIdById(experimentId);
        System.out.println(list);
    }

    @Test
    public void insertCollegeLimit() {
        int result = experimentLimitDao.insertCollegeLimit(1009L, 100115L);
        System.out.println(result);
    }

    @Test
    public void deleteCollegeLimit() {
        int result = experimentLimitDao.deleteCollegeLimit(1009L, 100115L);
        System.out.println(result);
    }

    @Test
    public void deleteExperimentLimitBy() {
        long experimentId = 1009L;
        int result = experimentLimitDao.deleteExperimentLimitById(experimentId);
        System.out.println(result);
    }
}
