package edu.cumt.phyExperiment.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.cumt.phyExperiment.dto.DropExperimentExecution;
import edu.cumt.phyExperiment.dto.Result;
import edu.cumt.phyExperiment.dto.SelectedExecution;
import edu.cumt.phyExperiment.entity.*;
import edu.cumt.phyExperiment.enums.AuditExperimentStateEnum;
import edu.cumt.phyExperiment.enums.ExperimentStateEnum;
import edu.cumt.phyExperiment.exception.*;
import edu.cumt.phyExperiment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {
    @Autowired
    ExperimentSelectedService experimentSelectedService;
    @Autowired
    ExperimentService experimentService;
    @Autowired
    ExperimentLimitService experimentLimitService;
    @Autowired
    UserService userService;
    @Autowired
    ExperimentTempService experimentTempService;
    @Autowired
    CollegeService collegeService;

    private static final int AUDIT_PASS = 2;
    private static final int AUDIT_NOT_PASS = 1;
    private static final long EXPERIMENT_DEADLINE = 1000 * 60 * 60 * 24;  //选课截止时间为提前一天

    @RequestMapping("/allExperiments.do")
    public String allExperiments(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            List<Experiment> list = experimentService.queryAllExperiments();
            PageInfo<Experiment> pageInfo = new PageInfo<Experiment>(list);
            //分页后的数据由pageInfo保存
            model.addAttribute("pageInfo", pageInfo);
            return "allExperiments";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @RequestMapping("/experimentDetails.do")
    public String experimentDetails(long experimentId, Model model) {
        try {
            Experiment experiment = experimentService.queryExperimentById(experimentId);
            model.addAttribute("clickExperiment", experiment);
            return "experimentDetails";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @RequestMapping("/showSearchBox.do")
    public String showSearchBox() {
        return "searchExperiment";
    }

    @RequestMapping("/searchExperiment.do")
    public String searchExperiment(String words, @RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        if (words == null || "".equals(words)) {
            return allExperiments(pageNum, pageSize, model);
        }
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        List<Experiment> experiments = null;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            experiments = experimentService.queryExperimentByKeyWords(words);
            PageInfo<Experiment> pageInfo = new PageInfo<>(experiments);
            //分页后的数据由pageInfo保存
            model.addAttribute("pageInfo", pageInfo);
            return "allExperiments";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @RequestMapping("/selectedList.do")
    public String studentSelectedList(@RequestParam("studentId") long studentId, Model model) {
        try {
            List<Experiment> selectedList = experimentSelectedService.querySelectedExperiments(studentId);
            model.addAttribute("studentId", studentId);
            model.addAttribute("selectedList", selectedList);
            return "selectedList";
        }catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/dropExperiment.do", produces = "application/json;charset=UTF-8")
    public Object dropExperiment(@RequestParam(value = "studentId") long studentId
            , @RequestParam(value = "experimentId") long experimentId, Model model) {
        DropExperimentExecution execution = null;
        try {
            execution = experimentSelectedService.experimentSelectedNumberReduceOne(experimentId, studentId);
        } catch (DropExperimentException ex) {
            execution = new DropExperimentExecution(experimentId, ExperimentStateEnum.DROP_FAILED);
        }
        Result<String> result = null;
        if (execution.getState() == 2) {
            result = new Result<>(true, execution.getStateInfo(), execution.getState());
        } else {
            result = new Result<>(false, execution.getStateInfo(), execution.getState());
        }
        return result;
    }

    @RequestMapping("/showSelectExperiment.do")
    public String selectExperimentBox(long studentId, @RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        List<Experiment> experiments = null;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            experiments = experimentService.queryAllowSelectedExperiments();
            PageInfo<Experiment> pageInfo = new PageInfo<>(experiments);
            //分页后的数据由pageInfo保存
            model.addAttribute("allowSelectedList", pageInfo);
            //获取学生已选实验
            List<Experiment> studentSelectedList = experimentSelectedService.querySelectedExperiments(studentId);
            HashMap<Long, Experiment> studentList = new HashMap<>();
            for (Experiment e : studentSelectedList) {
                studentList.put(e.getExperimentId(), e);
            }
            HashMap<Long, Date> experimentDeadLine = new HashMap<>();
            for (Experiment e : experiments) {
                Date date = new Date(e.getExperimentTime().getTime() - EXPERIMENT_DEADLINE);
                experimentDeadLine.put(e.getExperimentId(), date);
            }
            model.addAttribute("experimentDeadLine", experimentDeadLine);
            model.addAttribute("studentSelectedExperiments", studentList);
            model.addAttribute("studentId", studentId);
            return "selectExperiment";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectExperiment.do", produces = "application/json;charset=UTF-8")
    public Object selectExperiment(long studentId, long experimentId) {
        SelectedExecution execution = null;
        try {
            execution = experimentSelectedService.experimentSelectedNumberPlusOne(experimentId, studentId);
        } catch (ConflictException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.CONFLICT);
        } catch (NoMarginException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.NO_MARGIN);
        } catch (NotAllowSelectedException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.NOT_ALLOW);
        } catch (NotExistsException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.NOT_EXISTS);
        } catch (RepeatSelectedException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.REPEAT_SELECT);
        } catch (SelectedLimitException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.LIMIT);
        } catch (CollegeLimitException ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.COLLEGE_LIMIT);
        } catch (Exception ex) {
            execution = new SelectedExecution(experimentId, ExperimentStateEnum.INNER_ERROR);
        }
        //返回前端的JSON对象
        Result<String> result = null;
        if (execution.getExperimentSelected() == null) {
            //选实验失败
            result = new Result<>(false, execution.getStateInfo(), execution.getState());
        } else {
            result = new Result<>(true, execution.getStateInfo(), execution.getState());
        }
        return result;
    }

    @RequestMapping("/studentScore.do")
    public String queryStudentExperimentScore(long studentId, Model model) {
        List<ExperimentSelected> studentSelectedExperiment = null;
        try {
            studentSelectedExperiment = experimentSelectedService.queryExperimentsScore(studentId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        //成绩查询成功
        model.addAttribute("scoreList", studentSelectedExperiment);
        return "studentScore";
    }

    @RequestMapping("/showNewExperimentBox.do")
    public String showNewExperimentBox(Model model) {
        List<College> colleges = null;
        List<String> experimentNames = null;
        List<String> experimentPlaces = null;
        List<Teacher> teachers = null;
        try {
            colleges = collegeService.queryAllCollegesInfo();
            experimentNames = experimentService.queryExperimentName();
            experimentPlaces = experimentService.queryExperimentPlace();
            teachers = userService.queryAllTeachers();
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        model.addAttribute("teachers", teachers);
        model.addAttribute("colleges", colleges);
        model.addAttribute("experimentNames", experimentNames);
        model.addAttribute("experimentPlaces", experimentPlaces);
        return "newExperiment";
    }

    @ResponseBody
    @RequestMapping(value = "/submitNewExperiment.do", produces = "application/json;charset=UTF-8")
    public Object submitNewExperiment(long submitTeacherId, String experimentTime, String experimentPlace,
                                      String experimentName, long teacherId, String teacherName,
                                      int capacity) {
        //返回前端的结果
        Result<String> result = null;
        try {
            experimentTime = experimentTime.replace('T', ' ');
            System.out.println(experimentTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = dateFormat.parse(experimentTime);
            //获取星期
            dateFormat.applyPattern("E");
            ExperimentTemp experimentTemp = new ExperimentTemp(submitTeacherId, experimentName, date,
                    dateFormat.format(date), experimentPlace, teacherId, capacity);

            experimentTempService.submitNewExperiment(experimentTemp);
            //成功更新
            result = new Result<>(true, ExperimentStateEnum.SUBMIT_EXPERIMENT_SUCCESS.getStateInfo(), ExperimentStateEnum.SUBMIT_EXPERIMENT_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, ExperimentStateEnum.SUBMIT_EXPERIMENT_FAILED.getStateInfo(), ExperimentStateEnum.SUBMIT_EXPERIMENT_FAILED.getState());
        }
        return result;
    }

    @RequestMapping("/showSubmitExperiments.do")
    public String showSubmitExperiments(long submitTeacherId, Model model) {
        List<ExperimentTemp> tempList = null;
        HashMap<Long, String> teachers = new HashMap<>();
        String submitTeacher = "";
        try {
            tempList = experimentTempService.queryTeacherSubmitExperiments(submitTeacherId);
            for (ExperimentTemp temp : tempList) {
                teachers.put(temp.getTeacherId(), userService.queryTeacher(temp.getTeacherId()).getTeacherName());
            }
            submitTeacher = userService.queryTeacher(submitTeacherId).getTeacherName();
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        model.addAttribute("submitTeacher", submitTeacher);
        model.addAttribute("teachers", teachers);
        model.addAttribute("submitExperiments", tempList);
        return "submitExperiments";
    }

    @RequestMapping("/showTeacherExperiments.do")
    public String showSelfExperiments(long teacherId, Model model) {
        List<Experiment> teacherExperiments = null;
        try {
            teacherExperiments = experimentService.queryTeacherExperimentsById(teacherId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        model.addAttribute("teacherExperiments", teacherExperiments);
        return "showTeacherExperiments";
    }

    @RequestMapping("/showExperimentStudents.do")
    public String showExperimentStudents(long teacherId, Model model) {
        List<Experiment> teacherExperiments = null;
        HashMap<Long, List<Student>> experimentStudentMap = new HashMap<>();
        try {
            teacherExperiments = experimentService.queryTeacherExperimentsById(teacherId);
            for (Experiment e : teacherExperiments) {
                List<Student> students = experimentSelectedService.queryExperimentStudents(e.getExperimentId());
                experimentStudentMap.put(e.getExperimentId(), students);
            }
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        model.addAttribute("teacherExperiments", teacherExperiments);
        model.addAttribute("experimentStudentMap", experimentStudentMap);
        return "showExperimentStudents";
    }

    @RequestMapping("showStudentScore.do")
    public String showStudentScore(long teacherId, Model model) {
        List<Experiment> teacherExperiments = null;
        //键为experimentId  value为List<ExperimentSelected>
        HashMap<Long, List<ExperimentSelected>> experimentRecords = new HashMap<>();
        try {
            teacherExperiments = experimentService.queryTeacherExperimentsById(teacherId);
            for (Experiment e : teacherExperiments) {
                List<ExperimentSelected> selectedList = experimentSelectedService.queryOneSelectedExperiments(e.getExperimentId());
                experimentRecords.put(e.getExperimentId(), selectedList);
            }
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
        model.addAttribute("experimentRecords", experimentRecords);
        model.addAttribute("teacherExperiments", teacherExperiments);
        return "scoreRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/submitStudentScore.do", produces = "application/json;charset=UTF-8")
    public Object submitStudentScore(long experimentId, long studentId, int score) {
        Result<String> result = null;
        try {
            int state = experimentSelectedService.inputExperimentScore(experimentId, studentId, score);
            if (state == 1) {
                result = new Result<>(true, ExperimentStateEnum.SUBMIT_SCORE_SUCCESS.getStateInfo(), ExperimentStateEnum.SUBMIT_SCORE_SUCCESS.getState());
            } else if(state == 2) {
                result = new Result<>(true, ExperimentStateEnum.SUBMIT_SCORE_SUCCESS_FINISHED.getStateInfo(), ExperimentStateEnum.SUBMIT_SCORE_SUCCESS_FINISHED.getState());
            }

        } catch (Exception ex) {
            result = new Result<>(false, ExperimentStateEnum.SUBMIT_SCORE_FAILED.getStateInfo(), ExperimentStateEnum.SUBMIT_SCORE_FAILED.getState());
        }
        return result;
    }

    @RequestMapping("/showAuditExperiments.do")
    public String showAuditExperiments(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        List<ExperimentTemp> experimentTemps = null;
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            experimentTemps = experimentTempService.queryAllAuditExperiments();
            PageInfo<ExperimentTemp> pageInfo = new PageInfo<>(experimentTemps);
            model.addAttribute("auditExperiments", pageInfo);
            //获取teacherId对应的教师信息
            List<Teacher> teachers = userService.queryAllTeachers();
            HashMap<Long, Teacher> teacherInfo = new HashMap<>();
            for (Teacher teacher : teachers) {
                teacherInfo.put(teacher.getTeacherId(), teacher);
            }
            model.addAttribute("teachers", teacherInfo);
            return "auditExperiments";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @RequestMapping("/showAuditHistory.do")
    public String showAuditHistory(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        List<ExperimentTemp> allTempExperiments = null;
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            allTempExperiments = experimentTempService.queryAllTempExperiments();
            PageInfo<ExperimentTemp> pageInfo = new PageInfo<>(allTempExperiments);
            model.addAttribute("allTempExperiments", pageInfo);
            //获取teacherId对应的教师信息
            List<Teacher> teachers = userService.queryAllTeachers();
            HashMap<Long, Teacher> teacherInfo = new HashMap<>();
            for (Teacher teacher : teachers) {
                teacherInfo.put(teacher.getTeacherId(), teacher);
            }
            model.addAttribute("teachers", teacherInfo);
            //获取管理员信息
            HashMap<String, Admin> adminInfo = new HashMap<>();
            List<Admin> admins = userService.queryAllAdmins();
            for (Admin admin : admins) {
                adminInfo.put(admin.getAccount(), admin);
            }
            model.addAttribute("admins", adminInfo);
            return "auditHistory";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/auditPass.do", produces = "application/json;charset=UTF-8")
    public Object auditExperimentPass(long tempId, String auditAdminAccount) {
        Result<String> result = null;
        try {
            experimentTempService.auditPassAndRelease(tempId, auditAdminAccount);
            result = new Result<>(true, AuditExperimentStateEnum.AUDIT_PASS_SUCCESS.getStateInfo(), AuditExperimentStateEnum.AUDIT_PASS_SUCCESS.getState());
        } catch (RuntimeException ex) {
            result = new Result<>(false, AuditExperimentStateEnum.AUDIT_PASS_FAILED.getStateInfo(), AuditExperimentStateEnum.AUDIT_PASS_FAILED.getState());
        } catch (Exception ex) {
            result = new Result<>(false, AuditExperimentStateEnum.AUDIT_INNER_ERROR.getStateInfo(), AuditExperimentStateEnum.AUDIT_INNER_ERROR.getState());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/auditNotPass.do", produces = "application/json;charset=UTF-8")
    public Object auditExperimentNotPass(long tempId, String auditAdminAccount) {
        Result<String> result = null;
        try {
            experimentTempService.updateExperimentState(tempId, AUDIT_NOT_PASS, auditAdminAccount);
            result = new Result<>(true, AuditExperimentStateEnum.AUDIT_NOT_PASS_SUCCESS.getStateInfo(), AuditExperimentStateEnum.AUDIT_NOT_PASS_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, AuditExperimentStateEnum.AUDIT_NOT_PASS_FAILED.getStateInfo(), AuditExperimentStateEnum.AUDIT_NOT_PASS_FAILED.getState());
        }
        return result;
    }

    @RequestMapping("/showAllowSelectedExperiments.do")
    public String showAllowSelectedExperiments(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        List<Experiment> allowSelectedList = null;
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        try {
            //开始分页
            PageHelper.startPage(currentPageNum, currentPageSize, true);
            allowSelectedList = experimentService.queryAllowSelectedExperiments();
            PageInfo<Experiment> pageInfo = new PageInfo<>(allowSelectedList);
            model.addAttribute("allowSelectedList", pageInfo);
            HashMap<Long, Date> experimentDeadLine = new HashMap<>();
            for (Experiment e : allowSelectedList) {
                Date date = new Date(e.getExperimentTime().getTime() - EXPERIMENT_DEADLINE);
                experimentDeadLine.put(e.getExperimentId(), date);
            }
            model.addAttribute("experimentDeadLine", experimentDeadLine);
            return "showAllowSelectedList";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "mistake";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/setExperimentNotAllowSelected.do", produces = "application/json;charset=UTF-8")
    public Object setExperimentNotAllowSelected(long experimentId) {
        Result<String> result = null;
        try {
            experimentService.setExperimentNotAllowSelected(experimentId);
            //到这里说明设置成功
            result = new Result<>(true, ExperimentStateEnum.SET_NOT_ALLOW_SELECTED_SUCCESS.getStateInfo(), ExperimentStateEnum.SET_NOT_ALLOW_SELECTED_SUCCESS.getState());
        } catch (Exception ex) {
            result = new Result<>(false, ExperimentStateEnum.SET_NOT_ALLOW_SELECTED_FAILED.getStateInfo(), ExperimentStateEnum.SET_NOT_ALLOW_SELECTED_FAILED.getState());
        }
        return result;
    }
}
