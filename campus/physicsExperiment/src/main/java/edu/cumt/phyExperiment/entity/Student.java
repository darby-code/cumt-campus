package edu.cumt.phyExperiment.entity;

/**
 * 学生的POJO类
 */
public class Student {
    /**
     * 学生学号, 唯一，非自增，非空
     */
    private Long studentId;
    /**
     * 学生姓名，非空
     */
    private String studentName;
    /**
     * 学生登录密码，初始密码为学号，非空
     */
    private String password;
    /**
     * 学生所属学院，非空
     */
    private College college;
    /**
     * 学生所在年级、班级信息，非空
     */
    private String classInfo;
    /**
     * 学生性别，非空
     */
    private Boolean sex;
    /**
     * 学生手机号，非空
     */
    private String phoneNumber;
    /**
     * 学生邮箱
     */
    private String email;
    /**
     * 学生QQ
     */
    private String qq;
    /**
     * 学生账号权限，便于后续开发
     */
    private Integer state;

    public Student() {}

    public Student(Long studentId, String studentName, String password, College college
            , String classInfo, Boolean sex, String phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
        this.college = college;
        this.classInfo = classInfo;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
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
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", college=" + college +
                ", classInfo='" + classInfo + '\'' +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", state=" + state +
                '}';
    }
}
