package com.wr.dao;

import com.wr.domain.User;

public interface UserDao {
	
	/**
	 * @param userId
	 * @return User
	 */
	public User selectUserById(String userId);

}
