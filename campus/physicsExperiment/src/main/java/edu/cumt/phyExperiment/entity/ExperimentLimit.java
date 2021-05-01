package edu.cumt.phyExperiment.entity;

import java.util.List;

/**
 * 选实验学院限制,用于为实验添加限选学院条件
 */
public class ExperimentLimit {
    /**
     * 该实验限制条件流水号，唯一，自增
     */
    private Long conditionId;
    /**
     * 限选实验编号，非空
     */
    private Long experimentId;
    /**
     * 限选学院代号，非空
     */
    private Long collegeId;

    public ExperimentLimit() {}

    public ExperimentLimit(Long experimentId, Long collegeId) {
        this.experimentId = experimentId;
        this.collegeId = collegeId;
    }

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    /*****************Getter和Setter以及toString方法*************************/

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return "ExperimentLimit{" +
                "conditionId=" + conditionId +
                ", experimentId=" + experimentId +
                ", collegeId=" + collegeId +
                '}';
    }
}
