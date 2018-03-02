package org.dateplanner.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.dateplanner.service.BoardService;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		System.out.println("[DEBUG]Upload Location: " + request.getServletContext().getRealPath("/post/img/"));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(result), headers, HttpStatus.OK);
		
	} //writeUpload();
	
	@RequestMapping(path = "doWrite", params = { "title", "x", "y", "region_no", "content", "files" })
	public void doWrite(@RequestParam Map<String, Object> params) throws IOException {
		
		System.out.println(new String(params.get("content").toString().getBytes("l1"), "UTF-8"));
		
		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(System.out, params);
		
	} //doWrite();
	
	@RequestMapping("view/{no}")
	public ModelAndView view(@PathVariable int no) {
		
		ModelAndView model = new ModelAndView("post/view");
		
		model.addObject("post", boardService.getPost(no));
		
		return model;
		
	} //view();
	
	
	
	
	
	
	
	
	@RequestMapping("writeForm")
	public String writeForm() { return "boardInsert"; }
	
//	@RequestMapping("doWrite")
//	public String doWrite(@RequestParam HashMap<String, String> postMap) {
//		boardService.insert(boardService.HashMapToPostVO(postMap));
//		
//		return null;
//	} //doWrite();
	
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
//		boardService.searchWithTitle(title);
		return "";
	} //update();
	
} //class PlaceController;
