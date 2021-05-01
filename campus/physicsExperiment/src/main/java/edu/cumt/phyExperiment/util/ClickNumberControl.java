package edu.cumt.phyExperiment.util;

import edu.cumt.phyExperiment.dao.ExperimentDao;
import edu.cumt.phyExperiment.entity.Experiment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class ClickNumberControl {

    @Autowired
    private ExperimentDao experimentDaoTemp;

    private static ExperimentDao experimentDao;

    //设置每个实验的选课点击人数不能超过如下值
    public static final int MAX_CLICK_NUMBER = 10;
    //保存每个实验选课的点击数，当点击数超过一定次数时拦截
    private static HashMap<Long, Semaphore> countClickNumber = new HashMap<>();

    @PostConstruct
    //程序启动后会自动执行该方法
    public void init() {
        //将注入的对象重新赋值给静态对象
        experimentDao = experimentDaoTemp;
        for (Experiment e : experimentDao.queryAllowSelectedExperiments()) {
            //赋值完后就可以调用方法
            //这里的Semaphore表示每次最多只能有一个学生选experimentId对应的实验
            countClickNumber.put(e.getExperimentId(), new Semaphore(1));
        }
    }

    public static HashMap<Long, Semaphore> getCountClickNumber() {
        return countClickNumber;
    }
}
