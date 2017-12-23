<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="login.do">
아이디 : <input type="text" name="userid"><br>
비번 : <input type="password" name="pwd"><br>
<input type="submit" value="로그인"><br>
<a href="joinForm.do">회원가입</a>
<a href = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=tOzxSVFgBuq1ArjsmwsD&state=STATE_STRING&redirect_uri=http://localhost/Board/naverLogin.do">네이버 로그인</a>

</form>

</body>
</html>