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
        try {
            return collegeDao.queryCollegeNameById(collegeId);
        } catch (Exception ex) {
            throw new RuntimeException("查询学院名称时遇到错误");
        }
    }

    @Override
    public List<College> queryAllCollegesInfo() {
        try {
            return collegeDao.queryAllColleges();
        } catch (Exception ex) {
            throw new RuntimeException("查询所有学院信息时遇到错误");
        }
    }

    @Override
    public String queryCollegeDescriptionById(long collegeId) {
        try {
            return collegeDao.queryCollegeDescriptionById(collegeId);
        } catch (Exception ex) {
            throw new RuntimeException("查询学院简介时遇到错误");
        }
    }
}
