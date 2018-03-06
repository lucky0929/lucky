package org.dateplanner.util;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	public static ResponseEntity<String> convertToResponseEntity(Object obj) throws IOException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(obj), headers, HttpStatus.OK);
		
	} //getResponseEntity();
	
} //class JsonUtil;
