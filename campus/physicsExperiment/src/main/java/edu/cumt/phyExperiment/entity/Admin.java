package edu.cumt.phyExperiment.entity;

import java.util.Date;

/**
 * 管理员的POJO类
 */
public class Admin {
    /**
     * 管理员的流水号，唯一，自增
     */
    private Long adminId;
    /**
     * 管理员账号，唯一，非空
     */
    private String account;
    /**
     * 管理员账号密码，非空
     */
    private String password;
    /**
     * 管理员姓名，非空
     */
    private String name;
    /**
     * 管理员性别,非空
     */
    private Boolean sex;
    /**
     * 管理员账号注册时间，非空
     */
    private Date registryTime;
    /**
     * 管理员手机号，非空
     */
    private String phoneNumber;
    /**
     * 管理员邮箱
     */
    private String email;
    /**
     * 管理员qq
     */
    private String qq;
    /**
     * 管理员账号权限，便于后续开发
     */
    private Integer state;

    public Admin() {}

    public Admin(String account, String password, String name, Boolean sex
            , Date registryTime, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.registryTime = registryTime;
        this.phoneNumber = phoneNumber;
    }

    /*****************Getter和Setter以及toString方法*************************/

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(Date registryTime) {
        this.registryTime = registryTime;
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
        return "Admin{" +
                "adminId=" + adminId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", registryTime=" + registryTime +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", state=" + state +
                '}';
    }
}
