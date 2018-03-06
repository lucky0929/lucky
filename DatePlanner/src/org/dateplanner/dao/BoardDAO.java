package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;

public interface BoardDAO {
	
	public boolean insertPost(Post post);
	public boolean insertPackage(Post post);
	public int checkPackageable(Package pack);
	public Post selectOne(int no);
	public List<Post> selectAll();
	public List<Post> selectPackageable(int no);
	public List<Post> selectMyPage(int no);
	
} //interface BoardDAO;
