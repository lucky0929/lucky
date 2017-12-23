<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form action="join.do">
이름 : <input type="text" name="name"><br>
아이디 : <input type="text" name="userid"><br>
비번 : <input type="password" name="pwd"><br>
비번확인 : <input type="password" name="pwd_CHECK"><br>
이메일 : <input type="text" name="email"><br>
<input type="submit" value="가입하기">
</form>
</body>
</html>