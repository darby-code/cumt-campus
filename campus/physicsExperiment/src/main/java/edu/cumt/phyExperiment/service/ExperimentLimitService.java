package edu.cumt.phyExperiment.service;

import java.util.List;

/**
 * ExperimentLimitService功能：
 * 查询限选某个实验的学院代号   queryExperimentAllowSelectedColleges
 * 为某个实验添加限选学院   addConditionAtExperiment
 * 删除某个实验的一个限选学院   moveConditionAtExperiment
 * 删除实验的所有限选学院   moveAllConditionsAtExperiment
 */
public interface ExperimentLimitService {
    /**
     * 查询限选某个实验的学院代号
     * @param experimentId 查询的实验编号
     * @return 实验限选的学院代号，如果为null，表示该实验没有限选条件
     */
    List<Integer> queryExperimentAllowSelectedColleges(int experimentId);

    /**
     * 为某个实验添加限选学院
     * @param experimentId 添加限选条件的实验编号
     * @param collegeConditions 添加的限选学院的代号
     * @return 添加限选条件的个数
     */
    int addConditionAtExperiment(int experimentId, List<Integer> collegeConditions);

    /**
     * 删除实验的一个限选学院
     * @param experimentId 实验编号
     * @param collegeId 删除的限选学院代号
     * @return true表示删除成功，false表示删除失败
     */
    boolean moveConditionAtExperiment(int experimentId, int collegeId);

    /**
     * 删除实验的所有限选学院
     * @param experimentId 实验编号
     * @return 删除的记录个数
     */
    int moveAllConditionsAtExperiment(int experimentId);
}
