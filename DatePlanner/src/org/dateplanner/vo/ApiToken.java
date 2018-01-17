package org.dateplanner.vo;

public class ApiToken {
	
	//platform: N = naver, F = facebook
	private char platform;
	private String token;
	
	public char getPlatform() { return platform; }
	public String getToken() { return token; }
	public void setPlatform(char platform) { this.platform = platform; }
	public void setToken(String token) { this.token = token; }
	
	@Override
	public String toString() { return "ApiToken [platform=" + platform + ", token=" + token + "]"; }
	
} //class ApiToken;
