//User
package org.dateplanner.vo;

import java.sql.Date;

public class User {

	private int no;
	private String name;
	private String key;
	private String nickname;
	private String sex;
	private String profile;
	private Integer regionNo;
	private String introduction;
	private Date regdate;
	
	public int getNo() { return no; }
	public String getName() { return name; }
	public String getKey() { return key; }
	public String getNickname() { return nickname; }
	public String getSex() { return sex; }
	public String getProfile() { return profile; }
	public Integer getRegionNo() { return regionNo; }
	public String getIntroduction() { return introduction; }
	public Date getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setName(String name) { this.name = name; }
	public void setKey(String key) { this.key = key; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setSex(String sex) { this.sex = sex; }
	public void setProfile(String profile) { this.profile = profile; }
	public void setRegionNo(Integer regionNo) { this.regionNo = regionNo; }
	public void setIntroduction(String introduction) { this.introduction = introduction; }
	public void setRegdate(Date regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", key=" + key + ", nickname=" + nickname + ", sex=" + sex
				+ ", profile=" + profile + ", regionNo=" + regionNo + ", introduction=" + introduction + ", regdate="
				+ regdate + "]";
	} //toString();
	
} //class User;
