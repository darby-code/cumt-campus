package edu.cumt.phyExperiment.entity;

/**
 * 学院的POJO类
 */
public class College {
    /**
     * 学院代号，唯一标识符，自增
     */
    private Long collegeId;
    /**
     * 学院名称，非空
     */
    private String collegeName;
    /**
     * 学院描述
     */
    private String description;

    public College() {}

    public College(String collegeName, String description) {
        this.collegeName = collegeName;
        this.description = description;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    /*****************Getter和Setter以及toString方法*************************/

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
