package org.dateplanner.dao;

import org.dateplanner.vo.User;

public interface UsersDAO {
	public User loginAPI();
	public void insert();
	public void delete();
	public void update();
} //interface UsersDAO;