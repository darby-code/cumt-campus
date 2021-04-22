package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.ExperimentLimit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperimentLimitDao {
    /**
     *  根据实验编号查询限选学院的学院代号
     * @param experimentId
     * @return
     */
    List<Integer> queryExperimentLimitCollegeIdBy(int experimentId);

    /**
     * 新增一个实验的限选条件
     * @param experimentId
     * @param collegeId
     * @return
     */
    int insertCollegeLimit(@Param("experimentId") int experimentId, @Param("collegeId") int collegeId);

    /**
     * 删除一个实验的限选条件
     * @param collegeId
     * @return
     */
    int deleteCollegeLimit(@Param("experimentId") int experimentId, @Param("collegeId") int collegeId);

    /**
     * 删除实验的所有限选条件
     * @param experimentId
     * @return
     */
    int deleteExperimentLimitBy(int experimentId);
}
