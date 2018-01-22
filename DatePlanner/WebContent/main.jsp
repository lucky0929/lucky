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
						<span class="glyphicon glyphicon-log-in"></span> 로그인
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

<script src="jquery.js"></script>
	<script>
		// This is called with the results from from FB.getLoginStatus(). 
		function statusChangeCallback(response) {
			console.log('statusChangeCallback');
			console.log(response);
			// response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
			// 앱에서 현재의 로그인 상태에 따라 동작하면 된다. 
			// FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다. 
			if (response.status === 'connected') {
				// 페이스북을 통해서 로그인이 되어있다. 
				testAPI();
			} else if (response.status === 'not_authorized') {
				// 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다. 
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into this app.';
			} else {
				// 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into Facebook.';
			}
		}
		// 이 함수는 누군가가 로그인 버튼에 대한 처리가 끝났을 때 호출된다. 
		// onlogin 핸들러를 아래와 같이 첨부하면 된다. 
		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}
		window.fbAsyncInit = function() {
			FB.init({
				appId : '2032128690391759',
				cookie : true, // 쿠키가 세션을 참조할 수 있도록 허용
				xfbml : true, // 소셜 플러그인이 있으면 처리 
				version : 'v2.1' // 버전 2.1 사용 
			});
			// 자바스크립트 SDK를 초기화 했으니, FB.getLoginStatus()를 호출한다. 
			//.이 함수는 이 페이지의 사용자가 현재 로그인 되어있는 상태 3가지 중 하나를 콜백에 리턴한다. 
			// 그 3가지 상태는 아래와 같다. 
			// 1. 앱과 페이스북에 로그인 되어있다. ('connected') 
			// 2. 페이스북에 로그인되어있으나, 앱에는 로그인이 되어있지 않다. ('not_authorized') 
			// 3. 페이스북에 로그인이 되어있지 않아서 앱에 로그인이 되었는지 불확실하다. 
			// 
			// 위에서 구현한 콜백 함수는 이 3가지를 다루도록 되어있다. 
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		};
		// SDK를 비동기적으로 호출 
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		// 로그인이 성공한 다음에는 간단한 그래프API를 호출한다. 
		// 이 호출은 statusChangeCallback()에서 이루어진다. 
		function testAPI() {
			FB.login(function(response){
				var fbname;
				var accessToken = response.authResponse.accessToken;
				FB.api('/me?fileds=id,name,age_range,gender', function(response) {
					var fb_data = jQuery.parseJSON(JSON.stringify(response));
					console.log(fb_data);
					var data = "<br/>fb_id " + fb_data.id;
					data += "<br/>name " + fb_data.name;
					data += "<br/>age " + fb_data.age_range;
					data += "<br/>gender " + fb_data.gender;
					console.log(fb_data);
					
					$("#result").append(data);
					
					/* document.getElementById('status').innerHTML = '반가워용, '
							+ response.name + '!'; */
				});
			});
		}
		
		
		<%=request.getAttribute("id") %>
		
		<% 
		URL fUrl = new URL("http://www.facebook.com/app_scoped_user_id/57516656282906");
		URLConnection urlConn3 = fUrl.openConnection();
		HttpURLConnection hurlConn3 = (HttpURLConnection) urlConn3;
		/* Map data3 = new ObjectMapper().readValue(hurlConn3.getInputStream(), Map.class); */
		BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn3.getInputStream(), "UTF-8"));
		String data3 = "";
		String msg = null;
		while ((msg = br.readLine()) != null) {
			data3 += msg;
		}
		%>
		 
	</script>
	<fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();">
	</fb:login-button>

	<div id="status"></div>
	<p id = "result"></p>


</body>
</html>