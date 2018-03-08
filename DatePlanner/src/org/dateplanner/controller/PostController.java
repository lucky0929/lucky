package org.dateplanner.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.BoardService;
import org.dateplanner.service.CommentService;
import org.dateplanner.service.LikeService;
import org.dateplanner.util.FileReceiver;
import org.dateplanner.util.JsonUtil;
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
	private BoardService boardService;
	
	@Autowired
	private CommentService CommentService;
	
	@Autowired
	private LikeService likeService;
	
	
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
	public ModelAndView view(HttpSession session,int no) {
		User user = new User();
		user = (User)session.getAttribute("loginInfo");
		HashMap<String, Integer> params = new HashMap<>();
		
		params.put("boardNo", no);
		params.put("userNo", user.getNo()); 
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("post", boardService.selectOne(no));
		model.addObject("like", likeService.selectCount(no));
		model.addObject("likeCheck", likeService.userCheck(params));
		model.addObject("comment", CommentService.select(no));
		
		return model;
		
	} //view();

	@RequestMapping("like")
	public String likeInsert(int boardNo, HttpSession session) {
		
		User user = new User();
		user = (User)session.getAttribute("loginInfo");
		HashMap<String, Integer> params = new HashMap<>();
		
		params.put("boardNo", boardNo);
		params.put("userNo", user.getNo());
		
		System.out.println("파라미터임 " + params);
		if(likeService.userCheck(params) == 0) {
			likeService.insertLike(params);
		} else {
			likeService.deleteLike(params);
		}
		
		return "redirect:/post/view?no=" + boardNo;
		
	} //view();

	
	@RequestMapping("commentInsert")
	public String commentInsert(@RequestParam HashMap<String, String> params, HttpSession session) {
		User user = new User();
		user = (User)session.getAttribute("loginInfo");
		params.put("userNo", ""+user.getNo());
		params.put("seq", "1");
		CommentService.insert(CommentService.HashMapToCommentVO(params));
		
		return "redirect:/post/view?no=" + params.get("boardNo");
		
	} //commentInsert();
	
	@RequestMapping("update/{no}")
	public ModelAndView update(@PathVariable int no) { ModelAndView model = new ModelAndView("post/update"); model.addObject("post", boardService.selectOne(no)); return model; }
	
	@RequestMapping("commentUpdate")
	public String commentUpdate(String no, String content, String boardNo) {
		
		CommentService.update(no, content);
		
		return "redirect:/post/view?no=" + boardNo;
		
	} //commentUpdate();

	@RequestMapping("commentDelete")
	public String commentDelete(int no) {
		
		CommentService.delete(no);
		
		return "redirect:../";
		
	} //commentDelete();
	
	@RequestMapping(path = "myPage")
	public ModelAndView myPage(HttpSession session) {
		
		User loginInfo = (User)session.getAttribute("loginInfo");
		
		List<Post> post = boardService.selectMyPage(loginInfo.getNo());
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("loginInfo", loginInfo);
		model.addObject("postList", post);
		model.setViewName("post/mypage");
		
		return model;
		
	}
	
} //class PlaceController;
