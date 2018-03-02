package org.dateplanner.service;

import java.util.HashMap;
import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	public void insert(Post post) { boardDAO.insert(post); }
	public List<Post> selectRegdateDesc(int regionNo) { return boardDAO.selectRegdateDesc(regionNo); }
	public List<Post> selectRegdateAsc(int regionNo) { return boardDAO.selectRegdateAsc(regionNo); }
	public List<Post> searchWithTitle(String title) { return boardDAO.searchWithTitle(title); }
	public Post viewOneBoard(int no) { return boardDAO.viewOneBoard(no); }
	public int boardCount(int regionNo) { return boardDAO.boardCount(regionNo); }
	
	public void delete(int no) { boardDAO.delete(no); }
	public void update(Post post) { boardDAO.update(post); }

	public Post HashMapToPostVO(HashMap<String,String> postMap) {
		Post post = new Post();
		try {
			//image, title, content, user_no, 
			//region_no, packageable, regdate, lat, lng)
			post.setImage(postMap.get("image"));
			post.setTitle(postMap.get("title"));
			post.setContent(postMap.get("content"));
			post.setUserNo(Integer.valueOf(postMap.get("userNo")));
			post.setRegionNo(Integer.valueOf(postMap.get("regionNo")));
			post.setPackageable(Boolean.parseBoolean(postMap.get("packageable")));
			post.setLat(Double.parseDouble(postMap.get("lat")));
			post.setLng(Double.parseDouble(postMap.get("lng")));
			
		} catch (NullPointerException e) { e.printStackTrace(); }
		
		return post;
	} //HashMapToPostVO();
	
} //class BoardService;