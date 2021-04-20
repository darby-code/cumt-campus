package com.doug.ssm.entity;

import java.util.Date;
import java.util.List;

/**
 * 物理实验的POJO类
 */
public class Experiment {
    /**
     * 实验编号，唯一标识符
     */
    private Integer experimentId;
    /**
     * 实验名称
     */
    private String experimentName;
    /**
     * 实验时间
     */
    private Date experimentTime;
    /**
     * 实验地点
     */
    private String experimentPlace;
    /**
     * 实验容量
     */
    private Integer capacity;
    /**
     * 实验的教师工号
     */
    private Integer teacherId;
    /**
     * 实验已选人数
     */
    private Integer selectedNumber;
    /**
     * 该实验的选课只限制对某些学院的学生开放
     */
    private List<String> limitCollege;
    /**
     * 实验总成绩
     */
    private Integer score;
    /**
     * 是否被选上，如果为1表明该实验对象已被学生选择
     * 若为0表示该实验对象可以被学生选择
     */
    private Integer isSelected;

    public Experiment() {}

    public Experiment(Integer experimentId, String experimentName, Date experimentTime
            , String experimentPlace, Integer capacity, Integer teacherId
            , Integer selectedNumber, List<String> limitCollege, Integer score, Integer isSelected) {
        this.experimentId = experimentId;
        this.experimentName = experimentName;
        this.experimentTime = experimentTime;
        this.experimentPlace = experimentPlace;
        this.capacity = capacity;
        this.teacherId = teacherId;
        this.selectedNumber = selectedNumber;
        this.limitCollege = limitCollege;
        this.score = score;
        this.isSelected = isSelected;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public Date getExperimentTime() {
        return experimentTime;
    }

    public void setExperimentTime(Date experimentTime) {
        this.experimentTime = experimentTime;
    }

    public String getExperimentPlace() {
        return experimentPlace;
    }

    public void setExperimentPlace(String experimentPlace) {
        this.experimentPlace = experimentPlace;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(Integer selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public List<String> getLimitCollege() {
        return limitCollege;
    }

    public void setLimitCollege(List<String> limitCollege) {
        this.limitCollege = limitCollege;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "experimentId=" + experimentId +
                ", experimentName='" + experimentName + '\'' +
                ", experimentTime=" + experimentTime +
                ", experimentPlace='" + experimentPlace + '\'' +
                ", capacity=" + capacity +
                ", teacherId=" + teacherId +
                ", selectedNumber=" + selectedNumber +
                ", limitCollege=" + limitCollege +
                ", score=" + score +
                ", isSelected=" + isSelected +
                '}';
    }
}
