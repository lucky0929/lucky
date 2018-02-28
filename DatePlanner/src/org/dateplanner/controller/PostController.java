package org.dateplanner.controller;

import java.util.HashMap;

import org.dateplanner.service.BoardService;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("post")
public class PostController {
	
	@Autowired
	BoardService boardService;

	
	@RequestMapping("writeForm")
	public String writeForm() { return ""; }
	@RequestMapping("doWrite")
	public String doWrite(@RequestParam HashMap<String, String> postMap) {
		boardService.insert(boardService.HashMapToPostVO(postMap));
		
		return null;
	} //doWrite();
	
	@RequestMapping("delete")
	public String delete(@RequestParam int no) {
		boardService.delete(no);
		return "";
	} //delete();
	
	@RequestMapping("updateForm")
	public String updateForm() { return ""; }
	@RequestMapping("update")
	public String update(@RequestParam Post post) {
		boardService.update(post);
		return "";
	} //update();
	
	@RequestMapping("searchTitle")
	public String searchTitle(@RequestParam String titlez	) {
		boardService.searchWithTitle(title);
		return "";
	} //update();
	
} //class PlaceController;
