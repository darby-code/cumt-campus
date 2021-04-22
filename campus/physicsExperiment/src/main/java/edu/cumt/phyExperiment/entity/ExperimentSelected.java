package edu.cumt.phyExperiment.entity;

/**
 * 学生选实验的POJO类
 */
public class ExperimentSelected {
    /**
     * 流水号，唯一标识符
     */
    private Integer serialId;
    /**
     * 学生所选实验编号
     */
    private Integer experimentId;
    /**
     * 学生所选实验名称
     */
    private String experimentName;
    /**
     * 选实验的学生学号
     */
    private Integer studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生实验分数
     */
    private Integer score;
    /**
     * 该标识为是否允许教师修改学生成绩
     * 教师提交成绩后就不可修改成绩
     * 只能通过管理员进行修改
     */
    private boolean allowModified = true;

    public ExperimentSelected() {}

    public ExperimentSelected(Integer experimentId, String experimentName, Integer studentId
            , String studentName, Integer score, boolean allowModified) {
        this.experimentId = experimentId;
        this.experimentName = experimentName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.score = score;
        this.allowModified = allowModified;
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

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isAllowModified() {
        return allowModified;
    }

    public void setAllowModified(boolean allowModified) {
        this.allowModified = allowModified;
    }

    @Override
    public String toString() {
        return "ExperimentSelected{" +
                "serialId=" + serialId +
                ", experimentId=" + experimentId +
                ", experimentName='" + experimentName + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                ", allowModified=" + allowModified +
                '}';
    }
}
