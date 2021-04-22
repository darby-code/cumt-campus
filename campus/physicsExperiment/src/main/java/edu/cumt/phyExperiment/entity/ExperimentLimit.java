package edu.cumt.phyExperiment.entity;

/**
 * 选实验学院限制
 */
public class ExperimentLimit {
    /**
     * 流水号，唯一标识符
     */
    private Integer conditionId;
    /**
     * 限选实验编号
     */
    private Integer experimentId;
    /**
     * 限选学院代号
     */
    private Integer collegeId;

    public ExperimentLimit() {}

    public ExperimentLimit(Integer conditionId, Integer experimentId, Integer collegeId) {
        this.conditionId = conditionId;
        this.experimentId = experimentId;
        this.collegeId = collegeId;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return "ExperimentLimitList{" +
                "conditionId=" + conditionId +
                ", experimentId=" + experimentId +
                ", collegeId=" + collegeId +
                '}' + "\n";
    }
}
