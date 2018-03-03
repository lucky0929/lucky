package org.dateplanner.vo;

import java.sql.Timestamp;

public class ResultPost {
	
	private int no;
	private String image;
	private String title;
	private String content;
	private String userName;
	private int regionNo;
	private Boolean packageable;
	private Timestamp regdate;
	private Double lat;
	private Double lng;
	
	public int getNo() { return no; }
	public String getImage() { return image; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public String getUserName() { return userName; }
	public int getRegionNo() { return regionNo; }
	public Boolean getPackageable() { return packageable; }
	public Timestamp getRegdate() { return regdate; }
	public Double getLat() { return lat; }
	public Double getLng() { return lng; }
	public void setNo(int no) { this.no = no; }
	public void setImage(String image) { this.image = image; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }
	public void setUserName(String userName) { this.userName = userName; }
	public void setRegionNo(int regionNo) { this.regionNo = regionNo; }
	public void setPackageable(Boolean packageable) { this.packageable = packageable; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	public void setLat(Double lat) { this.lat = lat; }
	public void setLng(Double lng) { this.lng = lng; }
	
	@Override
	public String toString() {
		return "Post [no=" + no + ", image=" + image + ", title=" + title + ", content=" + content + ", userNo="
				+ userName + ", regionNo=" + regionNo + ", packageable=" + packageable + ", regdate=" + regdate + "]";
	} //toString();
	
} //class Post;