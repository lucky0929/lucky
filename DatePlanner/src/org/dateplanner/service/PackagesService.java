package org.dateplanner.service;

import org.dateplanner.dao.PackagesDAO;
import org.dateplanner.vo.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesService {
	
	@Autowired
	private PackagesDAO packagesDAO;
	
	public boolean createPackage(Package pack) {
		
		return packagesDAO.checkPackageable(pack) == pack.getPlaceList().size() && packagesDAO.insertPost(pack.getPackagePost()) && packagesDAO.insert(pack);
		
	} //createPackage();
	
} //class PackageService;
