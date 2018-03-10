<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head><c:set var="mypage" value="${loginInfo eq user}"/>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title><c:choose><c:when test="${mypage}">내</c:when><c:otherwise>${user.nickname}님의 </c:otherwise></c:choose>페이지 - DatePlanner</title>
</head>
<body>
	<a href="../../">메인 페이지로</a>
	<div>
		<dl>
			<dt>닉네임</dt>
			<dd>${user.nickname}</dd>
			<dt>거주지</dt>
			<dd>${user.region}</dd>
			<dt>한줄소개</dt>
			<dd>${user.introduction}</dd>
			<dt>프로필 사진</dt>
			<dd><img src="../img/${user.profileWithDefault}"></dd>
			<c:if test="${mypage}">
				<dt>계정 관리</dt>
				<dd><a href="../update">프로필 수정</a> / <a href="../leave">회원 탈퇴</a></dd>
			</c:if>
		</dl>
	</div>
	<div>
		<div><span>글 목록</span></div>
		<c:choose>
			<c:when test="${empty postList}">
				<div><span>글이 없습니다.</span></div>
			</c:when>
			<c:otherwise>
			
			<ul class="pagination">
				<c:if test="${1 < page.start}"><a href="?p=${page.start - page.pageCount}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></c:if>
				<c:forEach var="p" begin="${page.start}" end="${page.end}">
					<li><a href="?p=${p}" aria-label="Next">${p}</a></li>
				</c:forEach>
				<c:if test="${page.next}"><a href="?p=${page.end + 1}"><span aria-hidden="true">&raquo;</span></a></c:if>
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
								<dd><a href="../../${category}/view/${post.no}">${post.title}</a></dd>
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
									<dd><a href="../../${category}/update/${post.no}">수정</a> <a href="../../${category}/delete/${post.no}">삭제</a></dd>
								</c:if>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>