package org.dateplanner.vo;

public class User {
	
	private Integer no;
	private String nickname, profile, name;
	private char sex;
	private int regionNo;
	
	public Integer getNo() { return no; }
	public String getNickname() { return nickname; }
	public String getProfile() { return profile; }
	public String getName() { return name; }
	public char getSex() { return sex; }
	public int getRegionNo() { return regionNo; }
	public void setNo(Integer no) { this.no = no; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setProfile(String profile) { this.profile = profile; }
	public void setName(String name) { this.name = name; }
	public void setSex(char sex) { this.sex = sex; }
	public void setRegionNo(int regionNo) { this.regionNo = regionNo; }

	@Override
	public String toString() {
		return "User [no=" + no + ", nickname=" + nickname + ", profile=" + profile+ ", name=" + name + ", sex=" + sex
				+ ", regionNo=" + regionNo + "]";
	} //toString();
	
} //class User;
