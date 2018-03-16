<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <c:set var="mypage" value="${loginInfo eq user}"/>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   <title><c:choose><c:when test="${mypage}">내</c:when><c:otherwise>${user.nickname}님의 </c:otherwise></c:choose>페이지 - DatePlanner</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
body {
   background-repeat: no-repeat;
   background-image: url("/tem7p/user-background/sunset-3102754_1920.jpg");
}

.first {
   min-width: 1200px;
}

#profile_H {
   padding-left: 69px;
   position: relative;
   width: 100%;
   height: 100%;
}

#profile {
   width: 300px;
   height: 30%;
   display: inline-block;
   border: 2px solid cyan;
}

#nameBox {
   display: inline-table;
   color: white;
   margin-bottom: -50px;
}

#name {
   font-weight: bold;
   font-size: xx-large;
}

#nickname {
   font-weight: bold;
   font-size: large;
}

#intro {
   font-weight: bold;
}

#region {
   font-weight: bold;
}

ul {
   list-style: none;
   padding: 0;
   margin: 0;
}

.myContent {
   text-align: center;
   padding-top: 20px;
   margin-left: 5%;
   position: relative;
   width: 100%;
}

.content_L {
   float: left;
   overflow: hidden;
   transition: .1s ease;
   margin: 10px;
   position: relative;
   width: 240px;
   height: 240px;
}

.info_box {
   color: antiquewhite;
   width: 240px;
   height: 240px;
   position: absolute;
   transition: .1s ease;
   bottom: -240px;
}

.content_L:hover {
   box-shadow: 0 16px 28px 0 rgba(0, 0, 0, 0.22), 0 25px 55px 0
      rgba(0, 0, 0, 0.21);
}

.content_L:hover .info_box {
   bottom: -70px;
   transition: .1s ease;
}

.content_L:hover:before {
   content: "";
   display: block;
   width: 240px;
   height: 240px;
   top: 0;
   left: 0;
   position: absolute;
   background-color: rgba(0, 0, 0, .7);
}

.heart {
   color: indianred;
   padding-right: 3px;
   font-size: 1.3em;
}

.comment {
   color: cadetblue;
   padding-right: 3px;
   font-size: 1.3em;
}
</style>
</head>
<body>
 	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="../">DatePlanner</a>
			</div>
			<c:choose>
				<c:when test="${empty loginInfo}">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="user/join"><span
								class="glyphicon glyphicon-user"></span>회원가입</a></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="user/login">로그인<span
								class="glyphicon glyphicon-log-in"></span></a>

							<ul class="dropdown-menu">
								<li><a href="user/login">데이트 플래너 로그인</a></li>
								<li><a
									href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=tOzxSVFgBuq1ArjsmwsD&state=STATE_STRING&redirect_uri=http://localhost/main.jsp">
										네이버 로그인</a></li>
								<li><a href="#">페이스북 로그인</a></li>
							</ul></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="user/mypage"><span
								class="glyphicon glyphicon-user"></span><strong>${loginInfo.nickname}</strong>로
								로그인중</a></li>
						<li><a href="user/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>

   
   <div class="first container">

      <div id="profile_H">

         <div id="profile">
            <img src="/post/img/"${userInfo.profile } style="width: 100%; height: 100%;">
         </div>
       
         <div id="nameBox">
            <span id="name">${userInfo.name }</span> <span id="nickname">(${userInfo.nickname })</span>
            <p id="intro">${userInfo.introduction }</p>
            <p id="region">주활동지역 : ${userInfo.regionNo }</p>
         </div> <!-- id="nameBox" -->
      </div> <!-- id="profile_H -->

      <div class="myContent">
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
              <ul>
            <c:forEach var="post" items="${postList }">
               <li class="content_L" <c:if test="${category eq 'package'}">style="board:3px solid pink"</c:if>>
               <c:choose>
		       		<c:when test="${category eq 'package'}">
		       			<a href="../../package/view/${post.no}">
		       		</c:when>
		       		<c:otherwise>
                  		<a href="../../post/view/${post.no}">
                  </c:otherwise>
               </c:choose>
                  
                     <div class="info_box">
                        <h3>${post.title}</h3>
                        <ul>
                           <li><i class="fas fa-heart heart"></i><span>${post.like}</span></li><!-- 조아요 개수 -->
                           <li><i class="fas fa-comment comment"></i><span>${post.comments}</span></li><!-- 댓글 개수 -->
                        </ul>
                     </div> 
                     <%-- <c:if test="${!empty post.image}"> --%>
                        <img src="${category}/img/${post.image}" height="100%" width="100%">
                     <%-- </c:if> --%>
                  </a>
               </li>
               </c:forEach>
           </ul>
         </c:otherwise>
     </c:choose>
      </div> <!-- class="myContent -->
   </div> <!-- class="first container" --> 
</body>
</html>