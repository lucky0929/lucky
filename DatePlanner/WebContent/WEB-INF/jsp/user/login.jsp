<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<form id="loginForm" action="doLogin" method="POST">
		<table border="1" style="border-collapse: collapse">
			<tr><td>아이디: </td><td><input name="id" required></td></tr>
			<tr><td>비밀번호: </td><td><input type="password" name="password" required></td></tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<a href="../">메인 페이지로</a>
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="../js/sha512.js"></script>
	<script>
		var $password = $('input[name=password]');
		$('#loginForm').submit(function(e) { $password.val(sha512($password.val())); });
	</script>
</body>
</html>