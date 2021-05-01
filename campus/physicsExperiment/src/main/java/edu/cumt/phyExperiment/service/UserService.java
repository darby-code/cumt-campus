package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;

/**
 * UserService功能：
 * AdminService功能：
 * 管理员登录  adminLogin
 * 管理员修改密码  modifyAdminPassword
 *
 * 学生简单注册  studentRegistry
 * 教师简单注册  teacherRegistry
 * 学生、教师登录   studentLogin   teacherLogin
 * 学生、教师修改密码  modifyStudentPassword  modifyTeacherPassword
 *
 */
public interface UserService {
    /**
     * 管理员登录
     * @param account 登录账号
     * @param password 登录密码
     * @return 登录成功返回Admin对象，登录失败返回null
     */
    Admin adminLogin(String account, String password);

    /**
     * 查询账号对应管理员信息
     * @param account
     * @return
     */
    Admin queryAdmin(String account);

    /**
     * 管理员修改密码
     * @param account 管理员账户
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 1表示修改成功，0表示账号不存在, -1表示oldPassword和原始密码不匹配
     */
    int modifyAdminPassword(String account, String oldPassword, String newPassword);

    /**
     * 学生简单注册，学号和数据库中的比对一下，存在就注册成功
     * 不在数据库中则注册失败
     *
     * @param studentId 学生学号
     * @param password  注册的密码
     * @return 1表示注册成功，0表示注册失败
     */
    int studentRegistry(long studentId, String password);

    int teacherRegistry(long teacherId, String password);

    /**
     * 学生登录
     * @param studentId 登录账户，学号
     * @param password 登录密码
     * @return 登录成功返回一个Student对象，否则返回null
     */
    Student studentLogin(long studentId, String password);

    Teacher teacherLogin(long teacherId, String password);

    /**
     * 根据学号或工号查询学生和老师
     * @param studentId
     * @return
     */
    Student queryStudent(long studentId);

    Teacher queryTeacher(long teacherId);

    /**
     * 学生修改密码
     * @param studentId  学生学号
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return
     */
    int modifyStudentPassword(long studentId, String oldPassword, String newPassword);

    int modifyTeacherPassword(long teacherId, String oldPassword, String newPassword);
}
