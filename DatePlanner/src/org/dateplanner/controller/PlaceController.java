package org.dateplanner.controller;

import org.dateplanner.service.BoardService;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("place")
public class PlaceController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(path="doWrite", params= {"title", "region_no", "user_no", "main_photo"})
	public String doWrite(String title, int region_no, int user_no, String main_photo) {
		Post post = new Post();
		post.setTitle(title);
		post.setRegion_no(region_no);
		post.setUser_no(user_no);
		post.setMain_photo(main_photo);
		boardService.insertBoard(post);
		
		return null;
		
	} //doWrite();
	
} //class PlaceController;
