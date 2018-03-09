package org.dateplanner.vo;

import java.util.List;

public class Package {
	
	private Post post;
	private List<Post> placeList;
	
	public Post getPost() { return post; }
	public List<Post> getPlaceList() { return placeList; }
	public void setPost(Post post) { this.post = post; }
	public void setPlaceList(List<Post> placeList) { this.placeList = placeList; }
	
	@Override
	public String toString() { return "Package [post=" + post + ", placeList=" + placeList + "]"; }
	
} //class Package;
