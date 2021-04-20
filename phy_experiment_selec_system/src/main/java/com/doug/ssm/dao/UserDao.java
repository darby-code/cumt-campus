package com.doug.ssm.dao;

import com.doug.ssm.entity.Student;
import com.doug.ssm.entity.Teacher;

import java.util.List;

public interface UserDao {
    /**
     * 根据学号查询学生
     * @param studentId
     * @return
     */
    Student queryStudentBy(Integer studentId);

    /**
     * 根据工号查询教师
     * @param teacherId
     * @return
     */
    Teacher queryTeacherBy(Integer teacherId);

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

    /**
     * 查询一个学院的所有学生
     * @param collegeId
     * @return
     */
    List<Student> queryCollegerBy(Integer collegeId);

    /**
     * 教师修改账号密码
     * @param teacher
     * @return
     */
    int updateTeacherPassword(Teacher teacher);

    /**
     * 学生修改账号密码
     * @param student
     * @return
     */
    int updateStudentPassword(Student student);
}
