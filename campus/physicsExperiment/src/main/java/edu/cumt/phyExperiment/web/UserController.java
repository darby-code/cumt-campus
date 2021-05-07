package edu.cumt.phyExperiment.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.cumt.phyExperiment.dto.Result;
import edu.cumt.phyExperiment.entity.*;
import edu.cumt.phyExperiment.enums.ExperimentStateEnum;
import edu.cumt.phyExperiment.enums.UserOperationStateEnum;
import edu.cumt.phyExperiment.exception.PasswordNotEqualsException;
import edu.cumt.phyExperiment.exception.UpdatePasswordFailedException;
import edu.cumt.phyExperiment.service.CollegeService;
import edu.cumt.phyExperiment.service.UserService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CollegeService collegeService;
//学生个人信息界面
    @RequestMapping(value = "/studentInfo.do", produces = "text/html;charset=UTF-8")
    public String queryStudentInfo(long studentId, Model model) {
        Student student = null;
        try {
            student = userService.queryStudent(studentId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        if (student == null) {
            model.addAttribute("error", "查询个人信息遇到错误");
            return "mistake";
        }
        model.addAttribute("role", "student");
        model.addAttribute("information", student);
        return "infoPage";
    }
//学生修改个人信息
    @ResponseBody
    @RequestMapping(value = "/updateStudentInfo.do", produces = "application/json;charset=UTF-8")
    public Object updateStudentInfo(long studentId, @RequestParam(value = "phoneNumber", required = false) String phoneNumber
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "qq", required = false) String qq) {
        Student student = new Student();
        student.setStudentId(studentId);
        student.setPhoneNumber(phoneNumber);
        student.setEmail(email);
        student.setQq(qq);
        //将结果封装成JSON对象返回
        Result<?> result = null;
        try {
            userService.updateStudentInfo(student);
            result = new Result<Student>(true, student);
            result.setMessage(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getStateInfo());
            result.setState(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<String>(false, UserOperationStateEnum.UPDATE_INFO_FAILED.getStateInfo(), UserOperationStateEnum.UPDATE_INFO_FAILED.getState());
        }
        return result;
    }
//显示修改密码界面
    @RequestMapping("/showUpdatePasswordBox.do")
    public String showUpdateBox(String role, String roleInfo, Model model) {
        if ("student".equals(role)) {
            long studentId = Long.parseLong(roleInfo);
            model.addAttribute("nowUser", studentId);
        } else if ("teacher".equals(role)) {
            long teacherId = Long.parseLong(roleInfo);
            model.addAttribute("nowUser", teacherId);
        } else if ("admin".equals(role)) {
            model.addAttribute("nowUser", roleInfo);
        } else {
            //遇到错误，返回错误页面
            model.addAttribute("error", "未知的用户" + role);
            return "mistake";
        }
        model.addAttribute("role", role);
        return "updatePassword";
    }
//修改密码
    @ResponseBody
    @RequestMapping(value = "/updatePassword.do", produces = "application/json;charset=UTF-8")
    public Object updateStudentPassword(String role, String roleInfo, String oldPassword, String newPassword) {

        Result<?> result = null;
        try {
            if ("student".equals(role)) {
                long studentId = Long.parseLong(roleInfo);
                userService.modifyStudentPassword(studentId, oldPassword, newPassword);
            } else if ("teacher".equals(role)) {
                long teacherId = Long.parseLong(roleInfo);
                userService.modifyTeacherPassword(teacherId, oldPassword, newPassword);
            } else if ("admin".equals(role)) {
                userService.modifyAdminPassword(roleInfo, oldPassword, newPassword);
            } else {
                throw new Exception();
            }
            //到这里说明密码更新成功
            result = new Result<>(true, UserOperationStateEnum.UPDATE_PASSWORD_SUCCESS.getStateInfo(), UserOperationStateEnum.UPDATE_PASSWORD_SUCCESS.getState());
        } catch (PasswordNotEqualsException ex) {
            result = new Result<>(false, UserOperationStateEnum.UPDATE_PASSWORD_NOT_EQUALS.getStateInfo(), UserOperationStateEnum.UPDATE_PASSWORD_NOT_EQUALS.getState());
        } catch (UpdatePasswordFailedException ex) {
            result = new Result<>(false, UserOperationStateEnum.UPDATE_PASSWORD_FAILED.getStateInfo(), UserOperationStateEnum.UPDATE_PASSWORD_FAILED.getState());
        } catch (Exception ex) {
            result = new Result<>(false, ExperimentStateEnum.INNER_ERROR.getStateInfo(), ExperimentStateEnum.INNER_ERROR.getState());
        }
        return result;
    }
//显示教师个人信息界面
    @RequestMapping("/teacherInfo.do")
    public String queryTeacherInfo(long teacherId, Model model) {
        Teacher teacher = null;
        try {
            teacher = userService.queryTeacher(teacherId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        if (teacher == null) {
            model.addAttribute("error", "查询个人信息遇到错误");
            return "mistake";
        }
        model.addAttribute("role", "teacher");
        model.addAttribute("information", teacher);
        return "infoPage";
    }
//教师修改个人信息
    @ResponseBody
    @RequestMapping(value = "/updateTeacherInfo.do", produces = "application/json;charset=UTF-8")
    public Object updateTeacherInfo(long teacherId, @RequestParam(value = "phoneNumber", required = false) String phoneNumber
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "qq", required = false) String qq) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setPhoneNumber(phoneNumber);
        teacher.setEmail(email);
        teacher.setQq(qq);
        //将结果封装成JSON对象返回
        Result<?> result = null;
        try {
            userService.updateTeacherInfo(teacher);
            result = new Result<Teacher>(true, teacher);
            result.setMessage(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getStateInfo());
            result.setState(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<String>(false, UserOperationStateEnum.UPDATE_INFO_FAILED.getStateInfo(), UserOperationStateEnum.UPDATE_INFO_FAILED.getState());
        }
        return result;
    }
//显示管理员个人信息界面
    @RequestMapping("/adminInfo.do")
    public String queryAdminInfo(String account, Model model) {
        Admin admin = null;
        try {
            admin = userService.queryAdmin(account);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        if (admin == null) {
            model.addAttribute("error", "查询个人信息遇到错误");
            return "mistake";
        }
        model.addAttribute("role", "admin");
        model.addAttribute("information", admin);
        return "infoPage";
    }
//管理员修改个人信息
    @ResponseBody
    @RequestMapping(value = "/updateAdminInfo.do", produces = "application/json;charset=UTF-8")
    public Object updateAdminInfo(String account, @RequestParam(value = "phoneNumber", required = false) String phoneNumber
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "qq", required = false) String qq) {
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPhoneNumber(phoneNumber);
        admin.setEmail(email);
        admin.setQq(qq);
        //将结果封装成JSON对象返回
        Result<?> result = null;
        try {
            userService.updateAdminInfo(admin);
            result = new Result<Admin>(true, admin);
            result.setMessage(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getStateInfo());
            result.setState(UserOperationStateEnum.UPDATE_INFO_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<String>(false, UserOperationStateEnum.UPDATE_INFO_FAILED.getStateInfo(), UserOperationStateEnum.UPDATE_INFO_FAILED.getState());
        }
        return result;
    }
//显示所有学生信息
    @RequestMapping("showStudentInfo.do")
    public String showStudentInfo(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            List<Student> students = userService.queryAllStudents();
            PageInfo<Student> pageInfo = new PageInfo<>(students);
            model.addAttribute("infoList", pageInfo);
            return "showStudentInfo";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//显示所有教师信息
    @RequestMapping("showTeacherInfo.do")
    public String showTeacherInfo(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            List<Teacher> teachers = userService.queryAllTeachers();
            PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
            model.addAttribute("infoList", pageInfo);
            return "showTeacherInfo";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//显示重置学生密码界面
    @RequestMapping("/showResetStudentPasswordBox.do")
    public String showResetStudentPasswordBox(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //获取学院列表
            List<College> colleges = collegeService.queryAllCollegesInfo();
            //获取学院学生列表 键为collegeId  值为List<Student>
            HashMap<Long, PageInfo<Student>> colleger = new HashMap<>();
            for (College c : colleges) {
                //开始分页
                PageHelper.startPage(currentPageNum, currentPageSize, true);
                List<Student> studentList = userService.queryCollegerById(c.getCollegeId());
                PageInfo<Student> pageInfo = new PageInfo<>(studentList);
                colleger.put(c.getCollegeId(), pageInfo);
            }
            model.addAttribute("colleges", colleges);
            model.addAttribute("colleger", colleger);
            return "resetStudentPassword";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//学生密码界面子内容
    @RequestMapping("/studentResetTable.do")
    public String studentResetTable(long collegeId, @RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //获取学院学生列表 List<Student>
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            List<Student> studentList = userService.queryCollegerById(collegeId);
            PageInfo<Student> pageInfo = new PageInfo<>(studentList);
            model.addAttribute("infoList", pageInfo);
            model.addAttribute("showCollegeId", collegeId);
            return "studentResetTable";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//显示重置教师密码界面
    @RequestMapping("/showResetTeacherPasswordBox.do")
    public String showResetTeacherPasswordBox(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //获取学院列表
            List<College> colleges = collegeService.queryAllCollegesInfo();
            //获取学院教师列表 键为collegeId  值为List<Teacher>
            HashMap<Long, PageInfo<Teacher>> colleger = new HashMap<>();
            for (College c : colleges) {
                //开始分页
                PageHelper.startPage(currentPageNum, currentPageSize, true);
                List<Teacher> teacherList = userService.queryCollegeTeacherById(c.getCollegeId());
                PageInfo<Teacher> pageInfo = new PageInfo<>(teacherList);
                colleger.put(c.getCollegeId(), pageInfo);
            }
            model.addAttribute("colleges", colleges);
            model.addAttribute("colleger", colleger);
            return "resetTeacherPassword";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//教师密码界面子内容
    @RequestMapping("/teacherResetTable.do")
    public String teacherResetTable(long collegeId, @RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //获取学院学生列表 List<Teacher>
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            List<Teacher> teacherList = userService.queryCollegeTeacherById(collegeId);
            PageInfo<Teacher> pageInfo = new PageInfo<>(teacherList);
            model.addAttribute("infoList", pageInfo);
            model.addAttribute("showCollegeId", collegeId);
            return "teacherResetTable";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }
//重置学生密码
    @ResponseBody
    @RequestMapping(value = "/resetStudentPassword.do", produces = "application/json;charset=UTF-8")
    public Object resetStudentPassword(long studentId) {
        Result<String> result = null;
        try {
            userService.resetStudentPassword(studentId, String.valueOf(studentId));
            result = new Result<>(true, UserOperationStateEnum.RESET_STUDENT_PASSWORD_SUCCESS.getStateInfo(), UserOperationStateEnum.RESET_STUDENT_PASSWORD_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, UserOperationStateEnum.RESET_STUDENT_PASSWORD_FAILED.getStateInfo(), UserOperationStateEnum.RESET_STUDENT_PASSWORD_FAILED.getState());
        }
        return result;
    }
//重置教师密码
    @ResponseBody
    @RequestMapping(value = "/resetTeacherPassword.do", produces = "application/json;charset=UTF-8")
    public Object resetTeacherPassword(long teacherId) {
        Result<String> result = null;
        try {
            userService.resetTeacherPassword(teacherId, String.valueOf(teacherId));
            result = new Result<>(true, UserOperationStateEnum.RESET_TEACHER_PASSWORD_SUCCESS.getStateInfo(), UserOperationStateEnum.RESET_TEACHER_PASSWORD_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, UserOperationStateEnum.RESET_TEACHER_PASSWORD_FAILED.getStateInfo(), UserOperationStateEnum.RESET_TEACHER_PASSWORD_FAILED.getState());
        }
        return result;
    }
//一键重置学生密码
    @ResponseBody
    @RequestMapping(value = "/resetAllStudentPassword.do", produces = "application/json;charset=UTF-8")
    public Object resetAllStudentPassword(long collegeId) {
        Result<String> result = null;
        try {
            List<Student> students = userService.queryCollegerById(collegeId);
            userService.resetAllStudentsPassword(students);
            result = new Result<>(true, UserOperationStateEnum.RESET_ALL_STUDENT_PASSWORD_SUCCESS.getStateInfo(), UserOperationStateEnum.RESET_ALL_STUDENT_PASSWORD_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, UserOperationStateEnum.RESET_ALL_STUDENT_PASSWORD_FAILED.getStateInfo(), UserOperationStateEnum.RESET_ALL_STUDENT_PASSWORD_FAILED.getState());
        }
        return result;
    }
//一键重置教师密码
    @ResponseBody
    @RequestMapping(value = "/resetAllTeacherPassword.do", produces = "application/json;charset=UTF-8")
    public Object resetAllTeacherPassword(long collegeId) {
        Result<String> result = null;
        try {
            List<Teacher> teachers = userService.queryCollegeTeacherById(collegeId);
            userService.resetAllTeachersPassword(teachers);
            result = new Result<>(true, UserOperationStateEnum.RESET_TEACHER_PASSWORD_SUCCESS.getStateInfo(), UserOperationStateEnum.RESET_TEACHER_PASSWORD_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, UserOperationStateEnum.RESET_ALL_TEACHER_PASSWORD_FAILED.getStateInfo(), UserOperationStateEnum.RESET_ALL_TEACHER_PASSWORD_FAILED.getState());
        }
        return result;
    }
//获取公告内容
    @RequestMapping("showAnnouncementContent.do")
    public String showAnnouncementContent(Model model) {
        model.addAttribute("announcementContent", ClickNumberControl.getAnnouncementContent());
        return "showAnnouncementContent";
    }
//修改公告内
    @ResponseBody
    @RequestMapping(value = "modifyContent.do", produces = "application/json;charset=UTF-8")
    public Object modifyAnnouncementContent(String newContent) {
        Result<String> result = null;
        try {
            userService.modifyAnnouncementContent(newContent);
            //修改公告内容成功
            result = new Result<>(true, UserOperationStateEnum.MODIFY_ANNOUNCEMENT_CONTENT_SUCCESS.getStateInfo(), UserOperationStateEnum.MODIFY_ANNOUNCEMENT_CONTENT_SUCCESS.getState());
        } catch (Exception ex) {
            //修改公告内容失败
            result = new Result<>(false, UserOperationStateEnum.MODIFY_ANNOUNCEMENT_CONTENT_FAILED.getStateInfo(), UserOperationStateEnum.MODIFY_ANNOUNCEMENT_CONTENT_FAILED.getState());
        }
        return result;
    }
}
