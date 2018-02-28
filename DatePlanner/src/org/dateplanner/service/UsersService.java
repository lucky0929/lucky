package org.dateplanner.service;

import java.util.HashMap;

import org.dateplanner.dao.UsersDAO;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public void join(User user) { usersDAO.insertDateplanner(user); }
	public void update(User user) { usersDAO.update(user); }
	public void delete(String id) { usersDAO.delete(id); }
	public User searchUser(String find) { return usersDAO.searchUser(find); }
	public int selectOne(String id) { return usersDAO.idCheck(id); }
	public User selectOne(String id, String pw) { return usersDAO.login(id, pw); }
	
//	public int idCheck(String id) { return usersDAO.idCheck(id); }
//	public User login(String id, String pw) { return usersDAO.login(id, pw); }
	
	public User HashMapToUserVO(HashMap<String,String> userMap) {
		User user = new User();
		try {
			user.setName(userMap.get("name"));
			user.setKey(userMap.get("key"));
			user.setNickname(userMap.get("nickname"));
			user.setSex(userMap.get("sex").charAt(0));
			user.setProfile(userMap.get("profile"));
			user.setRegionNo(Integer.valueOf(userMap.get("regionNo")));
			user.setIntroduction(userMap.get("introduction"));
			
		} catch (NullPointerException e) { e.printStackTrace(); }
		
		return user;
	}
	
} //class UsersService;
