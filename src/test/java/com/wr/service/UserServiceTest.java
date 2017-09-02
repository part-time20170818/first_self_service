package com.wr.service;

import com.wr.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath:application.xml","classpath:/springmvc/spring-mvc.xml"})
public class UserServiceTest{
    @Autowired
    private UserService userService;
	
	@Test  
    public void selectUserByIdTest() throws UnknownHostException {
	    System.out.print("123456");
        User user = userService.selectUserById("1");
        InetAddress address = getAddress();//获取的是本地的IP地址
        user.setIp(address+"");
        System.out.println(user.getUserName() + ":" + user.getUserPassword()+":"+user.getIp());
    }
    private static InetAddress getAddress() {
        try {
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                if (addresses.hasMoreElements()) {
                    return addresses.nextElement();
                }
            }
        } catch (SocketException e) {
            //logger.debug("Error when getting host ip address: <{}>.", e.getMessage());
        }
        return null;
    }
}
