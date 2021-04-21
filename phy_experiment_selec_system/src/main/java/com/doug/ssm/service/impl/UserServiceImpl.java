package com.doug.ssm.service.impl;

import com.doug.ssm.dao.UserDao;
import com.doug.ssm.entity.Student;
import com.doug.ssm.entity.Teacher;
import com.doug.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int checkAccount(Integer id, String password) {
        if (Integer.toString(id).length() == 7) {
            //教师登录成功
            if (password.equals((userDao.queryTeacherBy(id).getPassword()))) {
                return 2;
            }
        } else if(Integer.toString(id).length() == 9) {
            //学生登录成功
            if (password.equals(userDao.queryStudentBy(id).getPassword())) {
                return 1;
            }
        }
        //登录失败
        return 0;
    }

    @Override
    public String getStudentNameBy(Integer id) {
        return userDao.queryStudentBy(id).getStudentName();
    }

    @Override
    public String getTeacherNameBy(Integer id) {
        return userDao.queryTeacherBy(id).getTeacherName();
    }

    @Override
    public Student getStudentInfoBy(Integer id) {
        return userDao.queryStudentBy(id);
    }

    @Override
    public Teacher getTeacherInfoBy(Integer id) {
        return userDao.queryTeacherBy(id);
    }

    @Override
    public int changeStudentPassword(Student student) {
        return userDao.updateStudentPassword(student);
    }

    @Override
    public int changeTeacherPassword(Teacher teacher) {
        return userDao.updateTeacherPassword(teacher);
    }

    @Override
    public List<Teacher> queryAllTeachers() {
        return userDao.queryAllTeachers();
    }

    @Override
    public List<Student> queryAllStudents() {
        return userDao.queryAllStudents();
    }
}
