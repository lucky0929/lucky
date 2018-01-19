package org.dateplanner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class PestivalAPI {

	public String pestival() throws Exception{
		String key = "fQIV1vtfTcjoPuYTj6iioalj%2FQCqmeut2Yt2aUfN1WCO203BmKFdrp6tOBGMxf8ihq8P65M6mtCIxJUjxxyCNw%3D%3D";
		String areaCode = "1";
		URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey="+key+"&MobileOS=ETC&MobileApp=AppTest&_type=json&areaCode="+areaCode);
		URLConnection urlConn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
//		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
		Map data = new ObjectMapper().readValue(urlConn.getInputStream(), Map.class);
		System.out.println(data);
		
		return "hi";
	}
}
