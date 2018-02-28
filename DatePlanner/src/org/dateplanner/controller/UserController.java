package org.dateplanner.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.UsersService;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("user")
public class UserController {
	
	//isnertForm 등 ViewPage는 isnert
	//insert를 처리하는 Non-ViewPage는 doInsert
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping("insertForm")
	public String insertForm() { return "insertForm"; }
	
	@RequestMapping("update")
	public String update(@RequestParam HashMap<String, String> userInfo, Model model, HttpSession session) {
		Map<String, String> map = userInfo;
		userService.update(userService.HashMapToUserVO(userInfo));
		return "profilepage";
	}

	@RequestMapping("profilepage")
	public String profilepage(HttpSession session) {
		return null;
	}

	@RequestMapping("login")
	public String login(HttpSession session,@RequestParam(required = true, value="id") String id, @RequestParam(required = true, value="pw") String pw) {
		if(userService.login(id, pw) != null) {
			session.setAttribute("message", "로그인 실패");
		}
		return "";
	}
	
	@RequestMapping("join")
	public String join(@RequestParam HashMap<String, String> userMap, Model model, HttpSession session) {
		/* id중복
		 * 이미지업로드
		 * 아이디 중복일경우 아이디칸 빨간 테두리 생성 */
		 
		if(userService.idCheck(userMap.get("id")) != 0) {
			model.addAttribute("loginFales","<script>alert('아이디가 중복됩니다.'); history.go(-1);</script>");
			return "insertForm";
		}
		try {
			userService.join(userService.HashMapToUserVO(userMap));
		} catch (Exception e) { return "error"; }
//		if(userService.join(info)) session.setAttribute("message", "성공?");
//		if(userService.join(user))
//			model.addAttribute("message", "<script>alert(\"성공?\");<script>");
		model.addAttribute("message", "<script>alert(\"성공?\");<script>");
		return "/";
	} //join();

	@RequestMapping("delete")
	public String delete(HttpSession session) {
		//delete session 적용시 변동 
//		userService.delete(session.getAttribute("userInfo"));
		session.removeAttribute("userinfo");
		return "/";
	}
	
} //class LoginController;