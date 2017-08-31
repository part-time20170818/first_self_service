package com.wr.baseTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiewenge on 2017/8/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath:application.xml","classpath:/springmvc/spring-mvc.xml"})
public class BaseJunit4Test {
}
