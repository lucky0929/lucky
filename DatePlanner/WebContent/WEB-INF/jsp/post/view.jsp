<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>${post.title} - DatePlanner</title>
	<style>
		#selected { background-color: gray; color:#fff; }
	</style>
</head>
<body>
	<table border="1" style="border-collapse: collapse">
		<tr><td>제목: </td><td>${post.title}</td></tr>
		<tr><td>내용: </td><td>${post.content}</td></tr>
		<tr><td>사진: </td><td>${post.image}</td></tr>
		<tr><td>글쓴이_닉네임: </td><td>${post.user.nickname}</td></tr>
		<tr><td>지역: </td><td>${post.region}</td></tr>
		<tr><td>패키지 허용 여부: </td><td>${post.packageable}</td></tr>
		<tr><td>작성일: </td><td>${post.regdate}</td></tr>
	</table>
	
	<ul class="pagination">
	
	<%-- 이전 페이지로 --%>
		<c:if test="${1 < page.start}"> 
			<li><a href="?p=${page.start - page.pageCount}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
		</c:if>
		
		<%-- 페이지 블럭 생성 --%>
		<c:forEach var="p" begin="${page.start}" end="${page.end}"> 
			<li><a href="?p=${p}" <c:if test="${p eq page.current}">id="selected"</c:if>>${p}</a></li>
		</c:forEach>
		
		<%-- 다음 페이지로 --%>
		<c:if test="${page.next}">	
			<li>
				<a href="?p=${page.end + 1}"aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</c:if>
	</ul><!-- pagination -->
	
	<a href="../../">메인 페이지로</a>
</body>
</html>