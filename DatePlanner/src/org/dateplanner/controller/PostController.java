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
	
//	@RequestMapping("write")
//	public void write() {}
//	

//	
//	@RequestMapping(path = "doWrite", params = { "title", "content", "lat", "lng", "regionNo" })
//	public void doWrite(@RequestParam Map<String, Object> params) throws IOException {
//		
//		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(System.out, params);
//		
//	} //doWrite();
//	
//	@RequestMapping("view/{no}")
//	public ModelAndView view(@PathVariable int no) {
//		
//		ModelAndView model = new ModelAndView("post/view");
//		
//		model.addObject("post", boardService.getPost(no));
//		
//		return model;
//		
//	} //view();
//	
//	
//	
//	
//	
//	
//	
//	
//	@RequestMapping("writeForm")
//	public String writeForm() { return "boardInsert"; }
//	
////	@RequestMapping("doWrite")
////	public String doWrite(@RequestParam HashMap<String, String> postMap) {
////		boardService.insert(boardService.HashMapToPostVO(postMap));
////		
////		return null;
////	} //doWrite();
//	
//	@RequestMapping("delete")
//	public String delete(@RequestParam int no) {
//		boardService.delete(no);
//		return "";
//	} //delete();
//	
//	@RequestMapping("updateForm")
//	public String updateForm() { return ""; }
//	@RequestMapping("update")
//	public String update(@RequestParam Post post) {
//		boardService.update(post);
//		return "";
//	} //update();
//	
//	@RequestMapping("searchTitle")
//	public String searchTitle(@RequestParam String titlez	) {
////		boardService.searchWithTitle(title);
//		return "";
//	} //update();
	
} //class PlaceController;
