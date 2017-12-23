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
		<h1>게시글 수정 페이지</h1>
		<form action="update.do">
			<input type="hidden" name="num" value="${detail.num }"> 작성자 :
			<input type="text" name="name" value="${detail.name }"
				disabled="disabled" /> <br> 제목 : <input type="text"
				name="title" value="${detail.title }" /><br> 내용 :
			<textarea rows="10" cols="50" name="content">${detail.content }</textarea>
			<br> <input type="submit" value="수정하기">
		</form>
	</center>
</body>
</html>