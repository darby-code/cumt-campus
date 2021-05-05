package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.ExperimentTemp;

import java.util.Date;
import java.util.List;

public interface ExperimentTempService {
    /**
     * 教师发布一个新实验时要等待管理员通过，暂存到一个临时表中
     * 管理员审核通过后将其加入到实验表experiment给学生选择
     * @param experimentTemp
     * @return
     */
    int submitNewExperiment(ExperimentTemp experimentTemp);

    /**
     * 查询审核表中的所有实验
     * @return
     */
    List<ExperimentTemp> queryAllTempExperiments();

    /**
     * 查询所有待审核的实验
     * @return
     */
    List<ExperimentTemp> queryAllAuditExperiments();

    /**
     * 查询所有审核未通过实验
     */
    List<ExperimentTemp> queryAllNotPassExperiments();

    /**
     * 查询所有审核通过的实验
     * @return
     */
    List<ExperimentTemp> queryAllPassExperiments();

    /**
     * 统计待审核实验数量
     * @return
     */
    int queryAuditExperimentsCount();

    /**
     * 统计审核不通过实验数量
     * @return
     */
    int queryNotPassExperimentsCount();

    /**
     * 统计审核通过的实验数量
     * @return
     */
    int queryPassExperimentsCount();

    /**
     * 查询一个教师发布的实验
     * @param submitTeacherId
     * @return
     */
    List<ExperimentTemp> queryTeacherSubmitExperiments(long submitTeacherId);

    /**
     * 修改待审核的实验信息
     * @param experimentTemp
     * @return
     */
    int updateSubmitExperimentInfo(ExperimentTemp experimentTemp);

    /**
     * 管理员修改待审核的实验状态
     * @param tempId
     * @param state
     * @param auditAdminAccount
     * @return
     */
    int updateExperimentState(long tempId, int state, String auditAdminAccount);

    /**
     * 管理员审核通过并将实验加入到实验表中供学生选择
     * @param tempId
     * @param auditAdminAccount
     * @return
     */
    int auditPassAndRelease(long tempId, String auditAdminAccount);
}
