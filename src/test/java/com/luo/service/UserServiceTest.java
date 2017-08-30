package com.luo.service;

import com.wr.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;  
import com.luo.baseTest.SpringTestCase;  
import com.wr.domain.User;

public class UserServiceTest extends SpringTestCase {
	
	@Autowired  
    private UserService userService;
	
	@Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById("1");
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  
}
