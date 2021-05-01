package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.College;

import java.util.List;

/**
 * CollegeService功能：
 * 根据学院代号查询学院名称  queryCollegeNameById
 * 查询所有学院信息  queryAllCollegesInfo
 * 查询一个学院的介绍 queryCollegeDescriptionById
 *
 */
public interface CollegeService {

    /**
     * 根据学院代号查询学院名称
     * @param collegeId 学院代号
     * @return 返回学院名称或null
     */
    String queryCollegeNameById(long collegeId);

    /**
     * 查询所有学院信息
     * @return
     */
    List<College> queryAllCollegesInfo();

    /**
     * 查询学院的介绍
     * @param collegeId
     * @return
     */
    String queryCollegeDescriptionById(long collegeId);
}
