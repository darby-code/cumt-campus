package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.entity.Experiment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExperimentDao {
    /**
     * 查询所有实验
     * @return
     */
    List<Experiment> queryAllExperiments();

    /**
     * 查询还允许选课的实验
     * @return
     */
    List<Experiment> queryAllowSelectedExperiments();

    /**
     * 查询已经截止选课的实验
     * @return
     */
    List<Experiment> queryNotAllowSelectedExperiments();

    /**
     * 查询已经结束，出成绩的实验
     * @return
     */
    List<Experiment> queryFinishedExperiments();

    /**
     * 根据教师工号查询教师的实验
     * @param teacherId
     * @return
     */
    List<Experiment> queryTeacherExperiments(long teacherId);

    /**
     * 根据关键词查找实验
     * @param words
     * @return
     */
    List<Experiment> queryExperimentsByKeyWords(String words);

    /**
     * 根据实验编号查询实验
     * @param experimentId
     * @return
     */
    Experiment queryExperimentById(long experimentId);

    /**
     * 获取实验的日期
     * @param experimentId
     * @return
     */
    Date queryExperimentDateById(long experimentId);

    /**
     * 根据实验名称查询实验
     * @param experimentName
     * @return
     */
    List<Experiment> queryExperimentByName(String experimentName);

    /**
     * 查询最大的实验编号
     * @return
     */
    long queryMaxExperimentId();

    /**
     * 修改实验的信息
     * @param experiment
     * @return
     */
    int updateExperimentInfo(Experiment experiment);

    /**
     * 实验已选容量加1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberPlusOne(long experimentId);

    /**
     * 实验已选容量减1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberReduceOne(long experimentId);

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
    int deleteExperimentBy(long experimentId);

    /**
     * 截止一个实验的选课
     * @param experimentId
     * @return
     */
    int setExperimentNotAllowSelected(long experimentId);

    /**
     * 教师录完成绩后，实验置为结束状态
     * 供学生查询成绩
     * @param experimentId
     * @return
     */
    int setExperimentFinished(long experimentId);

    /**
     * 查询所有的实验名称
     * @return
     */
    List<String> queryExperimentName();

    /**
     * 查询所有的上课教室
     * @return
     */
    List<String> queryExperimentPlace();
}
