package edu.cumt.phyExperiment.entity;

import java.util.Date;

/**
 * 学生选实验的POJO类
 */
public class ExperimentSelected {
    /**
     * 流水号，自增，唯一标识符
     */
    private Long serialId;

    /**
     * 已选实验的相关信息
     */
    private Experiment experiment;
    /**
     * 选实验学生相关信息
     */
    private Student student;
    /**
     * 学生实验成绩
     */
    private Integer score;
    /**
     * 用于教师录入成绩
     * 该标识为是否允许教师修改学生成绩
     * 教师提交成绩后就不可修改成绩
     * 只能通过管理员进行修改
     */
    private Boolean allowModified;

    public ExperimentSelected() {}

    public ExperimentSelected(Experiment experiment, Student student) {
        this.experiment = experiment;
        this.student = student;
    }
    /*****************Getter和Setter以及toString方法*************************/
    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getAllowModified() {
        return allowModified;
    }

    public void setAllowModified(Boolean allowModified) {
        this.allowModified = allowModified;
    }

    @Override
    public String toString() {
        return "ExperimentSelected{" +
                "serialId=" + serialId +
                ", experiment=" + experiment +
                ", student=" + student +
                ", score=" + score +
                ", allowModified=" + allowModified +
                '}';
    }
}
