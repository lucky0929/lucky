package org.dateplanner.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.BoardService;
import org.dateplanner.util.FileReceiver;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.vo.Post;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("post")
public class PostController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write")
	public void write() {}
	
	@RequestMapping("write/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(Collections.singletonMap("result", FileReceiver.receiveFile(request, "/post/img/"))); }
	
	@RequestMapping("write/upload/list")
	public ResponseEntity<String> writeUploadList(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(FileReceiver.receiveFiles(request, "/post/img/")); }
	
	@RequestMapping(path = "doWrite", params = { "title", "content", "image", "lat", "lng", "regionNo", "files" })
	public String doWrite(HttpSession session, @ModelAttribute Post post) {
		
		post.setUser((User)session.getAttribute("loginInfo"));
		post.setPackageable(post.getPackageable() != null);
		
		if(!boardService.write(post))
			return "redirect:write";
		
		return "redirect:../";
		
	} //doWrite();
	
	@RequestMapping(path = "view", params = "no")
	public ModelAndView view(int no) {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("post", boardService.selectOne(no));
		
		return model;
		
	} //view();
	
	@RequestMapping(path = "myPage")
	public ModelAndView myPage(HttpSession session) {
		
		User loginInfo = (User)session.getAttribute("loginInfo");
		
		List<Post> post = boardService.selectMyPage(loginInfo.getNo());
		System.out.println(post);
		ModelAndView model = new ModelAndView();
		
		model.addObject("loginInfo", loginInfo);
		model.addObject("postList", post);
		model.setViewName("post/mypage");
		
		return model;
		
	}
	
} //class PlaceController;
