package org.dateplanner.vo;

import java.sql.Date;

public class User {
	
	private Integer no;
	private String name;
	private String nickname;
	private Integer regionNo;
	private String profile;
	private String sex;
	private String introduction;
	private Date logchecktime;
	
	public Integer getNo() { return no; }
	public String getName() { return name; }
	public String getNickname() { return nickname; }
	public Integer getRegionNo() { return regionNo; }
	public String getProfile() { return profile; }
	public String getSex() { return sex; }
	public String getIntroduction() { return introduction; }
	public Date getLogchecktime() { return logchecktime; }
	public void setNo(Integer no) { this.no = no; }
	public void setName(String name) { this.name = name; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setRegionNo(Integer regionNo) { this.regionNo = regionNo; }
	public void setProfile(String profile) { this.profile = profile; }
	public void setSex(String sex) { this.sex = sex; }
	public void setIntroduction(String introduction) { this.introduction = introduction; }
	public void setLogchecktime(Date logchecktime) { this.logchecktime = logchecktime; }

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", nickname=" + nickname + ", regionNo=" + regionNo + ", profile="
				+ profile + ", sex=" + sex + ", introduction=" + introduction + ", logchecktime=" + logchecktime + "]";
	} //toString();
	
} //class User;