package org.dateplanner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.databind.ObjectMapper;


public class FestivalAPI {

	public void festival() throws Exception{
		JSONArray json = new JSONArray();
		String key = "fQIV1vtfTcjoPuYTj6iioalj%2FQCqmeut2Yt2aUfN1WCO203BmKFdrp6tOBGMxf8ihq8P65M6mtCIxJUjxxyCNw%3D%3D";
//		key = URLEncoder.encode(key,"UTF-8");
		String areaCode = "";
		String contentId = "2509701";
		URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey="+key+"&MobileOS=ETC&MobileApp=AppTest&_type=json");
//		URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey="+key+""
//				+ "&MobileOS=ETC&MobileApp=AppTest&contentId="+contentId+"&_type=json&defaultYN=Y"
//						+ "&firstImageYN=Y&areaCodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y");
		URLConnection urlConn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
//		items = (JSONObject) items.get("response");
//		items = (JSONObject) items.get("body");
//		items = (JSONObject) items.get("items");
//		items = (JSONObject) items.get("item");
//		String homepage = (String)items.get("homepage");
//		String tel = (String)items.get("tel");
//		String title = (String)items.get("title");
//		String area = (String)items.get("areacode");
//		String addr1 = (String)items.get("addr1");
//		String addr2 = (String)items.get("addr2");
//		String overview = (String)items.get("overview");
//		double lat = (double)items.get("mapx");
//		String lon = (String)items.get("mapy");
//		String item = "homepage : "+homepage+" tel : "+tel+" area : "+area+" addr : "+addr1+addr2+" overview : "+overview+" latlon = "+lat+", "+lon;
//		System.out.println(item);
		System.out.println(items);
		//안올라가니?
	}
}
