package com.doug.ssm.entity;

/**
 * 学生选实验的POJO类
 */
public class ExperimentSelected {
    /**
     * 学生选实验的流水号，唯一标识符
     */
    private Integer serialId;
    /**
     * 选实验的学生学号
     */
    private Integer studentId;
    /**
     * 学生所选实验编号
     */
    private Integer experimentId;
    /**
     * 学生实验分数
     */
    private Integer score;

    public ExperimentSelected() {}

    public ExperimentSelected(Integer serialId, Integer studentId, Integer experimentId
            , Integer score) {
        this.serialId = serialId;
        this.studentId = studentId;
        this.experimentId = experimentId;
        this.score = score;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExperimentSelectedList{" +
                "serialId=" + serialId +
                ", studentId=" + studentId +
                ", experimentId=" + experimentId +
                ", score=" + score +
                '}';
    }
}
