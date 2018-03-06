package org.dateplanner.vo;

import java.sql.Timestamp;

public class User {
	
	private int no;
	private String id;
	private String name;
	private String key;
	private Character platform;
	private String nickname;
	private Character sex;
	private String profile;
	private Integer regionNo;
	private String introduction;
	private Timestamp regdate;

	public User() {}
	public User(int no) { this.no = no; }
	
	public int getNo() { return no; }
	public String getId() { return id; }
	public String getName() { return name; }
	public String getKey() { return key; }
	public Character getPlatform() { return platform; }
	public String getNickname() { return nickname; }
	public Character getSex() { return sex; }
	public String getProfile() { return profile; }
	public Integer getRegionNo() { return regionNo; }
	public String getIntroduction() { return introduction; }
	public Timestamp getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setKey(String key) { this.key = key; }
	public void setPlatform(Character platform) { this.platform = platform; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setSex(Character sex) { this.sex = sex; }
	public void setProfile(String profile) { this.profile = profile; }
	public void setRegionNo(Integer regionNo) { this.regionNo = regionNo; }
	public void setIntroduction(String introduction) { this.introduction = introduction; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", name=" + name + ", key=" + key + ", platform=" + platform
				+ ", nickname=" + nickname + ", sex=" + sex + ", profile=" + profile + ", regionNo=" + regionNo
				+ ", introduction=" + introduction + ", regdate=" + regdate + "]";
	} //toString();
	
} //class User;
