<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="main.do?page=${page }">홈으로</a></h1>
	<center>
		<h1>제목 : ${detail.title }</h1>
		작성자 : ${detail.name }
		<p>내용 : ${detail.content }</p>
		<p>
			<img alt="${detail.file }" src="${detail.file }" width="350" height="350px"/>
		</p>
		<c:if test="${detail.name eq userInfo.name}">
			<a href="http://localhost/Board/updateForm.do?num=${detail.num }">수정하기</a>
			<a href="http://localhost/Board/deleteForm.do?num=${detail.num }">삭제하기</a>
		</c:if>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>내용</th>
			<th>작성시간</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="comments" items="${comments}">
			<tr>
				<td>${comments.name }</td>
				<td>${comments.comment }</td>
				<td>${comments.writedate }</td>
				<c:if test="${comments.name eq userInfo.name}">
				<td><a href="deleteComment.do?commentNum=${comments.commentNum}&num=${detail.num}">삭제</a>
				/
				<a href="updateCommentForm.do?commentNum=${comments.commentNum}&num=${detail.num}">수정</a>
				</td>
				</c:if>
			</tr>
		</c:forEach>
		<br>
		댓글창
	</table>
	<form action="insertComment.do">
		${detail.num }
		<input type="hidden" name="num" value="${detail.num }">
		작성자 : <input type="text" name="name" value="${userInfo.name }">
		내용 : <input type="text" name="comment">
		<input type="submit" value="댓글작성">
	</form>
	</center>
</body>
</html>