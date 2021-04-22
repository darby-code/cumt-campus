package edu.cumt.phyExperiment.entity;

import java.util.Date;

/**
 * 将教师、学生、管理员抽象成一个用户类
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

    public User() {}

    public User(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}' + "\n";
    }
}
