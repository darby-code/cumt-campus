package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.ExperimentLimit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 实验限选
 */
public interface ExperimentLimitDao {
    /**
     *  查询限选实验的学院代号
     * @param experimentId
     * @return
     */
    List<Long> queryExperimentLimitCollegeIdById(long experimentId);

    /**
     * 新增一个实验的限选条件，插入前要判断是否已存在记录
     * 存在则不进行插入
     * @param experimentId
     * @param collegeId
     * @return
     */
    int insertCollegeLimit(@Param("experimentId") long experimentId, @Param("collegeId") long collegeId);

    /**
     * 删除一个实验的限选条件
     * @param collegeId
     * @return
     */
    int deleteCollegeLimit(@Param("experimentId") long experimentId, @Param("collegeId") long collegeId);

    /**
     * 删除实验的所有限选条件
     * @param experimentId
     * @return
     */
    int deleteExperimentLimitById(long experimentId);
}
