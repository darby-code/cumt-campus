package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;

import java.util.Date;
import java.util.List;

/**
 * ExperimentService接口功能：
 * 查看所有实验 queryAllExperiments
 * 查看某个实验 queryExperimentById
 * 根据实验名称查找实验 queryExperimentByName
 * 根据关键词搜索实验 queryExperimentByKeyWords
 * 查看教师的所有实验 queryTeacherExperimentsById
 * 查看尚有余量的实验 queryAllowSelectedExperiments
 * 查看没有余量的实验 queryNotAllowSelectedExperiments
 * 查看已经出成绩的实验  queryFinishedExperiments
 *
 * 新增一个实验  addNewExperiment
 * 删除一个实验  deleteExperimentById
 *
 * 修改实验信息 modifyExperiment
 * 实验标记为不可再选 setExperimentNotAllowSelected
 * 实验标记为结课    setExperimentFinished
 */
public interface ExperimentService {
    /**
     * 查看所有实验
     * @return
     */
    List<Experiment> queryAllExperiments();

    /**
     * 根据实验编号查看某个实验
     * @param experimentId
     * @return
     */
    Experiment queryExperimentById(long experimentId);

    /**
     * 根据实验名称查找实验
     * @param experimentName
     * @return
     */
    List<Experiment> queryExperimentByName(String experimentName);

    /**
     * 根据关键词搜索实验
     * @param words
     * @return
     */
    List<Experiment> queryExperimentByKeyWords(String words);

    /**
     * 根据教师工号查看教师的所有实验
     * @param teacherId
     * @return
     */
    List<Experiment> queryTeacherExperimentsById(long teacherId);

    /**
     * 查看尚有余量的实验
     * @return
     */
    List<Experiment> queryAllowSelectedExperiments();

    /**
     * 查看没有余量的实验
     * @return
     */
    List<Experiment> queryNotAllowSelectedExperiments();

    /**
     * 查看已经出成绩的实验
     * @return
     */
    List<Experiment> queryFinishedExperiments();

    /**
     * 新增一个实验
     * @param experiment
     * @return
     */
    int addNewExperiment(Experiment experiment);

    /**
     * 根据实验编号删除一个实验
     * @param experimentId
     * @return
     */
    int deleteExperimentById(long experimentId);

    /**
     * 修改实验信息，管理员权限
     * @param experiment
     * @return
     */
    int modifyExperiment(Experiment experiment);


    /**
     * 实验标记为不可再选
     * @param experimentId
     * @return
     */
    int setExperimentNotAllowSelected(long experimentId);

    /**
     * 实验标记为结课
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
