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
        return experimentLimitDao.queryExperimentLimitCollegeIdById(experimentId);
    }

    @Override
    public int addConditionAtExperiment(long experimentId, List<Long> collegeConditions) {
        int result = 0;
        for (Long collegeId : collegeConditions) {
            if (collegeId != null) {
                result += experimentLimitDao.insertCollegeLimit(experimentId, collegeId);
            }
        }
        return result;
    }

    @Override
    public int moveConditionAtExperiment(long experimentId, long collegeId) {
        return experimentLimitDao.deleteCollegeLimit(experimentId, collegeId);
    }

    @Override
    public int moveAllConditionsAtExperiment(long experimentId) {
        return experimentLimitDao.deleteExperimentLimitById(experimentId);
    }
}
