package org.dateplanner.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dateplanner.commons.Region;
import org.dateplanner.service.CommentService;
import org.dateplanner.service.LikeService;
import org.dateplanner.service.PostService;
import org.dateplanner.util.FileReceiver;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.vo.Page;
import org.dateplanner.vo.Post;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("write")
	public ModelAndView write(HttpSession session) { return new ModelAndView().addObject("regionNo", Region.getRegionNo(session)); }
	
	@RequestMapping("img/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(Collections.singletonMap("result", FileReceiver.receiveFile(request, "/post/img/"))); }
	
	@RequestMapping("img/upload/list")
	public ResponseEntity<String> writeUploadList(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(FileReceiver.receiveFiles(request, "/post/img/")); }
			
	@RequestMapping(path = "doWrite", params = { "title", "content", "regionNo", "files" })
	public String doWrite(HttpSession session, @ModelAttribute Post post) {
		
		post.setUser((User)session.getAttribute("loginInfo"));
		post.setPackageable(post.getPackageable() != null);
		
		if(!postService.write(post))
			return "redirect:write";
		
		return "redirect:../";
		
	} //doWrite();
	
	@RequestMapping("view/{no}")
	public ModelAndView view(HttpSession session, @PathVariable int no, Integer r, @RequestParam(defaultValue = "1") int p) {
		
		Page page = new Page(10, 5, p); //result 개수, 페이징 블록 수, 페이지 넘버
		
		ModelAndView model = new ModelAndView("post/view");
		
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		User user = (User)session.getAttribute("loginInfo");
		params.put("boardNo", no);
		params.put("userNo",user.getNo());
		
		System.out.println(commentService.selectByBoardNo(no, page));
		
		model.addObject("post", postService.selectOne(no));
		model.addObject("profile", user.getProfile());
		model.addObject("comment", commentService.selectByBoardNo(no, page));
		model.addObject("page", page);
		model.addObject("like", likeService.selectCount(no));
		model.addObject("likeCheck", likeService.userCheck(params));
		
		return model;
		
	} //view();
	
	@RequestMapping("like")
	public String likeInsert(@RequestParam int boardNo, HttpSession session, HttpServletRequest req) {
		
		User user = new User();
		user = (User)session.getAttribute("loginInfo");
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		
		params.put("boardNo", boardNo);
		params.put("userNo", user.getNo());
		
		if(likeService.userCheck(params) == 0)
		     { likeService.insertLike(params); }
		else { likeService.deleteLike(params); }
		 	
		return "redirect:/post/view/"+boardNo;
	} //like()
	
	@RequestMapping("update/{no}")
	public ModelAndView update(@PathVariable int no) {
		
		ModelAndView model = new ModelAndView("post/update");
		model.addObject("post", postService.selectOne(no));
		return model;
		
	} //update();
	
} //class PlaceController;
