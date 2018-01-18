<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>DatePlanner</title>
</head>
<body>
	<h1>안녕</h1>
	<a
		href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=tOzxSVFgBuq1ArjsmwsD&state=STATE_STRING&redirect_uri=http://localhost/main.jsp">네이버
		로그인</a>
	<%
		String code = request.getParameter("code");
		URL url = new URL(
				"https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=tOzxSVFgBuq1ArjsmwsD&client_secret=PJRT5Ku1Yp&code="
						+ code);
		URLConnection urlConn = url.openConnection();
		HttpURLConnection hurlConn = (HttpURLConnection) urlConn;
		hurlConn.setRequestProperty("Content-Type", "application/x-www-form-unlencoded");
		/*BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn.getInputStream(), "UTF-8"));
		String data = "";
		String msg = null;
		while ((msg = br.readLine()) != null) {
			data += msg;
		}*/
		Map data = new ObjectMapper().readValue(hurlConn.getInputStream(), Map.class);
/* ㅎㅇ */
		/*String token = (String) items.get("access_token"); */
	%><%-- <%=data%><br> --%>
	<%
	if(data.get("error") == null) {
		String token = (String)data.get("access_token"); 
		URL url2 =  new URL("https://openapi.naver.com/v1/nid/me");
		URLConnection urlConn2 = url2.openConnection();
		HttpURLConnection hurlConn2 = (HttpURLConnection) urlConn2;
		hurlConn2.setRequestProperty("Content-Type", "application/x-www-form-unlencoded");	
		hurlConn2.setRequestMethod("GET");
		hurlConn2.setRequestProperty("Authorization", "Bearer " + token);
		Map data2 = new ObjectMapper().readValue(hurlConn2.getInputStream(), Map.class);
		%><%=data2.get("response")%><%
	}
	%>
</body>
</html>