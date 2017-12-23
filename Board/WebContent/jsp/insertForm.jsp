<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>게시글 입력 페이지</h1>
		<form action="insert.do" id="frm" name="frm" enctype="multipart/form-data" method="POST">
		<input type="hidden" name="readCount" value="0">
			제목 : <input type="text" name="title" /><br> 
			이름 : <input
				type="text" name="name" value="${userInfo.name }"
				readonly="readonly" /><br> 
				 내용 : <textarea rows="10" cols="50" name="content"></textarea><br>
				 <input type="file" name="file"><br><br>
				  <input type="submit" value="등록하기">
		</form>
	</center>
</body>
</html>