package edu.cumt.phyExperiment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 管理员功能：
 * 登录
 * 修改密码
 *
 * 获取实验列表
 * 修改异常实验成绩
 *
 * 获取学院列表
 *
 * 获取学生列表
 * 重置学生账号密码
 *
 * 获取老师列表
 * 重置老师账号密码
 *
 * 发布公告
 */
@Controller
@SessionAttributes({"currentAdmin"})
@RequestMapping(value = "admin/")
public class AdminController {

}
