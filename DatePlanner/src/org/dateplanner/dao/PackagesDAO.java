package org.dateplanner.dao;

import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;

public interface PackagesDAO {

	public boolean insertPost(Post post);
	public boolean insert(Package pack);
	public int checkPackageable(Package pack);
	
} //interface PackagesDAO;
