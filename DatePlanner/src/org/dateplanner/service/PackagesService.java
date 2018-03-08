package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.dao.PackagesDAO;
import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesService {
	
	@Autowired
	private PackagesDAO packagesDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<Post> selectPackageable(int no) { return boardDAO.selectPackageable(no); }
	
	public boolean createPackage(Package pack) {
		
		return boardDAO.checkPackageable(pack) == pack.getPlaceList().size() && boardDAO.insertPackage(pack.getPost()) && packagesDAO.insert(pack);
		
	} //createPackage();
	
} //class PackageService;
