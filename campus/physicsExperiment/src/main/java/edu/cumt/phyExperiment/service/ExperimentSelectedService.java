package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.dto.DropExperimentExecution;
import edu.cumt.phyExperiment.dto.SelectedExecution;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.entity.ExperimentSelected;
import edu.cumt.phyExperiment.entity.Student;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * ExperimentSelectedService功能：
 * 学生：
 * 学生查看已选实验  querySelectedExperiments
 * 学生查询实验成绩  queryExperimentsScore (实验结课的显示,没有结课的不显示成绩)
 *  选课    experimentSelectedNumberPlusOne
 *  退课    experimentSelectedNumberReduceOne
 *
 *  教师：
 *  教师查看实验的选课学生 queryExperimentStudents
 *  教师录入成绩  inputExperimentScore
 *
 */
public interface ExperimentSelectedService {
    /**
     * 学生查看已选实验
     * @return
     */
    List<Experiment> querySelectedExperiments(long studentId);

    /**
     * 查询一个实验的选课情况
     * @param experimentId
     * @return
     */
    List<ExperimentSelected> queryOneSelectedExperiments(long experimentId);

    /**
     * 学生查询实验成绩
     * @param studentId
     * @return
     */
    List<ExperimentSelected> queryExperimentsScore(long studentId);

    /**
     * 学生实验选课
     * @param experimentId
     * @param studentId
     * @return
     */
    SelectedExecution experimentSelectedNumberPlusOne(long experimentId, long studentId) throws ExecutionException, InterruptedException;

    /**
     * 学生实验退课
     * @param experimentId
     * @param studentId
     * @return
     */
    DropExperimentExecution experimentSelectedNumberReduceOne(long experimentId, long studentId);

    /**
     * 教师查看实验的选课学生
     * @param experimentId
     * @return
     */
    List<Student> queryExperimentStudents(long experimentId);

    /**
     * 查询一条已选实验信息
     * @param experimentId
     * @param studentId
     * @return
     */
    ExperimentSelected queryOneSelectedExperiment(long experimentId, long studentId);

    /**
     * 教师录入成绩
     * @param experimentId
     * @param studentId
     * @param score
     * @return
     */
    int inputExperimentScore(long experimentId, long studentId, int score);
}
