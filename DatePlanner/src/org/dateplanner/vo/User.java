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
	    
		public Integer getNo() {
			return no;
		}
		public void setNo(Integer no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Integer getRegionNo() {
			return regionNo;
		}
		public void setRegionNo(Integer regionNo) {
			this.regionNo = regionNo;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		public Date getLogchecktime() {
			return logchecktime;
		}
		public void setLogchecktime(Date logchecktime) {
			this.logchecktime = logchecktime;
		}
		@Override
		public String toString() {
			return "User [no=" + no + ", name=" + name + ", nickname=" + nickname + ", regionNo=" + regionNo
					+ ", profile=" + profile + ", sex=" + sex + ", introduction=" + introduction + ", logchecktime="
					+ logchecktime + "]"; }
} //User