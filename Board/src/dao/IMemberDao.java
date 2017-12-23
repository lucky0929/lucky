package dao;

import java.util.HashMap;

public interface IMemberDao {
	
	public void insertMember(HashMap<String, Object> params);
	
	public HashMap<String, Object> selectOne(String userid);
	
	public int login(HashMap<String, Object> params);
	
}
