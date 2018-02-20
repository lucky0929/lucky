package org.dateplanner.service;

import org.dateplanner.dao.UsersDAO;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public User selectAll(){ return usersDAO.selectAll(); }
	
} //class UserService
