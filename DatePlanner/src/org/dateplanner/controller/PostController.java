package org.dateplanner.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.BoardService;
import org.dateplanner.vo.Post;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller @RequestMapping("post")
public class PostController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write")
	public void write() {}
	
	@RequestMapping("write/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request) throws IOException {
		
		List<String> result = new ArrayList<>();
		
		Iterator<String> fileNames = request.getFileNames();
		while(fileNames.hasNext()) {
			
			try {
				
				MultipartFile file = request.getFile(fileNames.next());
				String originalFileName = file.getOriginalFilename();
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf('.'));
				
				file.transferTo(new File(request.getServletContext().getRealPath("/post/img/") + fileName));
				result.add(fileName);
				
			}catch (IOException e) { e.printStackTrace(); }
			
		}
		
		System.out.println("[DEBUG] Upload Location: " + request.getServletContext().getRealPath("/post/img/"));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(result), headers, HttpStatus.OK);
		
	} //writeUpload();
	
	@RequestMapping(path = "doWrite", params = { "title", "content", "image", "lat", "lng", "regionNo", "files" })
	public String doWrite(HttpSession session, @ModelAttribute Post post) {
		
		User loginInfo = (User)session.getAttribute("loginInfo");
		
		post.setUser(loginInfo);
		
		if(loginInfo != null) {
			
			post.setPackageable(post.getPackageable() != null);
			post.setUser(loginInfo);
			
			if(!boardService.write(post))
				return "redirect:write";
			
		}
		
		return "redirect:../";
		
	} //doWrite();
	
	@RequestMapping(path = "view", params = "no")
	public ModelAndView view(int no) {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("post", boardService.selectOne(no));
		
		return model;
		
	} //view();
	
} //class PlaceController;
