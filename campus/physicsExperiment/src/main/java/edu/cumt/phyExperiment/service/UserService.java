package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.User;
import edu.cumt.phyExperiment.enums.RoleStateEnum;

/**
 * UserService功能：
 * 学生简单注册  studentRegistry
 * 教师简单注册  teacherRegistry
 * 学生、教师、管理员登录   userLogin
 * 学生、教师、管理员修改密码  modifyPassword
 *
 */
public interface UserService {

    /**
     * 学生简单注册，学号和数据库中的比对一下，存在就注册成功
     * 不在数据库中则注册失败
     * @param studentId 学生学号
     * @param password 注册的密码
     * @return 1表示注册成功，0表示注册失败
     */
    int studentRegistry(int studentId, String password);

    int teacherRegistry(int teacherId, String password);

    /**
     * 用户登录
     * @param userId 学生、教师登录系统的账号
     * @param password
     * @return
     */
    User userLogin(int userId, String password);

    /**
     * 根据登录的角色进行相应角色的密码修改
     * @param roleStateEnum 登录的角色
     * @param oldPassword 账号旧密码
     * @param newPassword 账户新密码
     * @return 1表示修改成功，0表示修改失败
     */
    int modifyPassword(RoleStateEnum roleStateEnum, String oldPassword, String newPassword);

}
