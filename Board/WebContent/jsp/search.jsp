<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="search" items="${search }">
			<tr>
				<td>${search.num }</td>
				<td>${search.name }</td>
				<td><a
					href="http://localhost/Board/detail.do?num=${search.num }">${search.title }</a>
				</td>
				<td>${search.readCount }</td>
			</tr>
		</c:forEach>
</body>
</html>