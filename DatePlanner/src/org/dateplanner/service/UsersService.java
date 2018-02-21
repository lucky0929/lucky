package org.dateplanner.service;

import org.dateplanner.dao.UsersDAO;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UsersDAO {
	
	@Autowired
	private UsersDAO usersDAO;

	@Override public User loginAPI() { return usersDAO.loginAPI(); }
	@Override public void insert() { }
	@Override public void delete() { }
	@Override public void update() { }
	
} //class UserService
