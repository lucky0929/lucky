package org.dateplanner.dao;

import java.util.HashMap;

public interface LikeDAO {
	public int selectCount(int boardNo);
	public int userCheck(HashMap<String, Integer> params);
	public void insertLike(HashMap<String, Integer> params);
	public void deleteLike(HashMap<String, Integer> params);
}
