<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>DatePlanner - ${post.title}</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse">
		<tr><td>제목: </td><td>${post.title}</td></tr>
		<tr><td>내용: </td><td>${post.content}</td></tr>
		<tr><td>사진: </td><td>${post.image}</td></tr>
		<tr><td>글쓴이_닉네임: </td><td>${post.user.nickname}</td></tr>
		<tr><td>지역: </td><td>${post.regionNo}</td></tr>
		<tr><td>패키지 허용 여부: </td><td>${post.packageable}</td></tr>
		<tr><td>작성일: </td><td>${post.regdate}</td></tr>
	</table>
	<a href="../">메인 페이지로</a>
</body>
</html>