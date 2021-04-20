package com.doug.ssm.entity;

import java.util.Date;

/**
 * 将教师和学生抽象成一个用户类
 */
public class User {
    /**
     * 用户的账号 学生为学号，教师为工号
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 账号状态
     */
    private Integer status;
    /**
     * 账号创建时间
     */
    private Date registryDate;
    /**
     * 账户的ip地址
     */
    private String regionIp;

    public User() {}

    public User(Integer id, String username, String password, String role
            , Integer status, Date registryDate, String regionIp) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.registryDate = registryDate;
        this.regionIp = regionIp;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public String getRegionIp() {
        return regionIp;
    }

    public void setRegionIp(String regionIp) {
        this.regionIp = regionIp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", registryDate=" + registryDate +
                ", regionIp='" + regionIp + '\'' +
                '}';
    }
}
