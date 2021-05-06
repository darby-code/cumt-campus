package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.ExperimentLimitDao;
import edu.cumt.phyExperiment.entity.ExperimentLimit;
import edu.cumt.phyExperiment.service.ExperimentLimitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("experimentLimitService")
public class ExperimentLimitServiceImpl implements ExperimentLimitService {

    @Resource(name = "experimentLimitDao")
    ExperimentLimitDao experimentLimitDao;

    @Override
    public List<Long> queryExperimentAllowSelectedColleges(long experimentId) {
        try {
            return experimentLimitDao.queryExperimentLimitCollegeIdById(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("查询实验可选学院代号信息时遇到错误");
        }

    }

    @Override
    public int addConditionAtExperiment(long experimentId, List<Long> collegeConditions) {
        try {
            int result = 0;
            for (Long collegeId : collegeConditions) {
                if (collegeId != null) {
                    result += experimentLimitDao.insertCollegeLimit(experimentId, collegeId);
                }
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("为实验增加限选学院条件时遇到错误");
        }
    }

    @Override
    public int moveConditionAtExperiment(long experimentId, long collegeId) {
        try {
            return experimentLimitDao.deleteCollegeLimit(experimentId, collegeId);
        } catch (Exception ex) {
            throw new RuntimeException("删除限选学院条件时遇到错误");
        }
    }

    @Override
    public int moveAllConditionsAtExperiment(long experimentId) {
        try {
            return experimentLimitDao.deleteExperimentLimitById(experimentId);
        } catch (Exception ex) {
            throw new RuntimeException("删除一个实验所有限选学院条件时遇到错误");
        }
    }
}
