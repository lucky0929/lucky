package org.dateplanner.vo;

public class ApiToken {
	
	//platform: D = DatePlanner, N = Naver, F = Facebook
	private char platform;
	private String key;
	
	public char getPlatform() { return platform; }
	public String getKey() { return key; }
	public void setPlatform(char platform) { this.platform = platform; }
	public void setKey(String key) { this.key = key; }
	
	@Override
	public String toString() { return "ApiToken [platform=" + platform + ", key=" + key + "]"; }
	
} //class ApiToken;
