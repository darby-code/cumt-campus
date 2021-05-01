package edu.cumt.phyExperiment.dao;


import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.enums.SexEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao userDao;

    @Test
    public void queryStudentById() {
        long studentId = 1001011012;
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
        int collegeId = 100103;
        List<Student> students = userDao.queryCollegerBy(collegeId);
        System.out.println(students);
    }

    @Test
    public void updateStudentPassword() {
        long studentId = 1001011013L;
        int result = userDao.updateStudentPassword(studentId, "123456789");
        System.out.println(result);
    }

    @Test
    public void updateStudentInfo() {
        Student student = new Student(1001011013L, "黄敏威", "h8519522*", null, null, false, "15162136037");
        int result = userDao.updateStudentInfo(student);
        System.out.println(result);
    }

    @Test
    public void queryStudentAccountState() {
        int result = userDao.queryStudentAccountState(1001011013L);
        System.out.println(result);
    }

    @Test
    public void updateStudentAccountState() {
        int result = userDao.updateStudentAccountState(1001011013L, 3);
        System.out.println(result);
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
        int collegeId = 100115;
        List<Teacher> list = userDao.queryCollegeTeacherBy(collegeId);
        System.out.println(list);
    }

    @Test
    public void updateTeacherPassword() {
        long teacherId = 1002501L;
        int result = userDao.updateTeacherPassword(teacherId, "123456789");
        System.out.println(result);
    }

    @Test
    public void updateTeacherInfo() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1002501L);
        teacher.setPhoneNumber("13306002932");
        teacher.setEmail("zhanglun@cumt.com");
        int result = userDao.updateTeacherInfo(teacher);
        System.out.println(result);
    }

    @Test
    public void queryTeacherAccountState() {
        int result = userDao.queryTeacherAccountState(1002501L);
        System.out.println(result);
    }

    @Test
    public void updateTeacherAccountState() {
        int result = userDao.updateTeacherAccountState(1002501L, 3);
        System.out.println(result);
    }

    @Test
    public void queryAccountCount() {
        int result = userDao.queryAccountCount("dougMagic");
        System.out.println(result);
        result = userDao.queryAccountCount("dougWilson");
        System.out.println(result);
    }

    @Test
    public void queryAdminByAccount() {
        Admin admin = userDao.queryAdminByAccount("dougMagic");
        System.out.println(admin);
        admin = userDao.queryAdminByAccount("dougWilson");
        System.out.println(admin);
    }

    @Test
    public void queryAdminByAdminId() {
        Admin admin = userDao.queryAdminByAccount("dougMagic");
        admin = userDao.queryAdminByAdminId(admin.getAdminId());
        System.out.println(admin);
    }

    @Test
    public void insertAdmin() {
        Admin admin = new Admin("dougWilson", "h8519522*", "doug", false, new Date(), "15162136037");
        int result = userDao.insertAdmin(admin);
        System.out.println(result);
    }

    @Test
    public void updateAdminPassword() {
        int result = userDao.updateAdminPassword("dougWilson", "huang090900");
        System.out.println(result);
    }

    @Test
    public void updateAdminInfo() {
        Admin admin = new Admin("dougWilson", "h8519522*", "doug", false, new Date(), "15162136037");
        int result = userDao.updateAdminInfo(admin);
        System.out.println(result);
    }

    @Test
    public void queryAdminAccountState() {
        int result = userDao.queryAdminAccountState("dougMagic");
        System.out.println(result);
    }

    @Test
    public void updateAdminAccountState() {
        int result = userDao.updateAdminAccountState("dougMagic", 4);
        System.out.println(result);
    }

    @Test
    public void deleteAdminByAccount() {
        int result = userDao.deleteAdminByAccount("dougWilson");
        System.out.println(result);
    }
}
