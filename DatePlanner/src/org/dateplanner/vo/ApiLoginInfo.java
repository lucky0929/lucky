package org.dateplanner.vo;

public class ApiLoginInfo {
	
	private ApiToken apiToken;
	private LoginInfo loginInfo;
	
	public ApiToken getApiToken() { return apiToken; }
	public LoginInfo getLoginInfo() { return loginInfo; }
	public void setApiToken(ApiToken apiToken) { this.apiToken = apiToken; }
	public void setLoginInfo(LoginInfo loginInfo) { this.loginInfo = loginInfo; }
	
	@Override
	public String toString() { return "ApiLoginInfo [apiToken=" + apiToken + ", loginInfo=" + loginInfo + "]"; }
	
} //class ApiLoginInfo;
