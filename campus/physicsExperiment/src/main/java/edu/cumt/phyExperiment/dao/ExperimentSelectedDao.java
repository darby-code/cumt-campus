package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.ExperimentSelected;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentSelectedDao {

    /**
     * 查看一个实验的选课情况
     * @param experimentId
     * @return
     */
    List<ExperimentSelected> queryExperimentSelectedBy(int experimentId);

    /**
     * 查询一个学生所选实验
     * @param studentId
     * @return
     */
    List<ExperimentSelected> queryStudentSelectedExperimentsBy(int studentId);

    /**
     * 学生查询一个实验的成绩，如果没有该实验没有结课
     * 则返回一个NULL,要捕获异常
     * @param studentId
     * @param experimentId
     * @return
     */
    Integer queryScore(@Param("studentId") int studentId, @Param("experimentId") int experimentId);

    /**
     * 查询一个学生所选实验，实验已经结课的成绩
     * 用于成绩查询列表
     * @param studentId
     * @return
     */
    List<ExperimentSelected> queryIsFinishedExperimentScore(int studentId);

    /**
     * 录入成绩
     * @param experimentId
     * @param studentId
     * @param score
     * @return
     */
    int updateScore(@Param("experimentId") int experimentId, @Param("studentId") int studentId
            , @Param("score") int score, @Param("allowModified") boolean allowModified);

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
    int deleteStudentBy(int experimentId);

    /**
     * 删除一个实验选课记录
     * @param experimentId
     * @param studentId
     * @return
     */
    int deleteExperimentBy(@Param("experimentId") int experimentId, @Param("studentId") int studentId);

    /**
     * 查询一个实验是否可以修改成绩
     * @param experimentId
     * @return
     */
    boolean queryIsAllowModifiedScore(int experimentId);
}
