package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.Experiment;

import java.util.List;

/**
 * ExperimentService接口功能：
 * 查看所有实验 queryAllExperiments
 * 查看某个实验 queryExperimentById queryExperimentByName
 * 根据关键词搜索实验 queryExperimentByKeyWords
 * 查看教师的所有实验 queryTeacherExperimentsByName  queryTeacherExperimentsById
 * 查看尚有余量的实验 queryAllowSelectedExperiments
 * 查看没有余量的实验 queryNotAllowSelectedExperiments
 * 查看尚未结课的实验 queryNotFinishedExperiments
 * 查看结课的实验     queryFinishedExperiments
 *
 * 新增一个实验  addNewExperiment
 * 删除一个实验  deleteExperimentById  deleteExperimentByName
 *
 * 修改实验上课时间 modifyExperimentTimeById   modifyExperimentTimeByName
 * 修改实验容量    modifyExperimentCapacityById  modifyExperimentCapacityByName
 * 实验标记为不可再选 setAllowSelectedNotAllow
 * 实验标记为结课    setFinishedFinish
 */
public interface ExperimentService {

}
