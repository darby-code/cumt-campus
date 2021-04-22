package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.entity.College;

import java.util.List;

public interface CollegeDao {
    /**
     * 根据学院代号查询学院名称
     * @param collegeId
     * @return
     */
    String queryCollegeNameBy(int collegeId);

    /**
     * 查询学院的介绍
     * @param collegeId
     * @return
     */
    String queryCollegeDescriptionBy(int collegeId);

    /**
     * 查询所有学院
     * @return
     */
    List<College> queryAllColleges();
}
