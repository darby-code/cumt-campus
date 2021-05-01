package edu.cumt.phyExperiment.service.impl;

import edu.cumt.phyExperiment.dao.CollegeDao;
import edu.cumt.phyExperiment.entity.College;
import edu.cumt.phyExperiment.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {

    @Resource(name = "collegeDao")
    CollegeDao collegeDao;

    @Override
    public String queryCollegeNameById(long collegeId) {
        return collegeDao.queryCollegeNameById(collegeId);
    }

    @Override
    public List<College> queryAllCollegesInfo() {
        return collegeDao.queryAllColleges();
    }

    @Override
    public String queryCollegeDescriptionById(long collegeId) {
        return collegeDao.queryCollegeDescriptionById(collegeId);
    }
}
