package org.dateplanner.api;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FestivalAPI {
	
	@SuppressWarnings("unchecked")
	public void test() {
		
		try {
			
			String key = "fQIV1vtfTcjoPuYTj6iioalj%2FQCqmeut2Yt2aUfN1WCO203BmKFdrp6tOBGMxf8ihq8P65M6mtCIxJUjxxyCNw%3D%3D";
			// key = URLEncoder.encode(key,"UTF-8");
			// String areaCode = "";
			// String contentId = "2509701";
			URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey="
					+ key + "&MobileOS=ETC&MobileApp=AppTest&_type=json");
			// URL url = new
			// URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey="+key+""
			// +
			// "&MobileOS=ETC&MobileApp=AppTest&contentId="+contentId+"&_type=json&defaultYN=Y"
			// + "&firstImageYN=Y&areaCodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y");
			
			Map<String, Object> result = new ObjectMapper().readValue(url, Map.class);
			// System.out.println(new
			// ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result));
			
			for (Map<String, Object> obj : (List<Map<String, Object>>)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)
					result.get("response")).get("body")).get("items")).get("item")) {
				System.out.println(obj.get("eventstartdate"));
			}
			
		}catch (IOException e) { e.printStackTrace(); }

	} //test();

} //class FestivalAPI;
