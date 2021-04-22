package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.College;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CollegeDaoTest extends BaseTest {

    @Autowired
    CollegeDao collegeDao;

    @Test
    public void queryCollegeNameBy() {
        int collegeId = 10013;
        String collegeName = collegeDao.queryCollegeNameBy(collegeId);
        System.out.println(collegeName);
    }

    @Test
    public void queryCollegeDescriptionBy() {
        int collegeId = 10013;
        String description = collegeDao.queryCollegeDescriptionBy(collegeId);
        System.out.println(description);
    }

    @Test
    public void queryAllColleges() {
        List<College> list = collegeDao.queryAllColleges();
        System.out.println(list);
    }
}
