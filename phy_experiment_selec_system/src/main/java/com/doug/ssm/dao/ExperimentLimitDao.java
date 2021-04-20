package com.doug.ssm.dao;

import com.doug.ssm.entity.ExperimentLimit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentLimitDao {
    /**
     *  根据实验编号查询限选学院的学院代号
     * @param experimentId
     * @return
     */
    List<Integer> queryExperimentLimitCollegeIdBy(Integer experimentId);

    /**
     * 修改限选条件
     * @param experimentLimit
     * @return
     */
    int updateExperimentLimit(ExperimentLimit experimentLimit);

    /**
     * 新增一个实验的限选条件
     * @param experimentLimit
     * @return
     */
    int insertCollegeLimit(ExperimentLimit experimentLimit);

    /**
     * 删除一个的限选条件
     * @param collegeId
     * @return
     */
    int deleteCollegeLimit(@Param("experimentId") Integer experimentId, @Param("collegeId") Integer collegeId);

    /**
     * 删除实验的所有限选条件
     * @param experimentId
     * @return
     */
    int deleteExperimentLimitBy(Integer experimentId);
}
