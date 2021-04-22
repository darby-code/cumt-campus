package edu.cumt.phyExperiment;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 因为之后要写测试方法，测试前需要让程序读取spring-dao和mybatis等配置文件
 * 定义BaseTest 让所有测试继承它，就不需要重复配置
 *
 * 配置spring和junit整合，junit启动时加载 springIOC容器 spring-test junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-*.xml"})
public class BaseTest {
}
