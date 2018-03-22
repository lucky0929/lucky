<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        #login_box{
            text-align: center;
        }

        #id{
            font-size: large;
            height: 50px;
            width: 50%;
        }

        #password{
            font-size: large;
            height: 50px;
            width: 50%;
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
                
                    <li><a href="../user/join"><span
                            class="glyphicon glyphicon-user"></span>회원가입</a></li>

                    <li><a href="../user/login"><span
                            class="glyphicon glyphicon-log-in"></span>로그인</a></li>
                            
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


<div class="container">
    <div id="jumbotron_wrap" style="padding-top: 10%">
        <div class="jumbotron">
            <h1 style="text-align: center">DatePlanner</h1>
            <div id="login_box">
                <form id="loginForm" action="doLogin" method="post">
                    <input type="text" name="id" id="id" placeholder="아이디" required>
                    <input type="password" name="password" id="password" placeholder="비밀번호" required>

                    <div style="padding-top: 15px">
                        <button class="btn btn-info" style="width: 50%; height: 50px">로그인</button>
                    </div>
                </form>
                <a href="../user/join"><button class="btn btn-info" style="width: 50%; height: 50px">회원가입</button></a>
            </div>

            <div id="api_login" style="text-align: center; padding-top: 15px">
                <a href="#"><img src="/user/img/facebook.png"></a>
            </div>
        </div>

    </div>
</div>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="../js/sha512.js"></script>
<script>
    var $password = $('#password');
    $('#loginForm').submit(function(e) { $password.val(sha512($password.val())); });
</script>

</body>
</html>