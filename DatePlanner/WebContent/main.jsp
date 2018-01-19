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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>DatePlanner</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">DatePlanner</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a
					href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=tOzxSVFgBuq1ArjsmwsD&state=STATE_STRING&redirect_uri=http://localhost/main.jsp">
						<span class="glyphicon glyphicon-log-in"></span> Login
				</a></li>
			</ul>
		</div>
	</nav>
	<h1>안녕</h1>
	<!--gdgd  -->
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
		if (data.get("error") == null) {
			String token = (String) data.get("access_token");
			URL url2 = new URL("https://openapi.naver.com/v1/nid/me");
			URLConnection urlConn2 = url2.openConnection();
			HttpURLConnection hurlConn2 = (HttpURLConnection) urlConn2;
			hurlConn2.setRequestProperty("Content-Type", "application/x-www-form-unlencoded");
			hurlConn2.setRequestMethod("GET");
			hurlConn2.setRequestProperty("Authorization", "Bearer " + token);
			Map data2 = new ObjectMapper().readValue(hurlConn2.getInputStream(), Map.class);
	%><%=data2.get("response")%>
	<%
		}
	%>
	
	
	
	
	
</body>
</html>