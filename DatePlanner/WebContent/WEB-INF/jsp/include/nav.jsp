<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

