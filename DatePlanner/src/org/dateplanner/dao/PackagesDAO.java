package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;

public interface PackagesDAO {
	
	public boolean insert(Package pack);
	public List<Post> selectOne(int no);
	
} //interface PackagesDAO;
