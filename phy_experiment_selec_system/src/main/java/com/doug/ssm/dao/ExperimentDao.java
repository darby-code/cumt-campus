package com.doug.ssm.dao;

import com.doug.ssm.entity.College;
import com.doug.ssm.entity.Experiment;
import com.doug.ssm.entity.ExperimentLimit;
import com.doug.ssm.entity.ExperimentSelected;

import java.util.List;

public interface ExperimentDao {
    /**
     * 根据教师工号查询教师的实验
     * @param teacherId
     * @return
     */
    List<Experiment> queryExperimentsBy(Integer teacherId);

    /**
     * 根据实验编号查询实验
     * @param experimentId
     * @return
     */
    Experiment queryExperimentBy(Integer experimentId);

    /**
     * 查询最大的实验编号，意味着大于这个实验编号的实验不存在
     * @return
     */
    int queryMaxExperimentId();

    /**
     * 查询所有实验
     * @return
     */
    List<Experiment> queryAllExperiments();

    /**
     * 修改一个实验的信息
     * @param experiment
     * @return
     */
    int updateExperiment(Experiment experiment);

    /**
     * 实验已选容量加1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberPlusOne(Integer experimentId);

    /**
     * 实验已选容量减1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberReduceOne(Integer experimentId);

    /**
     * 新增一个新的实验
     * @param experiment
     * @return
     */
    int insertExperiment(Experiment experiment);

    /**
     * 删除实验编号对应的实验
     * @param experimentId
     * @return
     */
    int deleteExperimentBy(Integer experimentId);
}
