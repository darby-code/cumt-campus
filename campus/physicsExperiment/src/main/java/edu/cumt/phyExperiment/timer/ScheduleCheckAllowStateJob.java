package edu.cumt.phyExperiment.timer;

import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.entity.Experiment;
import edu.cumt.phyExperiment.util.ClickNumberControl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 设置一个定时任务，检查实验选课的是否截止
 * 截止条件为，实验日期的前一天，时间小于一天的设置为不可选
 */
public class ScheduleCheckAllowStateJob {
    //实验日期前一天关闭选课
    private static final long DEADLINE = 1000 * 60 * 60 * 24;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void work() {

        try {
            ExperimentDao experimentDao = ClickNumberControl.getExperimentDao();
            List<Experiment> allowSelectedExperiments = experimentDao.queryAllowSelectedExperiments();
            Date startTime = new Date();
            logger.info("开始检查实验选课是否可以关闭，开始时间：" + startTime);
            long currentTime = (new Date()).getTime();
            int result = 0;
            for (Experiment experiment : allowSelectedExperiments) {
                if (experiment.getExperimentTime().getTime() - currentTime <= DEADLINE) {
                    //截止选课
                    result += experimentDao.setExperimentNotAllowSelected(experiment.getExperimentId());
                }
            }
            Date endTime = new Date();
            logger.info("实验选课是否可以关闭检查结束，修改记录数量为：" + result + ", 结束时间：" + endTime);
        } catch (Exception ex) {
            //遇到异常暂时不进行处理
            logger.error("异常为：" + ex.toString());
            logger.error("实验选课是否结束检查操作遇到异常，异常时间为：" + new Date());
            throw ex;
        }


    }
}
