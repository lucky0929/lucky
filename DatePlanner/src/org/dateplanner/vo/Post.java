package org.dateplanner.vo;

public class Post {
	
	private int no;
	private String main_image;
	private String title;
	private String content;
	private String packageable;
	
<<<<<<< HEAD
	public int getNo() { return no; }
	public String getMain_image() { return main_image; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public String getPackageable() { return packageable; }
	public void setNo(int no) { this.no = no; }
	public void setMain_image(String main_image) { this.main_image = main_image; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }
	public void setPackageable(String packageable) { this.packageable = packageable; }
=======
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
>>>>>>> branch 'master' of https://github.com/lucky0929/lucky.git
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Post [no=" + no + ", main_image=" + main_image + ", title=" + title + ", content=" + content
				+ ", packageable=" + packageable + "]";
=======
		return "Post [no=" + no + ", region_no=" + region_no + ", user_no=" + user_no + ", hit=" + hit + ", date="
				+ date + ", title=" + title + ", main_photo=" + main_photo + ", subject=" + subject + "]";
>>>>>>> branch 'master' of https://github.com/lucky0929/lucky.git
	} //toString();
	
} //class Post;
