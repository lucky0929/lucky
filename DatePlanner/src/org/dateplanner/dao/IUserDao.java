package org.dateplanner.dao;

import java.util.HashMap;
import java.util.List;

public interface IUserDao {
	
	public HashMap<String, Object> selectOne(String userId);
	public void deleteOne (String userId);
	public void insertUser(String userId);
	public void selectNoWithId(String userId);
	public void insertUserFacebook(String userId);
	
}
