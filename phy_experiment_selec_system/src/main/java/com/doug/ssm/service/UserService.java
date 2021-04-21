package com.doug.ssm.service;

import com.doug.ssm.entity.Student;
import com.doug.ssm.entity.Teacher;

import java.util.List;

public interface UserService {
    /**
     * 检查账号和密码的正确性
     * @param id
     * @param password
     * @return
     */
    int checkAccount(Integer id, String password);

    /**
     * 查询学生姓名
     * @param id
     * @return
     */
    String getStudentNameBy(Integer id);

    /**
     * 查询教师姓名
     * @param id
     * @return
     */
    String getTeacherNameBy(Integer id);

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    Student getStudentInfoBy(Integer id);

    /**
     * 查询教师信息
     * @param id
     * @return
     */
    Teacher getTeacherInfoBy(Integer id);

    /**
     * 学生修改密码
     * @param student
     * @return
     */
    int changeStudentPassword(Student student);

    /**
     * 教师修改密码
     * @param teacher
     * @return
     */
    int changeTeacherPassword(Teacher teacher);

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> queryAllTeachers();

    /**
     * 查询所有学生
     * @return
     */
    List<Student> queryAllStudents();
}
