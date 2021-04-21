package com.doug.ssm.service.impl;

import com.doug.ssm.dao.*;
import com.doug.ssm.entity.*;
import com.doug.ssm.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private ExperimentDao experimentDao;
    @Autowired
    private ExperimentLimitDao experimentLimitDao;
    @Autowired
    private ExperimentSelectedDao experimentSelectedDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Experiment> queryTeacherExperimentsBy(Integer teacherId) {
        List<Experiment> experimentList = experimentDao.queryExperimentsBy(teacherId);
        for (Experiment e : experimentList) {
            e.setLimitCollege(new ArrayList<>());
            List<Integer> limitList = experimentLimitDao.queryExperimentLimitCollegeIdBy(e.getExperimentId());
            for (Integer i : limitList) {
                e.getLimitCollege().add(collegeDao.queryCollegeNameBy(i));
            }
        }
        return experimentList;
    }

    @Override
    public List<String> queryExperimentLimitCollegeNameBy(Integer experimentId) {
        List<String> collegeNameList = new ArrayList<>();
        List<Integer> collegeIdList = experimentLimitDao.queryExperimentLimitCollegeIdBy(experimentId);
        for (Integer i : collegeIdList) {
            collegeNameList.add(collegeDao.queryCollegeNameBy(i));
        }
        return collegeNameList;
    }

    @Override
    public List<College> queryAllColleges() {
        return collegeDao.queryAllColleges();
    }

    @Override
    public int insertExperiment(String eName, Date eTime, String ePlace, int capacity, int teacherId) {
       Experiment experiment = new Experiment();
       experiment.setExperimentName(eName);
       experiment.setExperimentTime(new Date());
       experiment.setExperimentPlace(ePlace);
       experiment.setCapacity(capacity);
       experiment.setTeacherId(teacherId);
       return experimentDao.insertExperiment(experiment);
    }

    @Override
    public int insertCollegeLimit(String det, Integer experimentId) {
        String[] collegeList = det.split(",");
        int result = 0;
        for (String s : collegeList) {
            ExperimentLimit limit = new ExperimentLimit();
            limit.setExperimentId(experimentId);
            limit.setCollegeId(Integer.parseInt(s));
            result += experimentLimitDao.insertCollegeLimit(limit);
        }
        return result;
    }

    @Override
    public Experiment queryExperimentInfoBy(Integer experimentId) {
        return experimentDao.queryExperimentBy(experimentId);
    }

    @Override
    public List<Integer> queryExperimentLimitBy(Integer experimentId) {
        return experimentLimitDao.queryExperimentLimitCollegeIdBy(experimentId);
    }

    @Override
    public int updateExperiment(Integer experimentId, String eName, Date eTime, String ePlace, int capacity, int teacherId) {
        Experiment experiment = new Experiment();
        experiment.setExperimentName(eName);
        experiment.setExperimentTime(new Date());
        experiment.setExperimentPlace(ePlace);
        experiment.setCapacity(capacity);
        experiment.setTeacherId(teacherId);
        experiment.setExperimentId(experimentId);
        return experimentDao.updateExperiment(experiment);
    }

    @Override
    public int updateCollegeLimit(String det, Integer experimentId) {
        String[] collegeList = det.split(",");
        experimentLimitDao.deleteExperimentLimitBy(experimentId);
        int result = 0;
        for (String s : collegeList) {
            ExperimentLimit limit = new ExperimentLimit();
            limit.setExperimentId(experimentId);
            limit.setCollegeId(Integer.parseInt(s));
            result += experimentLimitDao.insertCollegeLimit(limit);
        }
        return result;
    }

    @Override
    public int deleteExperiment(Integer experimentId) {
        int result = 0;
        result = experimentDao.deleteExperimentBy(experimentId);
        experimentSelectedDao.deleteStudentBy(experimentId);
        experimentLimitDao.deleteExperimentLimitBy(experimentId);
        return result;
    }

    @Override
    public List<Student> queryExperimentStudentBy(Integer experimentId) {
        List<Student> studentList = new ArrayList<>();
        List<ExperimentSelected> selecteds = experimentSelectedDao.queryExperimentSelectedBy(experimentId);
        for (ExperimentSelected es : selecteds) {
            Student student = userDao.queryStudentBy(es.getStudentId());
            student.setScore(es.getScore());
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public int updateScore(Integer experimentId, Integer studentId, int score) {
        ExperimentSelected selected = new ExperimentSelected();
        selected.setExperimentId(experimentId);
        selected.setStudentId(studentId);
        selected.setScore(score);
        return experimentSelectedDao.updateScore(selected);
    }

    @Override
    public List<Student> queryStudentBy(Integer experimentId, Integer studentId) {
        List<Student> students = new ArrayList<>();
        List<ExperimentSelected> selecteds = experimentSelectedDao.queryExperimentSelectedBy(experimentId);
        for (ExperimentSelected es : selecteds) {
            Student student = userDao.queryStudentBy(es.getStudentId());
            student.setScore(es.getScore());
            if (student.getStudentId() == studentId) {
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public List<Experiment> queryStudentExperiments(Integer studentId) {
        List<Experiment> experiments = experimentDao.queryAllExperiments();
        List<Integer> studentSelectedList = experimentSelectedDao.queryStudentSelectedExperimentsBy(studentId);
        for (Experiment e : experiments) {
            e.setLimitCollege(new ArrayList<>());
            List<Integer> limitList = experimentLimitDao.queryExperimentLimitCollegeIdBy(e.getExperimentId());
            for (Integer i : limitList) {
                e.getLimitCollege().add(collegeDao.queryCollegeNameBy(i));
            }
            e.setIsSelected(0);
            for (int i : studentSelectedList) {
                if (e.getExperimentId() == i) {
                    e.setIsSelected(1);
                    break;
                }
            }
        }
        return experiments;
    }

    @Override
    public void selectedSuccess(Integer experimentId, Integer studentId) {
        experimentDao.experimentSelectedNumberPlusOne(experimentId);
        ExperimentSelected selected = new ExperimentSelected();
        selected.setScore(0);
        selected.setExperimentId(experimentId);
        selected.setStudentId(studentId);
        experimentSelectedDao.insertExperimentSelected(selected);
    }

    @Override
    public boolean checkStudentCollege(Integer experimentId, Integer studentId) {
        int studentCollegeId = userDao.queryStudentBy(studentId).getCollegeId();
        List<Integer> experimentCollegeId = experimentLimitDao.queryExperimentLimitCollegeIdBy(experimentId);
        for (int i : experimentCollegeId) {
            if(studentCollegeId == i) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteSelectedExperiment(Integer studentId, Integer experimentId) {
        experimentDao.experimentSelectedNumberReduceOne(experimentId);
        ExperimentSelected selected = new ExperimentSelected();
        selected.setStudentId(studentId);
        selected.setExperimentId(experimentId);
        experimentSelectedDao.deleteExperimentBy(selected);
    }

    @Override
    public List<Experiment> queryCollegeExperiment(Integer collegeId) {
        return null;
    }


}
