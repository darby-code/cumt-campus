package edu.cumt.phyExperiment.web;

import com.google.code.kaptcha.Producer;
import edu.cumt.phyExperiment.dto.LoginResult;
import edu.cumt.phyExperiment.dto.Result;
import edu.cumt.phyExperiment.dto.RoleTransfer;
import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.enums.LoginStateEnum;
import edu.cumt.phyExperiment.enums.RoleStateEnum;
import edu.cumt.phyExperiment.service.ExperimentTempService;
import edu.cumt.phyExperiment.service.UserService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@SessionAttributes({"role", "roleInfo"})
@RequestMapping(value = "/userLogin")
public class LoginController {
    @Resource(name = "userService")
    UserService userService;
    @Autowired
    ExperimentTempService experimentTempService;

    private Producer kaptchaProducer = null;

    @Autowired
    public void setKaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }
//登录页面
    @RequestMapping("/index.do")
    public String loginEntrance(Model model) {
        //从初始化内容中获取公告，防止频繁读取数据库
       model.addAttribute("announcementContent", ClickNumberControl.getAnnouncementContent());
        return "login";
    }
//登录检查，检查通过则自动登录，否则返回提示信息
    @ResponseBody
    @RequestMapping(value = "/loginCheck.do", produces = "application/json;charset=UTF-8")
    public Object loginCheck(HttpServletRequest request) {
        //提交过来的都是经过前端正则表达式验证的
        String userAccount = request.getParameter("userAccount");
        String userPassword = request.getParameter("userPassword");
        String role = request.getParameter("role");
        String securityCode = request.getParameter("securityCode");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        //验证验证码
        if (!securityCode.toLowerCase().equals(verifyCode.toLowerCase())) {
            //验证码错误
            return new LoginResult(false, role, userAccount, userPassword, LoginStateEnum.SECURITY_CODE_ERROR);
        }
        //验证码正确
        //解析登录角色
        int mark = Integer.parseInt(role);
        if (mark == 1) {
            //学生
            try {
                long studentId = Long.parseLong(userAccount);
                Student student = userService.queryStudent(studentId);
                //检查账号合法性
                if (student == null) {
                    //登录学号不存在
                    return new LoginResult(false, role, LoginStateEnum.STUDENT_ID_NOT_EXISTS);
                }
                //检查密码合法性
                if (!userPassword.equals(student.getPassword())) {
                    //密码错误
                    return new LoginResult(false, role, userAccount, LoginStateEnum.PASSWORD_ERROR);
                }
                //到这里，说明，学生登录成功
                return new LoginResult(true, role, securityCode, userAccount, userPassword, LoginStateEnum.LOGIN_SUCCESS);
            } catch (Exception ex) {
                //内部错误
                return new LoginResult(false, role, LoginStateEnum.LOGIN_ERROR);
            }
        } else if (mark == 2) {
            //教师
            try {
                long teacherId = Long.parseLong(userAccount);
                Teacher teacher = userService.queryTeacher(teacherId);
                //检查账号合法性
                if (teacher == null) {
                    //教师工号不存在
                    return new LoginResult(false, role, LoginStateEnum.TEACHER_ID_NOT_EXISTS);
                }
                //检查密码合法性
                if (!userPassword.equals(teacher.getPassword())) {
                    //密码错误
                    return new LoginResult(false, role, userAccount, LoginStateEnum.PASSWORD_ERROR);
                }
                //到这里，老师登录成功
                return new LoginResult(true, role, securityCode, userAccount, userPassword, LoginStateEnum.LOGIN_SUCCESS);
            } catch (Exception ex) {
                //内部错误
                return new LoginResult(false, role, LoginStateEnum.LOGIN_ERROR);
            }
        } else if (mark == 0) {
            //管理员
            try {
                //检查账号合法性
                Admin admin = userService.queryAdmin(userAccount);
                if (admin == null) {
                    //管理员账号不存在
                    return new LoginResult(false, role, LoginStateEnum.ADMIN_ACCOUNT_NOT_EXISTS);
                }
                //存在则再检查密码合法性
                if (!userPassword.equals(admin.getPassword())) {
                    //密码错误
                    return  new LoginResult(false, role, userAccount, LoginStateEnum.PASSWORD_ERROR);
                }
                //到这里，管理员登录成功
                return new LoginResult(true, role, securityCode, userAccount, userPassword, LoginStateEnum.LOGIN_SUCCESS);
            } catch (Exception ex) {
                //内部错误
                return new LoginResult(false, role, LoginStateEnum.LOGIN_ERROR);
            }
        } else {
            //角色不存在
            return new LoginResult(false, role, LoginStateEnum.ROLE_NOT_EXISTS);
        }
    }
//登录检查通过，登陆到各自主界面
    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, Model model) {
        //提交到这的，已经经过loginCheck验证
        //说明用户登录成功，这里跳转到各自角色的主页面

        //获取数据
        String account = request.getParameter("userAccount");
        String password = request.getParameter("userPassword");
        String role = request.getParameter("role");

        int mark = Integer.parseInt(role);
        if (mark == 1) {
            //跳到学生主页面
            try {
                long studentId = Long.parseLong(account);
                Student student = userService.queryStudent(studentId);
                model.addAttribute("role", student);
                model.addAttribute("roleInfo", new RoleTransfer(studentId, student.getStudentName(), password, RoleStateEnum.STUDENT));
                return "studentMain";
            } catch (Exception ex) {
                //查询信息遇到错误，重新登录
                model.addAttribute("error", "系统查询个人信息时遇到错误，请重试");
                return "mistake";
            }
        } else if (mark == 2) {
            //跳转到教师页面
            try {
                long teacherId = Long.parseLong(account);
                Teacher teacher = userService.queryTeacher(teacherId);
                model.addAttribute("role", teacher);
                model.addAttribute("roleInfo", new RoleTransfer(teacherId, teacher.getTeacherName(), password, RoleStateEnum.TEACHER));
                return "teacherMain";
            } catch (Exception ex) {
                //查询信息遇到错误，重新登录
                model.addAttribute("error", "系统查询个人信息时遇到错误，请重试");
                return "mistake";
            }
        } else if (mark == 0) {
            //跳转到管理员页面
            try {
                Admin admin = userService.queryAdmin(account);
                int auditNumbers = experimentTempService.queryAuditExperimentsCount();
                model.addAttribute("auditNumbers", auditNumbers);
                model.addAttribute("role", admin);
                model.addAttribute("roleInfo", new RoleTransfer(account, admin.getName(), password, RoleStateEnum.ADMIN));
                return "adminMain";
            } catch (Exception ex) {
                //查询信息遇到错误，重新登录
                model.addAttribute("error", "系统查询个人信息时遇到错误，请重试");
                return "mistake";
            }
        } else {
            //运行到这里，说明页面的ratio value被人篡改了，就让他重新登录
            return "login";
        }
    }
//验证码
    @RequestMapping("/getVerifyCode.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = kaptchaProducer.createText();
        request.getSession().setAttribute("verifyCode", capText);
        BufferedImage bufferedImage = kaptchaProducer.createImage(capText);
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", outStream);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
