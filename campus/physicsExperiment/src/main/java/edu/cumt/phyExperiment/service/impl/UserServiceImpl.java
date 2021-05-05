package edu.cumt.phyExperiment.service.impl;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import edu.cumt.phyExperiment.dao.AnnouncementDao;
import edu.cumt.phyExperiment.dao.CollegeDao;
import edu.cumt.phyExperiment.dao.UserDao;
import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.exception.PasswordNotEqualsException;
import edu.cumt.phyExperiment.exception.UpdatePasswordFailedException;
import edu.cumt.phyExperiment.service.UserService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    UserDao userDao;
    @Autowired
    CollegeDao collegeDao;
    @Autowired
    AnnouncementDao announcementDao;

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
    public int modifyAdminPassword(String account, String oldPassword, String newPassword) {
        Admin admin = null;
        try {
            admin = userDao.queryAdminByAccount(account);
            if (admin == null) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //用户存在，则进行密码检查
            if(!oldPassword.equals(admin.getPassword())) {
                throw new PasswordNotEqualsException("旧密码与原始密码不匹配，无法更新成新密码");
            }
            //更新成新密码
            int result = userDao.updateAdminPassword(account, newPassword);
            if (result != 1) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //到这里，密码更新成功
            return 1;
        } catch (UpdatePasswordFailedException | PasswordNotEqualsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("修改密码遇到未知异常");
        }
    }

    @Override
    public int modifyStudentPassword(long studentId, String oldPassword, String newPassword) {
        Student student = null;
        try {
            student = userDao.queryStudentById(studentId);
            if (student == null) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //用户存在，则进行密码检查
            if(!oldPassword.equals(student.getPassword())) {
                throw new PasswordNotEqualsException("旧密码与原始密码不匹配，无法更新成新密码");
            }
            //更新成新密码
            int result = userDao.updateStudentPassword(studentId, newPassword);
            if (result != 1) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //到这里，密码更新成功
            return 1;
        } catch (UpdatePasswordFailedException | PasswordNotEqualsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("修改密码遇到未知异常");
        }
    }

    @Override
    public int resetStudentPassword(long studentId, String newPassword) {
        try {
            return userDao.updateStudentPassword(studentId, newPassword);
        } catch (Exception ex) {
            throw new RuntimeException("修改学号为：" + studentId + " 的密码失败");
        }
    }

    @Override
    public int resetAllStudentsPassword(List<Student> students) {
        try {
            int result = 0; //记录更新的记录数
            for (Student s : students) {
                //重置密码为学号
                result += userDao.updateStudentPassword(s.getStudentId(), String.valueOf(s.getStudentId()));
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("执行学生密码更新时失败");
        }
    }

    @Override
    public int modifyTeacherPassword(long teacherId, String oldPassword, String newPassword) {
        Teacher teacher = null;
        try {
            teacher = userDao.queryTeacherById(teacherId);
            if (teacher == null) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //用户存在，则进行密码检查
            if(!oldPassword.equals(teacher.getPassword())) {
                throw new PasswordNotEqualsException("旧密码与原始密码不匹配，无法更新成新密码");
            }
            //更新成新密码
            int result = userDao.updateTeacherPassword(teacherId, newPassword);
            if (result != 1) {
                throw new UpdatePasswordFailedException("修改密码失败");
            }
            //到这里，密码更新成功
            return 1;
        } catch (UpdatePasswordFailedException | PasswordNotEqualsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("修改密码遇到未知异常");
        }
    }

    @Override
    public int resetTeacherPassword(long teacherId, String newPassword) {
        try {
            return userDao.updateTeacherPassword(teacherId, newPassword);
        } catch (Exception ex) {
            throw new RuntimeException("修改工号为：" + teacherId + " 的密码失败");
        }
    }

    @Override
    public int resetAllTeachersPassword(List<Teacher> teachers) {
        try {
            int result = 0; //记录更新的记录数
            for (Teacher t : teachers) {
                //重置密码为学号
                result += userDao.updateTeacherPassword(t.getTeacherId(), String.valueOf(t.getTeacherId()));
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("执行学生密码更新时失败");
        }
    }

    @Override
    public int updateStudentInfo(Student student) {
        int result = 0;
        try {
            result = userDao.updateStudentInfo(student);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateTeacherInfo(Teacher teacher) {
        int result = 0;
        try {
            result = userDao.updateTeacherInfo(teacher);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateAdminInfo(Admin admin) {
        int result = 0;
        try {
            result = userDao.updateAdminInfo(admin);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Student> queryAllStudents() {
        List<Student> students = null;
        try {
            students = userDao.queryAllStudents();
        } catch (Exception ex) {
            throw new RuntimeException("获取学生列表失败");
        }
        return students;
    }

    @Override
    public List<Teacher> queryAllTeachers() {
        List<Teacher> teachers = null;
        try {
            teachers = userDao.queryAllTeachers();
        } catch (Exception ex) {
            throw new RuntimeException("获取教师列表失败");
        }
        return teachers;
    }

    @Override
    public List<Admin> queryAllAdmins() {
        List<Admin> admins = null;
        try {
            admins = userDao.queryAllAdmins();
        } catch (Exception ex) {
            throw new RuntimeException("获取教师列表失败");
        }
        return admins;
    }

    @Override
    public List<Student> queryCollegerById(long collegeId) {
        try {
            List<Student> students = userDao.queryCollegerBy(collegeId);
            return students;
        } catch (Exception ex) {
            throw new RuntimeException("获取学院学生列表失败");
        }
    }

    @Override
    public List<Teacher> queryCollegeTeacherById(long collegeId) {
        try {
            List<Teacher> teachers = userDao.queryCollegeTeacherBy(collegeId);
            return teachers;
        } catch (Exception ex) {
            throw new RuntimeException("获取学院老师列表失败");
        }
    }

    @Override
    public String queryAnnouncementContent() {
        try {
            return announcementDao.queryAnnouncement();
        } catch (Exception ex) {
            throw new RuntimeException("查询公告内容时遇到错误");
        }
    }

    @Override
    public int modifyAnnouncementContent(String newContent) {
        try {
            announcementDao.modifyAnnouncement(newContent);
            //修改成功后重置公告内容
            ClickNumberControl.setAnnouncementContent(newContent);
            return 1;
        } catch (Exception ex) {
            throw new RuntimeException("修改公告内容时遇到错误");
        }
    }

}
