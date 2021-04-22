package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.entity.Experiment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExperimentDao {
    /**
     * 根据教师工号查询教师的实验
     * @param teacherId
     * @return
     */
    List<Experiment> queryTeacherExperimentBy(int teacherId);

    /**
     * 根据实验编号查询实验
     * @param experimentId
     * @return
     */
    Experiment queryExperimentById(int experimentId);

    /**
     * 根据实验名称查找实验，可能会返回多个结果
     * @param name
     * @return
     */
    List<Experiment> queryExperimentByName(String name);

    /**
     * 查询还没有选满的实验
     * @return
     */
    List<Experiment> queryAllowSelectedExperiments();

    /**
     * 查询已经选满的实验
     * @return
     */
    List<Experiment> queryNotAllowSelectedExperiments();

    /**
     * 查询已经结课的实验
     * @return
     */
    List<Experiment> queryFinishedExperiments();

    /**
     * 查询还没有结课的实验
     * @return
     */
    List<Experiment> queryNotFinishedExperiments();

    /**
     * 根据实验编号查询实验是否结课
     * @param experimentId
     * @return
     */
    boolean queryExperimentIsFinished(int experimentId);

    /**
     * 查询最大的实验编号
     * @return
     */
    int queryMaxExperimentId();

    /**
     * 查询所有实验
     * @return
     */
    List<Experiment> queryAllExperiments();

    /**
     * 修改实验上课时间
     * @param time
     * @return
     */
    int updateExperimentTime(@Param("experimentId") int experimentId, @Param("experimentTime") Date time);

    /**
     * 修改实验上课地址
     * @param place
     * @return
     */
    int updateExperimentPlace(@Param("experimentId") int experimentId, @Param("experimentPlace") String place);

    /**
     * 修改实验容量
     * @param experimentId
     * @param capacity
     * @return
     */
    int updateExperimentCapacity(@Param("experimentId") int experimentId, @Param("capacity") int capacity);

    /**
     * 实验已选容量加1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberPlusOne(int experimentId);

    /**
     * 实验已选容量减1
     * @param experimentId
     * @return
     */
    int experimentSelectedNumberReduceOne(int experimentId);

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
    int deleteExperimentBy(int experimentId);
}
