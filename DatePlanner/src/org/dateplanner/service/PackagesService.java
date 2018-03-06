package org.dateplanner.service;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.dao.PackagesDAO;
import org.dateplanner.vo.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesService {
	
	@Autowired
	private PackagesDAO packagesDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean createPackage(Package pack) {
		
		return boardDAO.checkPackageable(pack) == pack.getPlaceList().size() && boardDAO.insertPost(pack.getPackagePost()) && packagesDAO.insert(pack);
		
	} //createPackage();
	
} //class PackageService;
