<%@page import="org.springframework.stereotype.Service"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="dao.IBoardDao"%>
<%@page import="service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="util.PaginateUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="total" value="${total }"/>
<%
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
	String url = "main.do";
	String param = "page=";
	
	int total = (int)request.getAttribute("total");
	
	//페이징 마크업(문자열)
	String paginate =  
	PaginateUtil.getPaginate(nowPage, total, numPage, numBlock, url, param);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${userInfo.name } 님 반갑읍니다.
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.num }</td>
				<td>${board.name }</td>
				<td><a
					href="http://localhost/Board/detail.do?num=${board.num }">${board.title }</a>
				</td>
				<td>${board.readCount }</td>
			</tr>
		</c:forEach>
	</table>
	<%=paginate %>
	<br>
	<a href="insertForm.do">글 작성</a>
	<a href="logout.do">로그아웃</a>
	<br>
	<br>

	<form action="search.do">
		<select id="what" name="what">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="titleAndContent">제목+내용</option>
			<option value="name">글쓴이</option>
		</select> <input id="searchBox" type="text" name="whatSearch"> <input
			type="submit" value="검색">
	</form>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
/* 	$('#what').click(function(){
	var what = $('#what').val();
	$('#searchBox').attr("name",what);
	}); */
	</script>

</body>
</html>