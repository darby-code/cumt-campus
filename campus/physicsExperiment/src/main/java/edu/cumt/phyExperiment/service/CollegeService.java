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

    String queryCollegeNameById(int collegeId);

    List<College> queryAllCollegesInfo();

    String queryCollegeDescriptionById(int collegeId);
}
