package org.dateplanner.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.dateplanner.commons.Region;

public class Post {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd kk:mm");
	
	private int no;
	private String title;
	private String content;
	private String image;
	private User user;
	private int regionNo;
	private Boolean packageable;
	private Timestamp regdate;
	private Double lat;
	private Double lng;
	private int like;

	
	public Post() {}
	public Post(int no) { this.no = no; }
	
	public int getNo() { return no; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public String getImage() { return image; }
	public User getUser() { return user; }
	public int getRegionNo() { return regionNo; }
	public String getRegion() { return Region.LIST.get(regionNo); }
	public Boolean getPackageable() { return packageable; }
	public Timestamp getRegdate() { return regdate; }
	public String getFormattedRegdate() { return DATE_FORMAT.format(regdate); }
	public Double getLat() { return lat; }
	public Double getLng() { return lng; }
	public int getLike() { return like; }
	public void setNo(int no) { this.no = no; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }
	public void setImage(String image) { this.image = image; }
	public void setUser(User user) { this.user = user; }
	public void setRegionNo(int regionNo) { this.regionNo = regionNo; }
	public void setPackageable(Boolean packageable) { this.packageable = packageable; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	public void setLat(Double lat) { this.lat = lat; }
	public void setLng(Double lng) { this.lng = lng; }
	public void setLike(int like) { this.like = like; }
	
	@Override
	public String toString() {
		return "Post [no=" + no + ", title=" + title + ", content=" + content + ", image=" + image + ", user=" + user
				+ ", regionNo=" + regionNo + ", packageable=" + packageable + ", regdate=" + regdate + ", lat=" + lat
				+ ", lng=" + lng + ", like=" + like + "]";
	}
	
} //class Post;
