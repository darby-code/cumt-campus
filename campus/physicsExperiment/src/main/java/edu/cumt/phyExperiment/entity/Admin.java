package edu.cumt.phyExperiment.entity;

import java.util.Date;

/**
 * 管理员的POJO类
 */
public class Admin {
    /**
     * 管理员在id，唯一
     */
    private Integer adminId;
    /**
     * 管理员账号，唯一
     */
    private String account;
    /**
     * 管理员账号密码
     */
    private String password;
    /**
     * 管理员姓名
     */
    private String name;
    /**
     * 管理员账号注册时间
     */
    private Date registryTime;

    public Admin() {}

    public Admin(Integer adminId, String account, String password, String name, Date registryTime) {
        this.adminId = adminId;
        this.account = account;
        this.password = password;
        this.name = name;
        this.registryTime = registryTime;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
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

    public Date getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(Date registryTime) {
        this.registryTime = registryTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", registryTime=" + registryTime +
                '}';
    }
}
