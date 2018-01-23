<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>DatePlanner</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">DatePlanner</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
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
		@SuppressWarnings("unchecked")
		Map<String, Object> data = new ObjectMapper().readValue(hurlConn.getInputStream(), Map.class);
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
			@SuppressWarnings("unchecked")
			Map<String, Object> data2 = new ObjectMapper().readValue(hurlConn2.getInputStream(), Map.class);
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
				FB.api('/me', {fields : 'name, gender, birthday, id, age_range'}, function(response) {
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
		
		
		<%=request.getAttribute("id")%>
		
		<%URL fUrl = new URL("http://www.facebook.com/app_scoped_user_id/57516656282906");
			URLConnection urlConn3 = fUrl.openConnection();
			HttpURLConnection hurlConn3 = (HttpURLConnection) urlConn3;
			/* Map data3 = new ObjectMapper().readValue(hurlConn3.getInputStream(), Map.class); */
			BufferedReader br = new BufferedReader(new InputStreamReader(hurlConn3.getInputStream(), "UTF-8"));
			String data3 = "";
			String msg = null;
			while ((msg = br.readLine()) != null) {
				data3 += msg;
			}%>
		 
	</script>
	<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
	</fb:login-button>

	<div id="status"></div>
	<p id="result"></p>
	<br>
	<br>


	<div id="customBtn" class="customGPlusSignIn">
		<li><a href="#">구글로그인하자</a></li>
	</div>



	<!-- 구글 로그인================================================================================================ -->


	<script type="text/javascript">
  (function() {
    var po = document.createElement('script');
    po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/client:plusone.js?onload=render';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
  })();

  function render() { // 로그인 버튼 지정
    gapi.signin.render('customBtn', {
      'callback': 'signinCallback', // 버튼 클릭 시 실행할 function
      'clientid': '8b875df1fd17f39239f593145372cbcfc5fbf1bf',
      'cookiepolicy': 'single_host_origin',
      'requestvisibleactions': 'http://schemas.google.com/AddActivity',
      'scope': 'https://www.googleapis.com/auth/plus.login'
    });
  }
  
var google_access_token = "";
  function signinCallback(authResult) { // 지정한 버튼 클릭시
   if (authResult['access_token']) {
  google_access_token = authResult['access_token'];
     // 승인 성공
     var idToken = authResult['id_token']; 
   gapi.auth.setToken(authResult); // 반환된 토큰을 저장합니다.
   getEmail(); // 토큰저장했으니 프로필 정보 가지러 ㄱㄱ

     
   
     document.getElementById('customBtn').setAttribute('style', 'display: none'); // 사용자가 승인되었으므로 로그인 버튼을 숨김
     
   } else if (authResult['error']) {
     // 오류가 발생했습니다.
     // 가능한 오류 코드:
     //   "access_denied" - 사용자가 앱에 대한 액세스 거부
     //   "immediate_failed" - 사용자가 자동으로 로그인할 수 없음
     /*  alert('오류 발생: ' + authResult['error']); */
   }
  }

 


  function getEmail(){
   // userinfo 메소드를 사용할 수 있도록 oauth2 라이브러리를 로드합니다.
  gapi.client.load('oauth2', 'v2', function() {
   var request = gapi.client.oauth2.userinfo.get();
   request.execute(getEmailCallback);
  });
  }

  function getEmailCallback(obj){
  if(sns_comment_type == "GOOGLE" || sns_comment_type == ""){ // 여러가지 sns를 구별하기 위해 사용하였으며, 다른 홈페이지에서 구글이 로그인 되있을경우 자동 로그인되는 것을 방지하기 위함.
    goname = obj['name']; // 프로필 정보는  넘겨받은 obj값들중  선택하여 뽑아내면 됨.
    var linkUrl = obj['link'];
    var pictureUrl = obj['picture'];
    var image = document.getElementById('facebookimage');
    image.src = pictureUrl;
    var name = document.getElementById('googlename');
    name.innerHTML = obj['name'];
    var id = document.getElementById('googleid');
    id.innerHTML = obj['id'];
    // 밑에는 session생성을 위해..
    $.post("/oAuthASPExample/comment_session_process_g.asp", { "userid": obj['id'], "email":obj['email'], "username": goname, "goaccesstoken":google_access_token, "picture":pictureUrl, "link":obj['link']},  
     function (responseasp) {  
      if(responseasp=="N"){
       alert("로그인 세션 실패");
       //location.replace('/unmember/memberrege?flag=1');            
      }else{ 
       getCommentList("");
       //location.replace('/');
      }
     });

    document.getElementById('sign_in_container').style.display = "none";
    document.getElementById('sign_out_container').style.display = "";
    document.getElementById('google_submit').style.display = "";
    document.getElementById('snslogininfoG').style.display = "";
    document.getElementById('snsTopImg').src = '/_common/img/ico_reply03.jpg';
    document.getElementById('snsTopImg').alt = 'google';
   }else{
    return;
   }
 } 

  /* 구글 로그아웃 */
  function disconnectUser() {
   var revokeUrl = 'https://accounts.google.com/o/oauth2/revoke?token=' + google_access_token; // 로그아웃을 위해서는 저URL에 그냥 토큰값만 추가해서 날려주면된다.
  $.post("/oAuthASPExample/naver_out.asp", {},  function (responseasp) {  // 내가 생성했던 SESSION을 제거하기 위함..
   if(responseasp!="Y"){
    alert("Error");
    //location.replace('/unmember/memberrege?flag=1');            
   }else{
      // 비동기 GET 요청을 수행합니다.
      $.ajax({
      type: 'GET',
      url: revokeUrl,
      async: false,
      contentType: "application/json",
      dataType: 'jsonp',
      success: function(nullResponse) { 
      // 성공
      },
      error: function(e) {
      // 오류 처리
      // console.log(e);
      // 실패한 경우 사용자가 수동으로 연결 해제하게 할 수 있습니다.
      // https://plus.google.com/apps
      }
      });
     <%-- location.href = '<%=%>'; // 로그아웃 한 페이지로 이동 --%>
   }
  });
}
  </script>
	<!-- 구글 끝 -->
</body>
</html>