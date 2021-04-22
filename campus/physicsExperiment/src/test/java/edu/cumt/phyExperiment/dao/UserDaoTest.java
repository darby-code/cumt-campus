package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao userDao;

    @Test
    public void queryStudentById() {
        int studentId = 100111012;
        Student student = userDao.queryStudentById(studentId);
        System.out.println(student);
    }

    @Test
    public void queryStudentByName() {
        String studentName = "刘方圆";
        List<Student> list = userDao.queryStudentByName(studentName);
        System.out.println(list);
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
    public void updateStudentPassword() {
        Student student = new Student(100111012, "李荣省", "123456", 10011, "矿业学院");
        int result = userDao.updateStudentPassword(student.getStudentId(), student.getPassword());
        System.out.println(userDao.queryStudentById(100111012));
        student = new Student(100111012, "李荣省", "100111012", 10011, "矿业学院");
        userDao.updateStudentPassword(student.getStudentId(), student.getPassword());
    }

    @Test
    public void queryTeacherById() {
        int teacherId = 1002501;
        Teacher teacher = userDao.queryTeacherById(teacherId);
        System.out.println(teacher);
    }

    @Test
    public void queryTeacherByName() {
        String name = "张伦";
        List<Teacher> list = userDao.queryTeacherByName(name);
        System.out.println(list);
    }

    @Test
    public void queryAllTeachers() {
        List<Teacher> teachers = userDao.queryAllTeachers();
        System.out.println(teachers);
    }

    @Test
    public void queryCollegeTeacherBy() {
        int collegeId = 10025;
        List<Teacher> list = userDao.queryCollegeTeacherBy(collegeId);
        System.out.println(list);
    }

    @Test
    public void updateTeacherPassword() {
        Teacher teacher = new Teacher(1002501, "张伦", "123456", 10025);
        int result = userDao.updateTeacherPassword(teacher.getTeacherId(), teacher.getPassword());
        System.out.println(result);
        teacher = new Teacher(1002501, "张伦", "1002501", 10025);
        userDao.updateTeacherPassword(teacher.getTeacherId(), teacher.getPassword());
    }


}
