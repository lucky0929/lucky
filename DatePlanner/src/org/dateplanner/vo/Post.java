package org.dateplanner.vo;

import java.util.Date;

public class Post {
	
	private int no;
	private int region_no;
	private int user_no;
	private int hit;
	private Date date;
	private String title;
	private String main_photo;
	private char subject;
	
	public int getNo() {return no;}
	public int getRegion_no() {return region_no;}
	public int getUser_no() {return user_no;}
	public int getHit() {return hit;}
	public Date getDate() {return date;}
	public String getTitle() {return title;}
	public String getMain_photo() {return main_photo;}
	public char getSubject() {return subject;}
	public void setNo(int no) {this.no = no;}
	public void setRegion_no(int region_no) {this.region_no = region_no;}
	public void setUser_no(int user_no) {this.user_no = user_no;}
	public void setHit(int hit) {this.hit = hit;}
	public void setDate(Date date) {this.date = date;}
	public void setTitle(String title) {this.title = title;}
	public void setMain_photo(String main_photo) {this.main_photo = main_photo;}
	public void setSubject(char subject) {this.subject = subject;}
	
	@Override
	public String toString() {
		return "Post [no=" + no + ", region_no=" + region_no + ", user_no=" + user_no + ", hit=" + hit + ", date="
				+ date + ", title=" + title + ", main_photo=" + main_photo + ", subject=" + subject + "]";
	} //toString();
	
} //class Post;
