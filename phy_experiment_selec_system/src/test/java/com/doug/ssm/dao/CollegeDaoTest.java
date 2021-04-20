package com.doug.ssm.dao;

import com.doug.ssm.BaseTest;
import com.doug.ssm.entity.College;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CollegeDaoTest extends BaseTest {

    @Autowired
    CollegeDao collegeDao;

    @Test
    public void testQueryCollegeNameBy() {
        int collegeId = 10013;
        String collegeName = collegeDao.queryCollegeNameBy(collegeId);
        System.out.println(collegeName);
    }

    @Test
    public void testQueryAllColleges() {
        List<College> list = collegeDao.queryAllColleges();
        System.out.println(list);
    }
}
