package com.doug.ssm.dao;

import com.doug.ssm.entity.College;

import java.util.List;

public interface CollegeDao {
    /**
     * 根据学院代号查询学院名称
     * @param collegeId
     * @return
     */
    String queryCollegeNameBy(Integer collegeId);

    /**
     * 查询所有学院
     * @return
     */
    List<College> queryAllColleges();
}
