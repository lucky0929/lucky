package org.dateplanner.vo;

public class Post {
	
	private int no;
	private String main_image;
	private String title;
	private String content;
	private String packageable;
	
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getMain_image() { return main_image; }
	public void setMain_image(String main_image) { this.main_image = main_image; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getPackageable() { return packageable; }
	public void setPackageable(String packageable) { this.packageable = packageable; }

	@Override
	public String toString() {
		return "Post [no=" + no + ", main_image=" + main_image + ", title=" + title + ", content=" + content
				+ ", packageable=" + packageable + "]";
	}
		
} //class Post;
