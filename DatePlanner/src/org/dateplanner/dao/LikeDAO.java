package org.dateplanner.dao;

public interface LikeDAO {
	public int selectCount(int boardNo);
	public int userCheck(int boardNo, int userNo);
	public void insertLike(int boardNo, int userNO);
	public void deleteLike(int boardNo);
 	
}
