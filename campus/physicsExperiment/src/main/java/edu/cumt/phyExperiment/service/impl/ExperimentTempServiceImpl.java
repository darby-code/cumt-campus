package edu.cumt.phyExperiment.service.impl;


import edu.cumt.phyExperiment.dao.ExperimentTempDao;
import edu.cumt.phyExperiment.entity.ExperimentTemp;
import edu.cumt.phyExperiment.service.ExperimentTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ExperimentTempService")
public class ExperimentTempServiceImpl implements ExperimentTempService {
    @Autowired
    ExperimentTempDao experimentTempDao;

    @Override
    public int submitNewExperiment(ExperimentTemp experimentTemp) {
         return experimentTempDao.newExperimentSubmitByTeacher(experimentTemp);
    }

    @Override
    public List<ExperimentTemp> queryAllTempExperiments() {
        return experimentTempDao.queryAllNewExperiments();
    }

    @Override
    public int updateSubmitNewExperiment(ExperimentTemp experimentTemp) {
        return experimentTempDao.updateSubmitExperimentInfo(experimentTemp);
    }

    @Override
    public int deleteSubmitNewExperiment(long tempId) {
        return  experimentTempDao.deleteTempTableExperimentByAdmin(tempId);

    }
}
