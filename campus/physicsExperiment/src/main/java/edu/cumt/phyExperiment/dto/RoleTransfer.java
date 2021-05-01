package edu.cumt.phyExperiment.dto;

import edu.cumt.phyExperiment.enums.RoleStateEnum;

/**
 * 用于学生、老师、管理员登录
 */
public class RoleTransfer {
    /**
     * 登录用户的姓名
     */
    private String name;
    /**
     * 登录用户的密码
     */
    private String password;
    /**
     * 用户对应数据字典
     */
    private RoleStateEnum roleStateEnum;

    private int studentOrTeacherId;

    private String adminAccount;

    public RoleTransfer() {}

    public RoleTransfer(int studentOrTeacherId, String name, String password, RoleStateEnum roleStateEnum) {
        this.studentOrTeacherId = studentOrTeacherId;
        this.name = name;
        this.password = password;
        this.roleStateEnum = roleStateEnum;
    }

    public RoleTransfer(String adminAccount, String name, String password, RoleStateEnum roleStateEnum) {
        this.adminAccount = adminAccount;
        this.name = name;
        this.password = password;
        this.roleStateEnum = roleStateEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleStateEnum getRoleStateEnum() {
        return roleStateEnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentOrTeacherId() {
        return studentOrTeacherId;
    }

    public void setStudentOrTeacherId(int studentOrTeacherId) {
        this.studentOrTeacherId = studentOrTeacherId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public void setRoleStateEnum(RoleStateEnum roleStateEnum) {
        this.roleStateEnum = roleStateEnum;
    }
}
