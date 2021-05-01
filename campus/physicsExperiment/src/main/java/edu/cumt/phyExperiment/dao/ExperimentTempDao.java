package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentTempDao {
    /**
     * 教师发布一个新实验时要等待管理员通过，暂存到一个临时表中
     * 管理员审核通过后将其加入到实验表experiment给学生选择
     * @param experimentTemp
     * @return
     */
    int newExperimentSubmitByTeacher(ExperimentTemp experimentTemp);

    /**
     * 查询所有待审核的实验
     * @return
     */
    List<ExperimentTemp> queryAllNewExperiments();

    /**
     * 统计待审核实验数量
     * @return
     */
    int queryAllNewExperimentsCount();

    /**
     * 教师修改待审核的实验信息
     * @param experimentTemp
     * @return
     */
    int updateSubmitExperimentInfo(ExperimentTemp experimentTemp);

    /**
     * 实验审核不通过
     * @param tempId
     * @return
     */
    int deleteTempTableExperimentByAdmin(long tempId);
}
