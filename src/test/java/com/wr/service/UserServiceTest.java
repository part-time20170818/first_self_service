package com.wr.service;

import com.wr.baseTest.BaseJunit4Test;
import com.wr.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseJunit4Test{
    @Autowired
    private UserService userService;
	
	@Test  
    public void selectUserByIdTest(){
	    System.out.print("123456");
        User user = userService.selectUserById("1");
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  
}
