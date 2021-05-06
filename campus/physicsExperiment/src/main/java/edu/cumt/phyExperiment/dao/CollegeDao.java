package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.entity.College;

import java.util.List;

/**
 * 学院
 */
public interface CollegeDao {
    /**
     * 查询学院名称
     * @param collegeId
     * @return
     */
    String queryCollegeNameById(long collegeId);

    /**
     * 查询学院的介绍
     * @param collegeId
     * @return
     */
    String queryCollegeDescriptionById(long collegeId);

    /**
     * 查询所有学院
     * @return
     */
    List<College> queryAllColleges();
}
