<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URLConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
.inputBox {
	width: 250px;
	height: 40px;
	margin-bottom: 4px;
	width: 250px;
}

#loginBtn {
	color: white;
	font-weight: bold;
	border: black;
	background: black;
}

#login {
	margin-top: 80px;
	text-align: center;
}

.apiLogin {
	margin-bottom: 4px;
}

.fab {
	position: relative;
	font-size: 5em;
}

.icon {
	padding-top: 10px;
	padding-right: 5px;
}

img {
	border-radius: 3px;
}

.icon>a {
	width: 30px;
	height: 30px;
}
p{
text-align: center;
}
</style>
</head>
<body>
<!-- ====================================================================상단 바=========================== -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main.jsp">DatePlanner</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					회원가입</a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				href="http://localhost/NaverBookSearchAPI/jsp/login.jsp"> 로그인 </a>
			<li class="icon"><img src="img/naver.png" alt="네이버" width="30px"
				height="30px" />
			<li />

			<li class="icon">
				<p>
					<a
						href="https://www.facebook.com/v2.11/dialog/oauth?client_id=2032128690391759&redirect_uri=http://localhost/NaverBookSearchAPI/facebook.do&state=lucky">
						<img src="img/facebook1.png" alt="페이스북" width="30px" height="30px"/>
					</a>
				</p>
			<li />
			<li class="icon"><img src="img/Google.png" alt="구글" width="30px"
				height="30px" />
			<li />
			
			<li class="icon"><img src="img/kakao.jpg" alt="카카오톡" width="30px"
				height="30px" />
			<li />
		</ul>

	</div>
	</nav>
	
	<!-- ===================================상단 바============================================= -->

	<div id="login">
		<form action="loginAction.do">
			<div>
				<input class="inputBox" type="text" name="id"
					placeholder=" ID를 입력해주세요."><br> <input
					class="inputBox" type="password" name="pw"
					placeholder=" PW를 입력해주세요."><br> <input
					class="inputBox" id="loginBtn" type="submit" value="로그인하기">
			</div>
		</form>
		<hr>
		<div id="apiLogin">
			<div class="apiLogin" id="naver">
				<a href=""><img src="img/네이버.png" alt="네이버" width="250"
					height="40" /></a>
			</div>

			<div class="apiLogin" id="facebook">
				<a
					href="https://www.facebook.com/v2.11/dialog/oauth?client_id=2032128690391759&redirect_uri=http://localhost/NaverBookSearchAPI/facebook.do&state=lucky"><img
					src="img/페이스북.png" alt="페이스북" width="250" height="40" /></a>
			</div>
		</div>
	</div>
</body>
</html>