package com.wr.service;

import com.wr.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath:application.xml","classpath:/springmvc/spring-mvc.xml"})
public class UserServiceTest{
    @Autowired
    private UserService userService;
	
	@Test  
    public void selectUserByIdTest() throws UnknownHostException {
	    System.out.print("123456");
        User user = userService.selectUserById("1");
        InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  
}
