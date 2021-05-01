package edu.cumt.phyExperiment.service;

import edu.cumt.phyExperiment.entity.ExperimentTemp;

import java.util.List;

public interface ExperimentTempService {

    int submitNewExperiment(ExperimentTemp experimentTemp);

    List<ExperimentTemp> queryAllTempExperiments();

    int updateSubmitNewExperiment(ExperimentTemp experimentTemp);

    int deleteSubmitNewExperiment(long tempId);
}
