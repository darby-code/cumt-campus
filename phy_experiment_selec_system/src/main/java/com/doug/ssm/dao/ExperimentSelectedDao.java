package com.doug.ssm.dao;

import com.doug.ssm.entity.ExperimentSelected;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentSelectedDao {

    /**
     * 查看一个实验的选课情况
     * @param experimentId
     * @return
     */
    List<ExperimentSelected> queryExperimentSelectedBy(Integer experimentId);

    /**
     * 查询一个学生所选的所有实验的实验编号
     * @param studentId
     * @return
     */
    List<Integer> queryStudentSelectedExperimentsBy(Integer studentId);

    /**
     * 查询成绩
     * @param studentId
     * @param experimentId
     * @return
     */
    int queryScore(@Param("studentId") Integer studentId, @Param("experimentId") Integer experimentId);

    /**
     * 录入成绩
     * @param experimentSelected
     * @return
     */
    int updateScore(ExperimentSelected experimentSelected);

    /**
     * 新增一个实验选课记录
     * @param experimentSelected
     * @return
     */
    int insertExperimentSelected(ExperimentSelected experimentSelected);

    /**
     * 退选实验编号对应实验已选的全部学生
     * @param experimentId
     * @return
     */
    int deleteStudentBy(Integer experimentId);

    /**
     * 删除一个实验选课记录
     * @param experimentSelected
     * @return
     */
    int deleteExperimentBy(ExperimentSelected experimentSelected);
}
