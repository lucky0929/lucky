package org.dateplanner.vo;

public class ApiToken {
	
	//platform: D = DatePlanner, N = Naver, F = Facebook
	private int no;
	private char platform;
	private String key;
	
	public int getNo() { return no; }
	public char getPlatform() { return platform; }
	public String getKey() { return key; }
	public void setNo(int no) { this.no = no; }
	public void setPlatform(char platform) { this.platform = platform; }
	public void setKey(String key) { this.key = key; }
	
	@Override
	public String toString() { return "ApiToken [no=" + no + ", platform=" + platform + ", key=" + key + ", " + super.toString() + "]"; }
	
} //class ApiToken;
