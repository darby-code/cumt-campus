package com.doug.ssm.dao;

import com.doug.ssm.BaseTest;
import com.doug.ssm.entity.Student;
import com.doug.ssm.entity.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao userDao;

    @Test
    public void queryStudentBy() {
        int studentId = 100111012;
        Student student = userDao.queryStudentBy(studentId);
        System.out.println(student);
    }

    @Test
    public void queryTeacherBy() {
        int teacherId = 1002501;
        Teacher teacher = userDao.queryTeacherBy(teacherId);
        System.out.println(teacher);
    }

    @Test
    public void queryAllTeachers() {
        List<Teacher> teachers = userDao.queryAllTeachers();
        System.out.println(teachers);
    }

    @Test
    public void queryAllStudents() {
        List<Student> students = userDao.queryAllStudents();
        System.out.println(students);
    }

    @Test
    public void queryCollegerBy() {
        int collegeId = 10013;
        List<Student> students = userDao.queryCollegerBy(collegeId);
        System.out.println(students);
    }

    @Test
    public void updateTeacherPassword() {
        Teacher teacher = new Teacher(1002501, "张伦", "123456");
        int result = userDao.updateTeacherPassword(teacher);
        System.out.println(result);
        teacher = new Teacher(1002501, "张伦", "1002501");
        userDao.updateTeacherPassword(teacher);
    }

    @Test
    public void updateStudentPassword() {
        Student student = new Student(100111012, "李荣省", "123456", 10011, "矿业学院", 0);
        int result = userDao.updateStudentPassword(student);
        System.out.println(userDao.queryStudentBy(100111012));
        student = new Student(100111012, "李荣省", "100111012", 10011, "矿业学院", 0);
        userDao.updateStudentPassword(student);
    }
}
