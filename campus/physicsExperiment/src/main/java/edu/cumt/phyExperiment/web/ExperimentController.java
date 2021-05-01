package edu.cumt.phyExperiment.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.cumt.phyExperiment.dto.DropExperimentExecution;
import edu.cumt.phyExperiment.dto.Result;
import edu.cumt.phyExperiment.dto.SelectedExecution;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.enums.StudentSelectedExperimentStateEnum;
import edu.cumt.phyExperiment.exception.*;
import edu.cumt.phyExperiment.service.ExperimentLimitService;
import edu.cumt.phyExperiment.service.ExperimentSelectedService;
import edu.cumt.phyExperiment.service.ExperimentService;
import edu.cumt.phyExperiment.service.UserService;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
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

    @RequestMapping("/allExperiments.do")
    public String allExperiments(@RequestParam(required = true, defaultValue = "1") Integer pageNum
            , @RequestParam(required = false) Integer pageSize, Model model) {
        int currentPageNum = pageNum;
        int currentPageSize = pageSize == null ? 5 : pageSize;
        //开始分页
        PageHelper.startPage(currentPageNum, currentPageSize, true);
        List<Experiment> list = experimentService.queryAllExperiments();
        PageInfo<Experiment> pageInfo = new PageInfo<Experiment>(list);
        //分页后的数据由pageInfo保存
        model.addAttribute("pageInfo", pageInfo);
        return "allExperiments";
    }

    @RequestMapping("/experimentDetails.do")
    public String experimentDetails(long experimentId, Model model) {
        Experiment experiment = experimentService.queryExperimentById(experimentId);
        model.addAttribute("clickExperiment", experiment);
        return "experimentDetails";
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
        //开始分页
        PageHelper.startPage(currentPageNum, currentPageSize, true);
        experiments = experimentService.queryExperimentByKeyWords(words);
        PageInfo<Experiment> pageInfo = new PageInfo<>(experiments);
        //分页后的数据由pageInfo保存
        model.addAttribute("pageInfo", pageInfo);
        return "allExperiments";
    }

    @RequestMapping("/selectedList.do")
    public String studentSelectedList(@RequestParam("studentId") long studentId, Model model) {
        List<Experiment> selectedList = experimentSelectedService.querySelectedExperiments(studentId);
        model.addAttribute("selectedList", selectedList);
        return "selectedList";
    }

    @ResponseBody
    @RequestMapping(value = "/dropExperiment.do", produces = "application/json;charset=UTF-8")
    public Object dropExperiment(@RequestParam(value = "studentId") long studentId
            , @RequestParam(value = "experimentId") long experimentId, Model model) {
        DropExperimentExecution execution = null;
        try {
            execution = experimentSelectedService.experimentSelectedNumberReduceOne(experimentId, studentId);
        } catch (DropExperimentException ex) {
            execution = new DropExperimentExecution(experimentId, StudentSelectedExperimentStateEnum.DROP_FAILED);
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
        model.addAttribute("studentSelectedExperiments", studentList);
        model.addAttribute("studentId", studentId);
        return "selectExperiment";
    }

    @ResponseBody
    @RequestMapping(value = "/selectExperiment.do", produces = "application/json;charset=UTF-8")
    public Object selectExperiment(long studentId, long experimentId) {
        SelectedExecution execution = null;
        try {
            execution = experimentSelectedService.experimentSelectedNumberPlusOne(experimentId, studentId);
        } catch (ConflictException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.CONFLICT);
        } catch (NoMarginException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.NO_MARGIN);
        } catch (NotAllowSelectedException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.NOT_ALLOW);
        } catch (NotExistsException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.NOT_EXISTS);
        } catch (RepeatSelectedException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.REPEAT_SELECT);
        } catch (SelectedLimitException ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.LIMIT);
        } catch (Exception ex) {
            execution = new SelectedExecution(experimentId, StudentSelectedExperimentStateEnum.INNER_ERROR);
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

//    @ResponseBody
//    @RequestMapping(value = "/dropExperimentWithoutFlush.do", produces = "application/json;charset=UTF-8")
//    public Object dropExperimentWithoutFlush(long studentId, long experimentId) {
//        DropExperimentExecution dropExperimentExecution = null;
//        try {
//            experimentSelectedService.re
//        }
//    }
}
