package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.UserDao;
import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    UserDao userDao;

    @Override
    public Admin adminLogin(String account, String password) {
        Admin admin = userDao.queryAdminByAccount(account);
        if (admin == null) {
            return null;
        }
        if (password.equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin queryAdmin(String account) {
        return userDao.queryAdminByAccount(account);
    }

    @Override
    public int modifyAdminPassword(String account, String oldPassword, String newPassword) {
        Admin admin = userDao.queryAdminByAccount(account);
        if (admin == null) {
            return 0;
        }
        if (oldPassword.equals(admin.getPassword())) {
            return userDao.updateAdminPassword(admin.getAccount(), newPassword);
        }
        return -1;
    }

    @Override
    public int studentRegistry(long studentId, String password) {
        return userDao.updateStudentPassword(studentId, password);
    }

    @Override
    public int teacherRegistry(long teacherId, String password) {
        return userDao.updateTeacherPassword(teacherId, password);
    }

    @Override
    public Student studentLogin(long studentId, String password) {
        Student student = userDao.queryStudentById(studentId);
        if (student == null) {
            return null;
        }
        if (password.equals(student.getPassword())) {
            return student;
        }
        return null;
    }

    @Override
    public Teacher teacherLogin(long teacherId, String password) {
        Teacher teacher = userDao.queryTeacherById(teacherId);
        if (teacher == null) {
            return null;
        }
        if(password.equals(teacher.getPassword())) {
            return teacher;
        }
        return null;
    }

    @Override
    public Student queryStudent(long studentId) {
        return userDao.queryStudentById(studentId);
    }

    @Override
    public Teacher queryTeacher(long teacherId) {
        return userDao.queryTeacherById(teacherId);
    }

    @Override
    public int modifyStudentPassword(long studentId, String oldPassword, String newPassword) {
        Student student = userDao.queryStudentById(studentId);
        if (student == null) {
            return 0;
        }
        if (oldPassword.equals(student.getPassword())) {
            return userDao.updateStudentPassword(studentId, newPassword);
        }
        return 0;
    }

    @Override
    public int modifyTeacherPassword(long teacherId, String oldPassword, String newPassword) {
        Teacher teacher = userDao.queryTeacherById(teacherId);
        if (teacher == null) {
            return 0;
        }
        if (oldPassword.equals(teacher.getPassword())) {
            return userDao.updateTeacherPassword(teacherId, newPassword);
        }
        return 0;
    }
}
