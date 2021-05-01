package edu.cumt.phyExperiment.entity;

/**
 * 教师的POJO类
 */
public class Teacher {
    /**
     * 教师工号，唯一标识符，非空，非自增
     */
    private Long teacherId;
    /**
     * 教师姓名，非空
     */
    private String teacherName;
    /**
     * 教师所属学院，非空
     */
    private College college;
    /**
     * 教师登录系统密码，非空
     */
    private String password;
    /**
     * 教师性别，非空
     */
    private Boolean sex;
    /**
     * 教师手机号
     */
    private String phoneNumber;
    /**
     * 教师邮箱
     */
    private String email;
    /**
     * 教师qq
     */
    private String qq;
    /**
     * 教师账号权限，便于后续开发
     */
    private Integer state;

    public Teacher() {}

    public Teacher(Long teacherId, String teacherName, College college, String password
            , Boolean sex, String phoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.college = college;
        this.password = password;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    /*****************Getter和Setter以及toString方法*************************/
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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", college=" + college +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", state=" + state +
                '}';
    }
}
