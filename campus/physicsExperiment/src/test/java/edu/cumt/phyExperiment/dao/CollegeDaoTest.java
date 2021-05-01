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
    public void queryCollegeNameById() {
        int collegeId = 100103;
        String collegeName = collegeDao.queryCollegeNameById(collegeId);
        System.out.println(collegeName);
    }

    @Test
    public void queryCollegeDescriptionById() {
        int collegeId = 100103;
        String description = collegeDao.queryCollegeDescriptionById(collegeId);
        System.out.println(description);
    }

    @Test
    public void queryAllColleges() {
        List<College> list = collegeDao.queryAllColleges();
        System.out.println(list);
    }
}
