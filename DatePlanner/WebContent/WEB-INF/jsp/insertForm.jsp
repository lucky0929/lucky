<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="place/doWrite">
지역<input type="text" name="region_no" /><br>
제목<input type="text" name="title" /><br>
유저<input type="text" name="user_no" /><br>
사진<input type="text" name="main_photo" /><br>
<input type="text" name="subject" value="c"/><br>
<input type="text" name="hit" value="0"/><br>
<input type="submit" value="submit"/> 
</form>
</body>
</html>