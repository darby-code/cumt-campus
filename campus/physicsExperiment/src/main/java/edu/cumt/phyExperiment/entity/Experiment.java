package edu.cumt.phyExperiment.entity;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
    private List<Integer> limitCollege;
    /**
     * 实验是否还有容量，true表示有
     * false表示无，不可再选
     */
    private volatile boolean allowSelected = true;

    /**
     * 实验是否结课，默认为false
     * 如果结课，表明成绩已录完，学生可以查询到成绩
     */
    private boolean finished = false;

    public Experiment() {}

    public Experiment(Integer experimentId, String experimentName, Date experimentTime
            , String experimentPlace, Integer capacity, Integer teacherId
            , Integer selectedNumber, List<Integer> limitCollege, boolean allowSelected
            , boolean finished) {
        this.experimentId = experimentId;
        this.experimentName = experimentName;
        this.experimentTime = experimentTime;
        this.experimentPlace = experimentPlace;
        this.capacity = capacity;
        this.teacherId = teacherId;
        this.selectedNumber = selectedNumber;
        this.limitCollege = limitCollege;
        this.allowSelected = allowSelected;
        this.finished = finished;
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

    public List<Integer> getLimitCollege() {
        return limitCollege;
    }

    public void setLimitCollege(List<Integer> limitCollege) {
        this.limitCollege = limitCollege;
    }

    public boolean isAllowSelected() {
        return allowSelected;
    }

    public void setAllowSelected(boolean allowSelected) {
        this.allowSelected = allowSelected;
    }

    public boolean isFinished() { return finished; }

    public void setFinished(boolean finished) { this.finished = finished; }

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
                ", allowSelected=" + allowSelected +
                ", finished=" + finished +
                '}';
    }
}
