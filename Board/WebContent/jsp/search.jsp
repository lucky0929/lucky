<%@page import="util.PaginateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="total" value="${total }"/>
<%-- <%
	//page 파라미터 받음
	String pageStr = 
	request.getParameter("page");

	// 기본값은 1
	int nowPage = 1;

	//만약 page파라미터가 있다면 
	//int형으로 변환
	if(pageStr!=null && pageStr.length()!=0){
		nowPage = Integer.parseInt(pageStr); 
	}//if end
	
	//한 페이지당 보여질 방명록 갯수
	int numPage = 5;
	
	//페이징의 블록갯수
	int numBlock = 5;
	//해당 페이지의 주소
	
	String url = "search.do";
	String param = "&page=";
	
	int total = (int)request.getAttribute("total");
	
	//페이징 마크업(문자열)
	String paginate =  
	PaginateUtil.getPaginate(nowPage, total, numPage, numBlock, url, param);
%> --%>
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
		</table>
		<%-- <%=paginate %> --%>
</body>
</html>