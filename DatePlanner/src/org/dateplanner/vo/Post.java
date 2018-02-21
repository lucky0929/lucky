package org.dateplanner.vo;

import java.sql.Timestamp;

public class Post {
	
	private int no;
	private String mainImage;
	private String title;
	private String content;
	private int userNo;
	private int regionNo;
	private Boolean packageable;
	private Timestamp regdate;
	
	public int getNo() { return no; }
	public String getMainImage() { return mainImage; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public int getUserNo() { return userNo; }
	public int getRegionNo() { return regionNo; }
	public Boolean getPackageable() { return packageable; }
	public Timestamp getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setMainImage(String mainImage) { this.mainImage = mainImage; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }
	public void setUserNo(int userNo) { this.userNo = userNo; }
	public void setRegionNo(int regionNo) { this.regionNo = regionNo; }
	public void setPackageable(Boolean packageable) { this.packageable = packageable; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "Post [no=" + no + ", mainImage=" + mainImage + ", title=" + title + ", content=" + content + ", userNo="
				+ userNo + ", regionNo=" + regionNo + ", packageable=" + packageable + ", regdate=" + regdate + "]";
	} //toString();
	
} //class Post;
