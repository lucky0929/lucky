<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.dateplanner.commons.Region"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>DatePlanner</title>
	<style>
		.pagination a[href="#"]{
			cursor: context-menu;
			background-color:gray;
			color:#fff;
			font-size:
		}
		.pagination a[href="#"]:HOVER{ background-color:gray; color:#fff;}
		#loading{
			display:none;
			position: absolute;
			left: 50%;
			top: 50%;
			margin-left: -128px;
			margin-top: -128px;
		}
	</style>
</head>
<body>
<img id="loading" alt="로딩이미지" src="/temp/img/loading.gif" />
	<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="../">DatePlanner</a>
        </div>
        <c:choose>
        	<c:when test="${empty loginInfo}">
		       <ul class="nav navbar-nav navbar-right">
		            <li><a href="user/join"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
		
		            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="user/login">로그인<span class="glyphicon glyphicon-log-in"></span></a>
		
		                <ul class="dropdown-menu">
		                	<li><a href="user/login">데이트 플래너 로그인</a></li>
		                    <li><a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=tOzxSVFgBuq1ArjsmwsD&state=STATE_STRING&redirect_uri=http://localhost/main.jsp">
		                        네이버 로그인</a></li>
		                    <li><a href="#">페이스북 로그인</a></li>
		                </ul>
		            </li>
		        </ul>
        	</c:when>
        	<c:otherwise>
        		<ul class="nav navbar-nav navbar-right">
		            <li><a href="user/mypage"><span class="glyphicon glyphicon-user"></span><strong>${loginInfo.nickname}</strong>로 로그인중</a></li>
		        </ul>
        	</c:otherwise>
        </c:choose>
    </div>
</nav>
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
				<%String title;%>
				<c:forEach var="p" begin="${page.start}" end="${page.end}">
					<c:choose>
						<c:when test="${page.current == p}">
							<li><a href="#" onclick="aNone()">${p}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="?<c:if test="${!empty param.r}">r=${regionNo}&</c:if><c:if test="${!empty title}">title=${title}&</c:if>p=${p}">${p}</a></li>
							&title=<% if(null==(title = (String)request.getAttribute("title"))){} %>
						</c:otherwise>
					</c:choose>
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
			</c:otherwise>
		</c:choose>
	</div>
	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$('#regionSelect').change(function(){
			$("#loading").fadeIn(0);
			location.href='?r='+$(this).val(); 
		});

		function aNone(){
			alert("현재 페이지 입니다"); 
			return false; 
		};
	</script>
</body>
</html>