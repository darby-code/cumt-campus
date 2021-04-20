package com.doug.ssm.entity;

/**
 * 教师的POJO类
 */
public class Teacher {
    /**
     * 教师工号，唯一标识符
     */
    private Integer teacherId;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 教师登录系统密码
     */
    private String password;

    public Teacher() {}

    public Teacher(Integer teacherId, String teacherName, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.password = password;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
