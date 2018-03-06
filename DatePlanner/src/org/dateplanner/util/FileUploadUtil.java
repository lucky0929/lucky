package org.dateplanner.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	
	private static String uploadFile(MultipartFile file, String uploadPath) throws IOException {
		
		String originalFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf('.'));
		
		file.transferTo(new File(uploadPath + fileName));
		
		return fileName;
		
	} //uploadFile();
	
	public static String getFile(MultipartHttpServletRequest request, String uploadPath) {
		
		String result = null;
		uploadPath = request.getServletContext().getRealPath(uploadPath);
		
		Iterator<String> fileNames = request.getFileNames();
		if(fileNames.hasNext()) {
			
			try { result = uploadFile(request.getFile(fileNames.next()), uploadPath); }
			catch (IOException e) { e.printStackTrace(); }
			
		}
		
		return result;
		
	} //getFile();
	
	public static List<String> getFileList(MultipartHttpServletRequest request, String uploadPath) {
		
		List<String> result = new ArrayList<>();
		uploadPath = request.getServletContext().getRealPath(uploadPath);
		
		Iterator<String> fileNames = request.getFileNames();
		while(fileNames.hasNext()) {
			
			try { result.add(uploadFile(request.getFile(fileNames.next()), uploadPath)); }
			catch (IOException e) { e.printStackTrace(); }
			
		}
		
		return result;
		
	} //getFileList();
	
} //class FileUploadUtil;
