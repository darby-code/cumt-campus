package com.doug.ssm.service;

import com.doug.ssm.entity.College;
import com.doug.ssm.entity.Experiment;
import com.doug.ssm.entity.ExperimentLimit;
import com.doug.ssm.entity.Student;

import java.util.Date;
import java.util.List;

public interface ExperimentService {
    List<Experiment> queryTeacherExperimentsBy(Integer teacherId);
    List<String> queryExperimentLimitCollegeNameBy(Integer experimentId);
    List<College> queryAllColleges();
    int insertExperiment(String eName, Date eTime, String ePlace, int capacity, int teacherId);
    int insertCollegeLimit(String det, Integer experimentId);
    Experiment queryExperimentInfoBy(Integer experimentId);
    List<Integer> queryExperimentLimitBy(Integer experimentId);
    int updateExperiment(Integer experimentId, String eName, Date eTime, String ePlace, int capacity, int teacherId);
    int updateCollegeLimit(String det, Integer experimentId);
    int deleteExperiment(Integer experimentId);
    List<Student> queryExperimentStudentBy(Integer experimentId);
    int updateScore(Integer experimentId, Integer studentId, int score);
    List<Student> queryStudentBy(Integer experimentId, Integer studentId);
    List<Experiment> queryStudentExperiments(Integer studentId);
    void selectedSuccess(Integer experimentId, Integer studentId);
    boolean checkStudentCollege(Integer experimentId, Integer studentId);
    void deleteSelectedExperiment(Integer studentId, Integer experimentId);
    List<Experiment> queryCollegeExperiment(Integer collegeId);
}
