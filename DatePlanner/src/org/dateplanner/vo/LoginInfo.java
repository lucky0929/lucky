package org.dateplanner.vo;

public class LoginInfo {
	
	private int no;
	private String name, nickname;
	private int regionNo;
	private String profile;
	private Character sex;
	private String introduction;
	
	public int getNo() { return no; }
	public String getName() { return name; }
	public String getNickname() { return nickname; }
	public int getRegionNo() { return regionNo; }
	public String getProfile() { return profile; }
	public Character getSex() {  return sex;  }
	public String getIntroduction() { return introduction; }
	public void setNo(int no) { this.no = no; }
	public void setName(String name) { this.name = name; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setRegionNo(int regionNo) { this.regionNo = regionNo; }
	public void setProfile(String profile) { this.profile = profile; }
	public void setSex(Character sex) { this.sex = sex; }
	public void setIntroduction(String introduction) { this.introduction = introduction; }

	@Override
	public String toString() {
		return "LoginInfo [no=" + no + ", name=" + name + ", nickname=" + nickname + ", regionNo=" + regionNo
				+ ", profile=" + profile + ", sex=" + sex + ", introduction=" + introduction + "]";
	} //toString();
	
} //class LoginInfo;
