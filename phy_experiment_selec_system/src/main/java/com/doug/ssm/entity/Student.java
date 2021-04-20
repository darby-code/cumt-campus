package com.doug.ssm.entity;

/**
 * 学生的POJO类
 */
public class Student {
    /**
     * 学生学号
     */
    private Integer studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生登录密码，初始密码为学号
     */
    private String password;
    /**
     * 学生所属学院代号
     */
    private Integer collegeId;
    /**
     * 学生所属学院名称
     */
    private String collegeName;
    /**
     * 学生所选实验成绩,便于教务处修改
     */
    private Integer score;

    public Student() {}

    public Student(Integer studentId, String studentName, String password
            , Integer collegeId, String collegeName, Integer score) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.score = score;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", score=" + score +
                '}';
    }
}
