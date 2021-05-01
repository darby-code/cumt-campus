package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentSelectedDao {

    /**
     * 查询所有实验选课记录
     * @return
     */
    List<ExperimentSelected> queryAllSelectedExperiments();

    /**
     * 查询一条实验选课记录
     * @param experimentId
     * @param studentId
     * @return
     */
    ExperimentSelected queryOneSelectedExperiment(@Param("experimentId") long experimentId, @Param("studentId") long studentId);

    /**
     * 查看一个实验的选课学生
     * @param experimentId
     * @return
     */
    List<Student> queryExperimentSelectedStudentBy(long experimentId);

    /**
     * 查询一个学生所选实验
     * @param studentId
     * @return
     */
    List<Experiment> queryStudentSelectedExperimentsBy(long studentId);

    /**
     * 学生查询已选实验的成绩，没有结课或没有录入成绩实验的不显示
     * @param studentId
     * @return
     */
    List<ExperimentSelected> queryScore(long studentId);

    /**
     * 录入成绩
     * @param experimentId
     * @param studentId
     * @param score
     * @return
     */
    int updateScore(@Param("experimentId") long experimentId, @Param("studentId") long studentId
            , @Param("score") int score, @Param("allowModified") boolean allowModified);

    /**
     * 新增一个实验选课记录
     * @param experimentId
     * @param studentId
     * @return
     */
    int insertExperimentSelected(@Param("experimentId") long experimentId, @Param("studentId") long studentId);

    /**
     * 退选实验编号对应实验已选的全部学生
     * @param experimentId
     * @return
     */
    int deleteStudentBy(long experimentId);

    /**
     * 删除一个实验选课记录
     * @param experimentId
     * @param studentId
     * @return
     */
    int deleteExperimentBy(@Param("experimentId") long experimentId, @Param("studentId") long studentId);

    /**
     * 查询一个实验是否可以修改成绩
     * @param experimentId
     * @return
     */
    boolean queryIsAllowModifiedScore(@Param("experimentId") long experimentId, @Param("studentId") long studentId);
}
