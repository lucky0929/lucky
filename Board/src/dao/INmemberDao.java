package dao;

import java.util.HashMap;

import model.NaverProfile;

public interface INmemberDao {
	
	public HashMap<String, Object> selectOne(String id);
	
	public void insertMember(HashMap<String, Object> params);
}
