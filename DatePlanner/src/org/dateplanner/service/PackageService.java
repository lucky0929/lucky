package org.dateplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.dao.PackagesDAO;
import org.dateplanner.vo.Package;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {
	
	@Autowired
	private PackagesDAO packagesDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean createPackage(Package pack) {
		
		return boardDAO.checkPackageable(pack) == pack.getPlaceList().size() && boardDAO.insertPackage(pack.getPost()) && packagesDAO.insert(pack);
		
	} //createPackage();
	
	public Package selectPackage(int no) {
		
		Package pack = new Package();
		
		List<Post> postList = packagesDAO.selectOne(no);
		List<Post> placeList = new ArrayList<>();
		
		for(Post post : postList) {
			
			if(post.getNo() == no) pack.setPost(post);
			else placeList.add(post);
			
		}
		
		pack.setPlaceList(placeList);
		
		System.out.println(pack);
		
		return pack;
		
	} //selectPackage();
	
	public List<Post> selectPackageable(int no) { return boardDAO.selectPackageable(no); }
	
} //class PackageService;
