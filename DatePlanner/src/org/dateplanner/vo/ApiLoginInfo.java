package org.dateplanner.vo;

public class ApiLoginInfo extends  LoginInfo {

	//platform: D = DatePlanner, N = Naver, F = Facebook
	private char platform;
	private String key;
	
	public char getPlatform() { return platform; }
	public String getKey() { return key; }
	public void setPlatform(char platform) { this.platform = platform; }
	public void setKey(String key) { this.key = key; }
	
	@Override
	public String toString() { return "ApiLoginInfo [platform=" + platform + ", key=" + key + ", " + super.toString() + "]"; }
	
} //class ApiLoginInfo;
