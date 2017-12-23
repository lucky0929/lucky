<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateComment.do">
	<input type="hidden" name="num" value="${comment.num }">
		<table border="1">
			<tr>
				<th>닉네임</th>
				<th>내 용</th>
				<th>ㅎㅎ</th>
			</tr>
		<input type="hidden" name="commentNum" value="${comment.commentNum }">
			<tr>
				<td><input type="text" name="name" value="${comment.name }" disabled="disabled"></td>
				<td><input type="text" name="comment" value="${comment.comment }"></td>
				<td><input type="submit" value="수정하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>