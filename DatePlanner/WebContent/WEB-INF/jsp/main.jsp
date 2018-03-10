<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.dateplanner.commons.Region"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>DatePlanner</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<c:choose>
		<c:when test="${empty loginInfo}">
			<div><a href="user/login">로그인</a> / <a href="user/join">회원가입</a></div>
		</c:when>
		<c:otherwise>
			<div><strong>${loginInfo.nickname}</strong>로 로그인됨</div>
			<div><a href="post/write">글쓰기</a> / <a href="package/create">패키지 만들기</a></div>
			<div><a href="user/mypage">마이페이지</a> / <a href="user/logout">로그아웃</a></div>
		</c:otherwise>
	</c:choose>
	<div>
		<span>지역선택</span>
		<select id="regionSelect">
			<c:forEach var="region" items="${Region.LIST}" varStatus="status">
				<option value="${status.index}"<c:if test="${status.index eq regionNo}"> selected</c:if>>${region}</option>
			</c:forEach>
		</select>
	</div>
	
	<div>
		<div><span>글 목록</span></div>
		<c:choose>
			<c:when test="${empty postList}">
				<div><span>글이 없습니다.</span></div>
			</c:when>
			<c:otherwise>
			<ul class="pagination">
				<c:if test="${1 < page.start}"><li><a href="?<c:if test="${!empty param.r}">r=${regionNo}&</c:if>p=${page.start - page.pageCount}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li></c:if>
				<c:forEach var="p" begin="${page.start}" end="${page.end}">
					<li><a href="?<c:if test="${!empty param.r}">r=${regionNo}&</c:if>p=${p}">${p}</a></li>
				</c:forEach>
				<c:if test="${page.next}"><li><a href="?<c:if test="${!empty param.r}">r=${regionNo}&</c:if>p=${page.end + 1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li></c:if>
			</ul>
					<c:forEach var="post" items="${postList}">
						<c:set var="category">
							<c:choose>
								<c:when test="${post.packageable eq null}">package</c:when>
								<c:otherwise>post</c:otherwise>
							</c:choose>
						</c:set>
						<li style="border: 1px solid black<c:if test="${category eq 'package'}">; background: lightgray</c:if>">
							<c:if test="${!empty post.image}"><img src="${category}/img/${post.image}" height="480"></c:if>
							<dl style="display: inline-block">
								<dt>제목</dt>
								<dd><a href="${category}/view/${post.no}">${post.title}</a></dd>
								<dt>내용</dt>
								<dd>${post.content}</dd>
								<dt>lat</dt>
								<dd>${post.lat}</dd>
								<dt>lng</dt>
								<dd>${post.lng}</dd>
								<dt>글쓴이</dt>
								<dd>${post.user.nickname}</dd>
								<dt>지역</dt>
								<dd>${post.region}</dd>
								<dt>작성일</dt>
								<dd>${post.regdate}</dd>
								<c:if test="${loginInfo.no eq post.user.no}">
									<dt>편집</dt>
									<dd><a href="${category}/update/${post.no}">수정</a> <a href="${category}/delete/${post.no}">삭제</a></dd>
								</c:if>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>$('#regionSelect').change(function(){location.href='?r='+$(this).val()})</script>
</body>
</html>