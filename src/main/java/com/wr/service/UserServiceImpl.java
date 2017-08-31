package com.wr.service;

import com.wr.domain.User;
import org.springframework.stereotype.Service;
import com.wr.dao.UserDao;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;  
  
    public User selectUserById(String userId) {
        return userDao.selectUserById(userId);  

    }  
}
