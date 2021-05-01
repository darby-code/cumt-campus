package edu.cumt.phyExperiment.dto;

import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.enums.StudentSelectedExperimentStateEnum;

public class SelectedExecution {
    /**
     * 学生所选的实验编号
     */
    private Long experimentId;
    /**
     * 实验选课结果状态
     */
    private Integer state;
    /**
     * 实验选课结果状态信息
     */
    private String stateInfo;
    /**
     * 实验选课成功后的对象
     */
    private ExperimentSelected experimentSelected;

    /**
     * 实验选课失败
     * @param experimentId
     * @param stateEnum
     */
    public SelectedExecution(Long experimentId, StudentSelectedExperimentStateEnum stateEnum) {
        this.experimentId = experimentId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 实验选课成功
     * @param experimentId
     * @param stateEnum
     * @param experimentSelected
     */
    public SelectedExecution(Long experimentId, StudentSelectedExperimentStateEnum stateEnum, ExperimentSelected experimentSelected) {
        this(experimentId, stateEnum);
        this.experimentSelected = experimentSelected;
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

    public ExperimentSelected getExperimentSelected() {
        return experimentSelected;
    }

    public void setExperimentSelected(ExperimentSelected experimentSelected) {
        this.experimentSelected = experimentSelected;
    }

    @Override
    public String toString() {
        return "SelectedExecution{" +
                "experimentId=" + experimentId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", experimentSelected=" + experimentSelected +
                '}';
    }
}
