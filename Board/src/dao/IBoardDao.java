package dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IBoardDao {
	
	public int selectCount();
	
	public int searchCount(HashMap<String, Object> params);

	public void insertBoard(HashMap<String, Object> params);
	
	public List<HashMap<String, Object>> selectAll(int start);
	
	public List<HashMap<String, Object>> searchBoard(String title); 
	
	public void deleteBoard(HashMap<String, Object> params);
	
	public void updateBoard(HashMap<String, Object> params);
	
	public HashMap<String, Object> detail(int num);
	
	public void readCountUp(int num);
	
	public List<HashMap<String, Object>> search(HashMap<String, Object> params);
	
//	-------------댓글 --------------------
	
	
	public void insertComment(HashMap<String, Object> params);
	
	public List<HashMap<String, Object>> selectComment(int num);
	
	public void deleteComment(int commentNum);
	
	public void updateComment(HashMap<String, Object> params);
	
	public HashMap<String, Object> oneComment(String commentNum);
	
}
