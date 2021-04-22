package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.ExperimentLimitDao;
import edu.cumt.phyExperiment.entity.ExperimentLimit;
import edu.cumt.phyExperiment.service.ExperimentLimitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("experimentLimitService")
public class ExperimentLimitServiceImpl implements ExperimentLimitService {

    @Resource(name = "experimentLimitDao")
    ExperimentLimitDao experimentLimitDao;

    @Override
    public List<Integer> queryExperimentAllowSelectedColleges(int experimentId) {
        return experimentLimitDao.queryExperimentLimitCollegeIdBy(experimentId);
    }

    @Override
    public int addConditionAtExperiment(int experimentId, List<Integer> collegeConditions) {
        int result = 0;
        for (Integer collegeId : collegeConditions) {
            if (collegeId != null) {
                result += experimentLimitDao.insertCollegeLimit(experimentId, collegeId);
            }
        }
        return result;
    }

    @Override
    public int moveConditionAtExperiment(int experimentId, int collegeId) {
        return experimentLimitDao.deleteCollegeLimit(experimentId, collegeId);
    }

    @Override
    public int moveAllConditionsAtExperiment(int experimentId) {
        return experimentLimitDao.deleteExperimentLimitBy(experimentId);
    }
}
