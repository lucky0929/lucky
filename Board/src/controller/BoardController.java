package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.NaverProfile;
import service.BoardService;
import service.NaverLoginService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private NaverLoginService nService;

	@RequestMapping("loginForm.do")
	public void loginForm() {
	}

	@RequestMapping("login.do")
	public String login(@RequestParam HashMap<String, Object> params,HttpSession session) {
		int loginCheck = service.login(params);
		if(loginCheck == 1) {
			session.setAttribute("userInfo", service.selectOne((String)params.get("userid")));
			return "redirect:main.do";
		}
		else {
			return "loginForm";
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");
		return "redirect:loginForm.do";
	}

	@RequestMapping("naverLogin.do")
	public String naverLogin(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session) {
		//로그인 후 code
		//		ModelAndView mav = new ModelAndView();
		try {							//프로필 받아오기                     // 토큰받아오기
			HashMap<String, Object> params = nService.getProfile(nService.getNaverToken(code, state));
			nService.naverLogin(params);
			session.setAttribute("userInfo", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:main.do";
	}

	@RequestMapping("joinForm.do")
	public void joinForm() {
	}


	@RequestMapping("join.do")
	public String join(@RequestParam HashMap<String, Object> params) {
		service.insertMember(params);
		return "redirect:loginForm.do";
	}

	//	------------------------------------   밑에부터 보드   ---------------------------------------------- 

	
	@RequestMapping("main.do")
	public ModelAndView main(HttpSession session, @RequestParam(defaultValue="1") int page) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		userInfo = (HashMap<String, Object>) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();		
		int start = (page - 1) * 5;
		
		mav.addObject("total",service.selectCount());
		mav.addObject("page", page);
		if(userInfo == null) {
			mav.setViewName("redirect:loginForm.do");
			return mav;
		}
		else {
			mav.addObject("boardList", service.selectAll(start));
			mav.setViewName("main");
			return mav;
		}
	}

	@RequestMapping("detail.do")
	public ModelAndView detail(@RequestParam int num, HttpSession session , @RequestParam("page") int page) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		userInfo = (HashMap<String, Object>) session.getAttribute("userInfo");
		service.readCountUp(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page", page);
		if(userInfo == null) {
			mav.setViewName("redirect:loginForm.do");
			return mav;
		}
		mav.addObject("comments",service.selectComment(num));
		mav.addObject("detail", service.detail(num));
		mav.setViewName("detail");
		return mav;
	}

	@RequestMapping("insertForm.do")
	public String insertForm(HttpSession session){
		HashMap<String, Object> userInfo = (HashMap<String, Object>) session.getAttribute("userInfo");
		System.out.println(session.getAttribute("userInfo"));
		if(userInfo == null) {
			return "redirect:loginForm.do";

		}
		return "insertForm";
	}

	@RequestMapping("insert.do")
	public String insert(@RequestParam HashMap<String, Object> params, HttpServletRequest request) {
		try {
			service.insertBoard(params,request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:main.do";
	}

	@RequestMapping("updateForm.do")
	public ModelAndView updateForm(int num, HttpSession session) {
		System.out.println(session.getAttribute("userInfo"));
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> userInfo = (HashMap<String, Object>) session.getAttribute("userInfo");
		if(userInfo == null) {
			mav.setViewName("redirect:loginForm.do");
			return mav;
		}
		mav.addObject("detail",service.detail(num));
		mav.setViewName("updateForm");
		return mav;
	}
	@RequestMapping("update.do")
	public String update(@RequestParam HashMap<String, Object> params ) {
		service.updateBoard(params);
		return "redirect:main.do";
	}

	@RequestMapping("deleteForm.do")
	public ModelAndView deleteForm(int num, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println(session.getAttribute("userInfo"));
		HashMap<String, Object> userInfo = (HashMap<String, Object>) session.getAttribute("userInfo");
		if(userInfo == null) {
			mav.setViewName("redirect:loginForm.do");
			return mav;
		}
		mav.addObject("detail", service.detail(num));
		mav.setViewName("deleteForm");
		return mav;
	}

	@RequestMapping("delete.do")
	public String delete(@RequestParam HashMap<String, Object> params) {
		service.deleteBoard(params);
		return "redirect:main.do";
	}



	@RequestMapping("search.do")
	public ModelAndView search(@RequestParam HashMap<String, Object> params) {
		ModelAndView mav = new ModelAndView();
		//		params.put("whatSearch", params.get(params.get("what")));
		System.out.println(params);
		mav.addObject("search", service.search(params));
		mav.setViewName("search");
		return mav;
	}



	//	-----------------------------------밑에부터 댓글 ------------------------------------

	@RequestMapping("insertComment.do")
	public String insertCommnet(@RequestParam HashMap<String, Object> params) {
		service.insertComment(params);
		return "redirect:detail.do?num="+params.get("num");
	}

	@RequestMapping("deleteComment.do")
	public String deleteComment(@RequestParam int commentNum, int num) {
		service.deleteComment(commentNum);
		return "redirect:detail.do?num="+num;
	}

	@RequestMapping("updateCommentForm.do")
	public ModelAndView updateCommentForm(@RequestParam HashMap<String, Object> params) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("comment", service.oneComment((String)params.get("commentNum")));
		mav.setViewName("updateCommentForm");
		return mav;
	}

	@RequestMapping("updateComment.do")
	public String updateComment(@RequestParam HashMap<String, Object> params) {
		service.updateComment(params);
		return "redirect:detail.do?num="+params.get("num");
	}


}
