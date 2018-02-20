package org.dateplanner.dao;

import org.dateplanner.vo.User;

public interface UsersDAO {
	public User selectAll();
	public void insert();
	public void delete();
} //interface UsersDAO;
