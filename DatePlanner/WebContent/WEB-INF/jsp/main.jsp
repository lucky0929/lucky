<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>DatePlanner</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty loginInfo}">
			<div><a href="user/login">로그인</a> / <a href="user/join">회원가입</a></div>
		</c:when>
		<c:otherwise>
			<div><strong>${loginInfo.nickname}</strong>로 로그인됨</div>
			<div><a href="post/write">글쓰기</a> / <a href="package/create">패키지 만들기</a> / <a href="user/logout">로그아웃</a></div>
		</c:otherwise>
	</c:choose>
	<div>
		<span>지역선택</span>
		<select id="regionSelect">
			<option value="0">서울특별시</option>
			<option value="1">부산광역시</option>
			<option value="2">광주광역시</option>
			<option value="3">대구광역시</option>
			<option value="4">대전광역시</option>
			<option value="5">인천광역시</option>
			<option value="6">경기도</option>
			<option value="7">울산광역시</option>
			<option value="8">세종특별자치시</option>
			<option value="9">제주특별자치도</option>
			<option value="10">경상남도</option>
			<option value="11">충청남도</option>
			<option value="12">전라북도</option>
			<option value="13">충청북도</option>
			<option value="14">전라남도</option>
			<option value="15">경상북도</option>
			<option value="16">강원도</option>
		</select>
	</div>
	<div>
		<div><span>글 목록</span></div>
		<c:choose>
			<c:when test="${empty postList}">
				<div><span>글이 없습니다.</span></div>
			</c:when>
			<c:otherwise>
				<ul>
					<c:forEach var="post" items="${postList}">
						<li style="border: 1px solid black<c:if test="${post.packageable eq null}">; background: lightgray</c:if>">
							<c:choose>
								<c:when test="${post.packageable eq null}"><img src="package/img/${post.image}" height="480"></c:when>
								<c:otherwise><img src="post/img/${post.image}" height="480"></c:otherwise>
							</c:choose>
							<dl style="display: inline-block">
								<dt>제목</dt>
								<dd><a href="post/view?no=${post.no}">${post.title}</a></dd>
								<dt>내용</dt>
								<dd>${post.content}</dd>
								<dt>lat</dt>
								<dd>${post.lat}</dd>
								<dt>lng</dt>
								<dd>${post.lng}</dd>
								<dt>글쓴이</dt>
								<dd>${post.user.nickname}</dd>
								<dt>지역</dt>
								<dd>${post.regionNo}</dd>
								<dt>작성일</dt>
								<dd>${post.regdate}</dd>
								<c:if test="${loginInfo.no eq post.user.no}">
									<dt>편집</dt>
									<dd><a href="post/update?no=${post.no}">수정</a> <a href="post/delete?no=${post.no}">삭제</a></dd>
								</c:if>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>$('#regionSelect').change(function() { location.href = '?region='+$(this).val() })</script>
</body>
</html>