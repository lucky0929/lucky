package org.dateplanner.vo;

import java.util.List;

public class Package {
	
	private Post packagePost;
	private List<Post> placeList;
	
	public Post getPackagePost() { return packagePost; }
	public List<Post> getPlaceList() { return placeList; }
	public void setPackagePost(Post packagePost) { this.packagePost = packagePost; }
	public void setPlaceList(List<Post> placeList) { this.placeList = placeList; }
	
	@Override
	public String toString() { return "Package [packagePost=" + packagePost + ", placeList=" + placeList + "]"; }
	
} //class Package
