package edu.cumt.phyExperiment.web;

import com.google.code.kaptcha.Producer;
import edu.cumt.phyExperiment.dto.RoleTransfer;
import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.enums.RoleStateEnum;
import edu.cumt.phyExperiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private Producer kaptchaProducer = null;

    @Autowired
    public void setKaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }

    @RequestMapping("/index.do")
    public String loginEntrance() {
        return "login";
    }

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        //提交成功的都是经过前端js正则表达式验证的
        String account = request.getParameter("userAccount");
        String password = request.getParameter("userPassword");
        String role = request.getParameter("role");
        String securityCode = request.getParameter("securityCode");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        if (!securityCode.toLowerCase().equals(verifyCode.toLowerCase())) {
            model.addAttribute("account", account);
            model.addAttribute("password", password);
            model.addAttribute("codeMessage", "验证码错误");
            return "login";
        }

        int mark = Integer.parseInt(role);
        if (mark == 1) {
            //学生
            int studentId = Integer.parseInt(account);
            Student student = userService.queryStudent(studentId);
            if (student == null) {
                model.addAttribute("accountMessage", "学号不存在");
                return "login";
            }
            if (!password.equals(student.getPassword())) {
                model.addAttribute("account", account);
                model.addAttribute("passwordMessage", "密码错误");
                return "login";
            }
            //到这里说明账号和密码正确，跳到学生主页面
            model.addAttribute("role", student);
            model.addAttribute("roleInfo", new RoleTransfer(studentId, student.getStudentName(), password, RoleStateEnum.STUDENT));
            return "studentMain";
        } else if (mark == 2) {
            //教师,逻辑同上
            int teacherId = Integer.parseInt(account);
            Teacher teacher = userService.queryTeacher(teacherId);
            if (teacher == null) {
                model.addAttribute("accountMessage", "工号不存在");
                return "login";
            }
            if (!password.equals(teacher.getPassword())) {
                model.addAttribute("account", account);
                model.addAttribute("passwordMessage", "密码错误");
                return "login";
            }
            model.addAttribute("role", teacher);
            model.addAttribute("roleInfo", new RoleTransfer(teacherId, teacher.getTeacherName(), password, RoleStateEnum.TEACHER));
            return "teacherMain";
        } else if (mark == 0) {
            //管理员
            Admin admin = userService.queryAdmin(account);
            if (admin == null) {
                model.addAttribute("accountMessage", "该管理员账号不存在");
                return "login";
            }
            if (!password.equals(admin.getPassword())) {
                model.addAttribute("account", account);
                model.addAttribute("passwordMessage", "密码错误");
                return "login";
            }
            model.addAttribute("role", admin);
            model.addAttribute("roleInfo", new RoleTransfer(account, admin.getName(), password, RoleStateEnum.ADMIN));
            return "adminMain";
        }
        //运行到这里，说明页面的ratio value被人篡改了，就让他重新登录
        return "login";
    }

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
