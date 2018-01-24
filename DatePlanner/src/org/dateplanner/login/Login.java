package org.dateplanner.login;

import javax.servlet.http.HttpSession;

import org.dateplanner.vo.User;

public interface Login {
	
	public static void login(HttpSession session, Login login) { session.setAttribute("loginManager", login); }
	public static User getLoginInfo(HttpSession session) {
		
		User loginInfo = null;
		
		Login loginManager = (Login)session.getAttribute("loginManager");
		if(loginManager != null)
			loginInfo = loginManager.getUser(session);
		
		return loginInfo;
		
	} //getLoginInfo();
	
	public User getUser(HttpSession session);
	public void logout(HttpSession session);
	
} //interface Login;
