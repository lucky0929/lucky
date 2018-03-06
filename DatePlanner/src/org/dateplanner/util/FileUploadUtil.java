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
	
	public static String getFile(MultipartHttpServletRequest request, String uploadPath) {
		
		String result = null;
		
		Iterator<String> fileNames = request.getFileNames();
		if(fileNames.hasNext()) {
			
			try {
				
				MultipartFile file = request.getFile(fileNames.next());
				String originalFileName = file.getOriginalFilename();
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf('.'));
				
				file.transferTo(new File(request.getServletContext().getRealPath(uploadPath) + fileName));
				result = fileName;
				
			}catch (IOException e) { e.printStackTrace(); }
			
		}
		
		return result;
		
	}
	
	public static List<String> getFileList(MultipartHttpServletRequest request, String uploadPath) {
		
		List<String> result = new ArrayList<>();
		
		Iterator<String> fileNames = request.getFileNames();
		while(fileNames.hasNext()) {
			
			try {
				
				MultipartFile file = request.getFile(fileNames.next());
				String originalFileName = file.getOriginalFilename();
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf('.'));
				
				file.transferTo(new File(request.getServletContext().getRealPath(uploadPath) + fileName));
				result.add(fileName);
				
			}catch (IOException e) { e.printStackTrace(); }
			
		}
		
		return result;
		
	} //getFileList();
	
} //class FileUploadUtil;
