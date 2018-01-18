package org.dateplanner.api;

import org.dateplanner.login.Login;
import org.dateplanner.vo.ApiLoginInfo;
import org.dateplanner.vo.LoginInfo;

public class NaverLoginAPI implements Login {
	
	@Override
	public ApiLoginInfo login(String arg) {
		
//		private String name, nickname;
//		private Integer regionNo;
//		private String profile;
//		private Character sex;
//		private String introduction;
		
		
		
		ApiLoginInfo result = new ApiLoginInfo();
		
		result.setPlatform('N');
		result.setKey("아이디");
		
		
		return result;
		
	} //login();
	
} //class NaverLoginAPI;
