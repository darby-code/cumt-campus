package edu.cumt.phyExperiment.entity;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 物理实验的POJO类
 */
public class Experiment {
    /**
     * 实验编号，唯一标识符，自增
     */
    private Long experimentId;
    /**
     * 实验名称，非空
     */
    private String experimentName;
    /**
     * 实验时间，非空
     */
    private Date experimentTime;
    /**
     * 星期几上实验，非空
     */
    private String weekDay;
    /**
     * 实验地点，非空
     */
    private String experimentPlace;
    /**
     * 实验的教师工号
     */
    private Long teacherId;
    /**
     * 实验的教师姓名
     *
     */
    private String teacherName;
    /**
     * 实验的教师联系方式
     */
    private String phoneNumber;
    /**
     * 实验可选人数，非空
     */
    private Integer capacity;
    /**
     * 实验已选人数，非空
     */
    private Integer selectedNumber;
    /**
     * 实验是否还有容量，true表示有
     * false表示无，不可再选，非空
     */
    private volatile boolean allowSelected = true;

    /**
     * 实验是否结束，默认为false，非空
     */
    private boolean finished = false;
    /**
     * 实验权限，便于后续开发
     */
    private Integer state;

    public Experiment() {}

    public Experiment(ExperimentTemp experimentTemp) {
        this.experimentName = experimentTemp.getExperimentName();
        this.experimentTime = experimentTemp.getExperimentTime();
        this.weekDay = experimentTemp.getWeekDay();
        this.experimentPlace = experimentTemp.getExperimentPlace();
        this.teacherId = experimentTemp.getTeacherId();
        this.capacity = experimentTemp.getCapacity();
    }

    public Experiment(String experimentName, Date experimentTime, String weekDay
            , String experimentPlace, Long teacherId, String teacherName
            , String phoneNumber, Integer capacity) {
        this.experimentName = experimentName;
        this.experimentTime = experimentTime;
        this.weekDay = weekDay;
        this.experimentPlace = experimentPlace;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(Integer selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public boolean isAllowSelected() {
        return allowSelected;
    }

    public void setAllowSelected(boolean allowSelected) {
        this.allowSelected = allowSelected;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "experimentId=" + experimentId +
                ", experimentName='" + experimentName + '\'' +
                ", experimentTime=" + experimentTime +
                ", weekDay='" + weekDay + '\'' +
                ", experimentPlace='" + experimentPlace + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", capacity=" + capacity +
                ", selectedNumber=" + selectedNumber +
                ", allowSelected=" + allowSelected +
                ", finished=" + finished +
                ", state=" + state +
                '}';
    }
}
