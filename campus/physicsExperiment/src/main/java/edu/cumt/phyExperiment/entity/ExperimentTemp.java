package edu.cumt.phyExperiment.entity;

import java.util.Date;

/**
 * 用于教师发布实验，管理员审核
 */
public class ExperimentTemp {
    /**
     * 流水号，唯一，自增，用于实验审核不通过时，管理员删除
     */
    private Long tempId;
    /**
     * 信息同experiment
     */
    private String experimentName;
    private Date experimentTime;
    private String weekDay;
    private String experimentPlace;
    private Long teacherId;
    private Integer capacity;

    public ExperimentTemp() {}

    public ExperimentTemp(String experimentName, Date experimentTime, String weekDay
            , String experimentPlace, Long teacherId, Integer capacity) {
        this.experimentName = experimentName;
        this.experimentTime = experimentTime;
        this.weekDay = weekDay;
        this.experimentPlace = experimentPlace;
        this.teacherId = teacherId;
        this.capacity = capacity;
    }

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
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

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getExperimentPlace() {
        return experimentPlace;
    }

    public void setExperimentPlace(String experimentPlace) {
        this.experimentPlace = experimentPlace;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "ExperimentTemp{" +
                "tempId=" + tempId +
                ", experimentName='" + experimentName + '\'' +
                ", experimentTime=" + experimentTime +
                ", weekDay='" + weekDay + '\'' +
                ", experimentPlace='" + experimentPlace + '\'' +
                ", teacherId=" + teacherId +
                ", capacity=" + capacity +
                '}';
    }
}
