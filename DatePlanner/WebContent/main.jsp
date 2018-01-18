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
		BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn.getInputStream(), "UTF-8"));
		String data = "";
		String msg = null;
		while ((msg = br.readLine()) != null) {
			data += msg;
		}

		/*String token = (String) items.get("access_token"); */
	%>
	<%=data %>
</body>
</html>