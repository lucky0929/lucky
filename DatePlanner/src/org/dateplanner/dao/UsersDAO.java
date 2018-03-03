package org.dateplanner.dao;

import org.dateplanner.vo.User;

public interface UsersDAO {
	
	public boolean insert(User user);
	public boolean idExist(String id);
	public User selectOne(String id);
	
} //interface UsersDAO;