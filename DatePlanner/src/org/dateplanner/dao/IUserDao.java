package org.dateplanner.dao;

import java.util.HashMap;
import java.util.List;

public interface IUserDao {
	
	public HashMap<String, Object> selectOne(String userId);
	
}
