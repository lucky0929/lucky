package org.dateplanner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class test {
   Connection connection=null;
   Statement statement=null;
   ResultSet resultSet=null;

   String driverName = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://sunx.cafe24.com:3306/sunx";
   String user = "sunx";
   String password = "comnet12";

   public test() {
      try {
         Class.forName(driverName);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void closeDatabase() {
      try {
         if (connection != null) {
            connection.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (resultSet != null) {
            resultSet.close();
         }
      } catch (SQLException e) {
         System.out.println("[닫기 오류]\n" + e.getStackTrace());
      }
   }

   public int productInsert(int a) throws Exception{
      int resultValue = 0;
      try {
    	  JSONArray json = new JSONArray();
  		String key = "fQIV1vtfTcjoPuYTj6iioalj%2FQCqmeut2Yt2aUfN1WCO203BmKFdrp6tOBGMxf8ihq8P65M6mtCIxJUjxxyCNw%3D%3D";
  		URL url2 = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey="+key+"&MobileOS=ETC&MobileApp=AppTest&_type=json&totalCount=&numOfRows=1782");
  		URLConnection urlConn = url2.openConnection();
  				BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
  		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
  		items = (JSONObject) items.get("response");
  		items = (JSONObject) items.get("body");
  		items = (JSONObject) items.get("items");
  		JSONArray data = (JSONArray)items.get("item");
  		for (int i = 0; i < items.size(); i++) {
  			items = (JSONObject) data.get(i);
  			long contentId = (long) items.get("contentid");
  			URL url3 = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey="+key+""
  					+ "&MobileOS=ETC&MobileApp=AppTest&contentId="+contentId+"&_type=json&defaultYN=Y"
  					+ "&firstImageYN=Y&areaCodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y");
  			URLConnection urlConn3 = url3.openConnection();
  			BufferedReader br2 = new BufferedReader(new InputStreamReader(urlConn3.getInputStream(),"UTF-8"));
  			JSONObject detail = (JSONObject) JSONValue.parseWithException(br2);
  			detail = (JSONObject) detail.get("response");
  			detail = (JSONObject) detail.get("body");
  			detail = (JSONObject) detail.get("items");
  			detail = (JSONObject) detail.get("item");
  			String homepage = (String)detail.get("homepage");
  			String title = (String)detail.get("title");
//  			long area = (long)detail.get("areacode");
  			String addr1 = (String)detail.get("addr1");
  			String addr2 = (String)detail.get("addr2");
  			String overview = (String)detail.get("overview");
  			String firstImage = (String)detail.get("firstimage");
  			String firstImage2 = (String)detail.get("firstimage2");
  			long eventstartdate = (long)items.get("eventstartdate");
  			long eventenddate = (long)items.get("eventenddate");
//  			String item = "homepage : "+homepage+" title : "+title+" addr : "+addr1+addr2+" overview : "+overview+" firstimage = "+firstImage+" firstimage2 : "+firstImage2+" eventstartdate : "+eventstartdate+" eventenddate : "+ eventenddate;
  			String dbData = "'"+title+"','"+homepage+"','"+firstImage+"','"+firstImage2+"','"+overview+"',"+eventstartdate+","+eventenddate+",'"+addr1+"','"+addr2+"'";
//  			homepage = dbData.substring(dbData.indexOf("=")+2, dbData.indexOf("target")-2);
  			dbData = "'"+title+"','"+homepage+"','"+firstImage+"','"+firstImage2+"','"+overview+"',"+eventstartdate+","+eventenddate+",'"+addr1+"','"+addr2+"'";
  			System.out.println(contentId);
//         String queryString = "INSERT INTO festival(title) VALUES('o')";
//         connection = DriverManager.getConnection(url, user, password);
//         statement = connection.createStatement();
//         resultValue = statement.executeUpdate(queryString);
  		}
      } catch (Exception e) {
         System.out.println("[쿼리 오류]\n" + e.getStackTrace());
         e.printStackTrace();
      } finally {
         closeDatabase();
      }
      return resultValue;
   }

   public static void main(String[] args) {
      test texst = new test();
      try {
		texst.productInsert(2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}