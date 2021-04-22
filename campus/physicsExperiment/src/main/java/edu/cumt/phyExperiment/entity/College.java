package edu.cumt.phyExperiment.entity;

/**
 * 学院的POJO类
 */
public class College {
    /**
     * 学院代号，唯一标识符
     */
    private Integer collegeId;
    /**
     * 学院名称
     */
    private String collegeName;

    public College() {}

    public College(Integer collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
