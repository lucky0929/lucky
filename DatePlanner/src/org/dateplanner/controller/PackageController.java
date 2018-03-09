package org.dateplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.PackageService;
import org.dateplanner.util.FileReceiver;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.util.RedirectWithAlert;
import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("package")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@RequestMapping("create")
	public ModelAndView create(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("placeList",
				packageService.selectPackageable(((User)session.getAttribute("loginInfo")).getNo()));
		
		return model;
		
	}
	
	@RequestMapping("create/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(Collections.singletonMap("result", FileReceiver.receiveFile(request, "/package/img/"))); }
	
	@RequestMapping(path = "doCreate", params = { "title", "content", "image", "placeList", "regionNo" })
	public ModelAndView doCreate(HttpSession session, @ModelAttribute Post post, String placeList) {
		
		Package pack = new Package();
		post.setUser(new User(((User)session.getAttribute("loginInfo")).getNo()));
		pack.setPost(post);
		List<Post> _placeList = new ArrayList<>();
		if(!placeList.isEmpty()) {
			String[] placeArr = placeList.split(",");
			for(String place : placeArr)
				_placeList.add(new Post(Integer.parseInt(place)));
		}
		pack.setPlaceList(_placeList);
		
		if(!packageService.createPackage(pack))
			return new RedirectWithAlert("패키지 만들기 - DatePlanner", "패키지 작성에 실패했습니다", "create");
		
		return new ModelAndView("redirect:../");
		
	} //doCreate();
	
	@RequestMapping("view/{no}")
	public ModelAndView view(@PathVariable int no) {
		
		ModelAndView model = new ModelAndView("package/view");
		
		model.addObject("pack", packageService.selectPackage(no));
		
		return model;
		
	} //view();
	
} //class PackageController;
