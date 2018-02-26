package org.dateplanner.service;

import java.util.HashMap;

import org.dateplanner.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public Boolean join(HashMap<String, String> user) { return usersDAO.insertDateplanner(user); }
	
} //class UsersService;
