package edu.cumt.phyExperiment.dto;

import edu.cumt.phyExperiment.enums.StudentSelectedExperimentStateEnum;

public class DropExperimentExecution {
    /**
     * 学生退选的实验编号
     */
    private Long experimentId;
    /**
     * 退选状态字
     */
    private Integer state;
    /**
     * 退选消息
     */
    private String stateInfo;

    public DropExperimentExecution(Long experimentId, StudentSelectedExperimentStateEnum stateEnum) {
        this.experimentId = experimentId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "DropExperimentExecution{" +
                "experimentId=" + experimentId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
