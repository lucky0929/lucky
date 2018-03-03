package org.dateplanner.service;

import org.dateplanner.dao.UsersDAO;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public boolean join(User user) { return usersDAO.insert(user); }
	public boolean idExist(String id) { return usersDAO.idExist(id); }
	
	public User login(String id, String password) {
		
		User result = null;
		
		User user = usersDAO.selectOne(id);
		if(user != null && user.getKey().equals(password))
			result = user;
		
		return result;
		
	} //login();
	
} //class UsersService;
