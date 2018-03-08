package org.dateplanner.service;

import java.util.HashMap;

import org.dateplanner.dao.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
	
	@Autowired
	LikeDAO likeDAO;
	
	public int selectCount(int boardNo){ return likeDAO.selectCount(boardNo); }
	public int userCheck(HashMap<String, Integer> params){ return likeDAO.userCheck(params); }
	public void insertLike(HashMap<String, Integer> params){ likeDAO.insertLike(params); }
	public void deleteLike(HashMap<String, Integer> params){ likeDAO.deleteLike(params); }

}