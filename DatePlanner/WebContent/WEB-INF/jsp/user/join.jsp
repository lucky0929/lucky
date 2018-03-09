<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.dateplanner.commons.Region"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원가입 - DatePlanner</title>
</head>
<body>
	<form id="joinForm" action="doJoin" method="POST" enctype="multipart/form-data">
		<table border="1" style="border-collapse: collapse">
			<tr><td>아이디: </td><td><input name="id" required></td></tr>
			<tr><td>비밀번호: </td><td><input id="password" name="password" type="password" required></td></tr>
			<tr><td>이름: </td><td><input name="name"></td></tr>
			<tr><td>닉네임: </td><td><input name="nickname" required></td></tr>
			<tr>
				<td>지역: </td>
				<td>
					<select name="regionNo">
						<c:forEach var="region" items="${Region.LIST}" varStatus="status">
							<option value="${status.index}"<c:if test="${status.index eq regionNo}"> selected</c:if>>${region}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td>프로필: </td><td><input id="profileInput" type="file"></td></tr>
			<tr><td>파일 주소: </td><td colspan="2"><input id="profile" name="profile" readonly></td></tr>
			<tr><td>한줄소개: </td><td><input name="introduction"></td></tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<a href="../">메인 페이지로</a>
					<button>회원가입</button>
				</td>
			</tr>
		</table>
	</form>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="../js/FileUpload.js"></script>
	<script src="../js/sha512.js"></script>
	<script>
		var $password = $('#password'),
			$profileInput = $('#profileInput')
			$profile = $('#profile'),
			submittable = false;
		
		$profileInput.change(function() { fileUpload('join/upload', $profileInput[0].files, function(json) { $profile.val(json.result) }) });
		$('#joinForm').submit(function(e) { $password.val(sha512($password.val())) });
	</script>
</body>
</html>