package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.INmemberDao;
import model.NaverProfile;


@Service
public class NaverLoginService {

	@Autowired
	private INmemberDao dao;

	public String getNaverToken(String code, String state) throws Exception{
		JSONArray json = new JSONArray();
		String client_id = "tOzxSVFgBuq1ArjsmwsD"; //네이버꺼
		String client_secret = "PJRT5Ku1Yp";
		URL url =  new URL("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="+client_id+"&client_secret="+client_secret+"&code="+code);
		URLConnection urlConn = url.openConnection();

		HttpURLConnection hurlConn = (HttpURLConnection) urlConn;
		hurlConn.setRequestProperty("Content-Type", "application/x-www-form-unlencoded");	
		hurlConn.setRequestMethod("GET");

		urlConn.setRequestProperty("state", state);

		BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn.getInputStream(),"UTF-8"));
		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
		String token = (String) items.get("access_token");
		return token;
	}



	public HashMap<String, Object> getProfile(String token) throws Exception{
		JSONArray json = new JSONArray();
		String client_id = "tOzxSVFgBuq1ArjsmwsD"; //네이버꺼
		String client_secret = "PJRT5Ku1Yp";
		URL url =  new URL("https://openapi.naver.com/v1/nid/me");
		URLConnection urlConn = url.openConnection();

		HttpURLConnection hurlConn = (HttpURLConnection) urlConn;
		hurlConn.setRequestProperty("Content-Type", "application/x-www-form-unlencoded");	
		hurlConn.setRequestMethod("GET");
		hurlConn.setRequestProperty("Authorization", "Bearer " + token);

		BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn.getInputStream(),"UTF-8"));
		JSONObject items = (JSONObject) JSONValue.parseWithException(br);

		JSONObject item = (JSONObject) items.get("response");
		String id = (String)item.get("id");
		String name = (String) item.get("name");
		String email = (String)item.get("email");
		String nickName = (String)item.get("nickname");

		HashMap<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("name", name);
		params.put("email", email);
		params.put("nickName", nickName);

		return params;
	}


	public void naverLogin(HashMap<String, Object> params) {
		if(dao.selectOne((String)params.get("id"))==null) {
			dao.insertMember(params);
		}
	}

}
