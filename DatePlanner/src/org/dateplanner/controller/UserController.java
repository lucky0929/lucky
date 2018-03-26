package org.dateplanner.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.dateplanner.commons.Region;
import org.dateplanner.service.UserService;
import org.dateplanner.util.FileReceiver;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.util.RedirectWithAlert;
import org.dateplanner.vo.Page;
import org.dateplanner.vo.User;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("join")
	public ModelAndView join(HttpSession session) { return new ModelAndView().addObject("regionNo", Region.getRegionNo(session)); }
	
	@RequestMapping("img/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.convertToResponseEntity(Collections.singletonMap("result", FileReceiver.receiveFile(request, "/user/img/")));}
	
	@RequestMapping(path = "doJoin", params = { "id", "password", "name", "nickname", "regionNo", "profile", "introduction" })
	public ModelAndView doJoin(@ModelAttribute User user, String password) {
		
		user.setKey(password);
		
		RedirectWithAlert redirect = new RedirectWithAlert("회원가입 - DatePlanner");
		
		boolean idExist;
		if((idExist = userService.idExist(user.getId())) || !userService.join(user))
			return redirect.setMessage(idExist ? "이미 존재하는 아이디 입니다" : "회원가입에 실패했습니다").setRedirect("join");
		
		return redirect.setMessage("회원가입에 성공했습니다").setRedirect("../");
		
	} //doJoin();
	
	@RequestMapping("login")
	public void login() {};
	
	@RequestMapping(path = "doLogin", params = { "id", "password" })
	public ModelAndView doLogin(HttpSession session, String id, String password) {
		
		User loginInfo = userService.login(id, password);
		if(loginInfo == null)
			return new RedirectWithAlert("로그인 - DatePlanner", "아이디 혹은 비밀번호가 틀립니다", "login");
		session.setAttribute("loginInfo", loginInfo);
		if(loginInfo.getRegionNo() != null)
			session.setAttribute("regionNo", loginInfo.getRegionNo());
		return new ModelAndView("redirect:../");
		
	} //doLogin();
	
	@RequestMapping(path = "doLogin", params = "no")
	public ModelAndView doLogin(HttpSession session, int no) {
		session.setAttribute("loginInfo", userService.selectUser(no));
		return new ModelAndView("redirect:../");
		
	} //doLogin();
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginInfo");
		
		return "redirect:../";
		
	} //logout();

	@RequestMapping("mypage")
	public String mypage(HttpSession session) { return "redirect:page/" + ((User)session.getAttribute("loginInfo")).getNo(); }
	
	@RequestMapping("facebook.do")
	   public String facebooka(@RequestParam String code) throws Exception{
	      facebook(code);
	      return "login";
	}
	
	@RequestMapping(value="update")
	   public String update(@ModelAttribute User user) {
	      userService.update(user);
	      return "redirect:mypage";
	}

	@RequestMapping(value="updateForm")
	   public String update(HttpSession session,Model model){
		User user = (User)session.getAttribute("loginInfo");
		model.addAttribute("user",userService.selectUser(user.getNo()));
	      return "updateForm";
	}
	
	@RequestMapping("delete")
	   public String delete(@RequestParam int no, HttpSession session) {
		userService.delete(no);
		session.removeAttribute("loginInfo");
	      return "redirect:/";
	}
	
	public void facebook(String code) throws Exception{
	      String access_token = "EAAc4NdS6is8BADkJ9FZCz9cTW71id2DYZBScIiD3w9oAIHwgQTZB6i5p6jwPqvD2QhIIqZAFYGq9OtNhqVPy7R3MTbGiwN1HHQ2kc0ZBH79BqiJ2qMDM03TB0KMWnStOdWpzxLQFJyLpmParXOdezZBRUV3PJY7g6DMQMtFOfz4gZDZD";
	      access_token = URLEncoder.encode(access_token,"UTF-8");
	      String user_id = "575166562829068";
	      String app_id = "2032128690391759";
	      String app_secret = "74be2c0fbdd71bddd240b3597ffaedea";
	      //토큰가져오기
	      URL url = new URL("https://graph.facebook.com/v2.11/oauth/access_token?client_id=2032128690391759&redirect_uri=http://localhost/NaverBookSearchAPI/facebook.do&client_secret=74be2c0fbdd71bddd240b3597ffaedea&code="+code);
	      //
	      URL url2 = new URL("https://graph.facebook.com/debug_token?input_token="+access_token+"&access_token="+access_token);
	      //토큰으로 정보가져오기
	      URL url3 = new URL("https://graph.facebook.com/v2.11/me?fields=id,name,picture,gender,age_range&access_token=EAAc4NdS6is8BADkJ9FZCz9cTW71id2DYZBScIiD3w9oAIHwgQTZB6i5p6jwPqvD2QhIIqZAFYGq9OtNhqVPy7R3MTbGiwN1HHQ2kc0ZBH79BqiJ2qMDM03TB0KMWnStOdWpzxLQFJyLpmParXOdezZBRUV3PJY7g6DMQMtFOfz4gZDZD");
	      //토큰갱신
	      URL url4 = new URL("https://graph.facebook.com//oauth/access_token?grant_type=fb_exchange_token&client_id="+app_id+"&client_secret="+app_secret+"&fb_exchange_token=EAAc4NdS6is8BAIYJwkVSqpUwKhlLEopM76mGLR2dMEcsHsCkF5FT5ElisUl8itJdyQN7fYnRDD3GZCZAOkD6nx7nGGdrVXRC58LSf8hkZBon6d4GWoUIm0fms2JhDqtxpDsTtAtmdN45t2cVRXZBhy5me58Rxg8oAyW48rweEAZDZD");
	      
	      HttpURLConnection urlConn = (HttpURLConnection)url.openConnection(); urlConn.disconnect();
	      HttpURLConnection urlConn2 = (HttpURLConnection)url2.openConnection(); urlConn2.disconnect();
	      HttpURLConnection urlConn3 = (HttpURLConnection)url3.openConnection();
	      BufferedReader br = new BufferedReader(new InputStreamReader(urlConn3.getInputStream(),"UTF-8"));
	      JSONObject items = (JSONObject) JSONValue.parseWithException(br);
	      System.out.println(items);
	   }
	
	@RequestMapping("page/{no}")
	public ModelAndView page(HttpSession session, @PathVariable Integer no, @RequestParam(defaultValue = "1") int p) {
		
		ModelAndView model = new ModelAndView("user/page");
		
		User user=(User)session.getAttribute("loginInfo");
		if(user.getNo() == no){
			model.addObject("mypage", true);
		}
		user = userService.selectUser(no);
		if(no == null) return new RedirectWithAlert("유저정보 페이지 - DatePlanner", "유저를 찾을수 없습니다", "../../");
		
		Page page = new Page(8, 8, p);
		
		model.addObject("userInfo", user);
		model.addObject("postList", userService.selectUsersPost(no, page));
		model.addObject("page", page);
		return model;
		
	} //page();
	
} //class LoginController;