package org.dateplanner.vo;

public class ApiToken {
	
	private String accessToken;
	private String refreshToken;
	
	public String getAccessToken() { return accessToken; }
	public String getRefreshToken() { return refreshToken; }
	public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
	public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
	
	@Override
	public String toString() {
		return "ApiToken [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	} //toString();
	
} //class ApiToken;
