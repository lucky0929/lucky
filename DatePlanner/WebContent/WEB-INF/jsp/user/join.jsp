<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.dateplanner.commons.Region"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>DatePlanner</title>
	<style>
		.container { text-align: center; }
		table  { width: 100%; }
		input  { width: 100%; }
		select { text-align: left; float: left; }
		#jumbotron_wrap { padding-top: 10%  }
	</style>
</head>
<body>
<jsp:include page="../include/nav.jsp" />
	<div class="container">
		<div id="jumbotron_wrap">
			<div class="jumbotron">
				<h1>DatePlanner</h1>
				<h3>회원가입</h3>
				<form id="joinForm" action="doJoin" method="POST"
					enctype="multipart/form-data">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td>아이디 :</td>
								<td><input name="id" required></td>
							</tr>
							<tr>
								<td>비밀번호 :</td>
								<td><input id="password" name="password" type="password"
									required></td>
							</tr>
							<tr>
								<td>이름 :</td>
								<td><input name="name" required></td>
							</tr>
							<tr>
								<td>닉네임 :</td>
								<td><input name="nickname" required></td>
							</tr>
							<tr>
								<td>지역</td>
								<td><select name="regionNo">
										<c:forEach var="region" items="${Region.LIST}"
											varStatus="status">
											<option value="${status.index}"
												<c:if test="${status.index eq regionNo}"> selected</c:if>>${region}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>프로필 :</td>
								<td><input id="profileInput" type="file"></td>
							</tr>
							<tr class="hidden">
								<td>파일 주소 :</td>
								<td colspan="2"><input id="profile" name="profile" readonly></td>
							</tr>
							<tr>
								<td>한줄소개 :</td>
								<td><input name="introduction"></td>
							</tr>
							<tr>
								<td colspan="2"><button class="btn btn-info">회원가입</button></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>

	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="../js/FileUpload.js"></script>
	<script src="../js/sha512.js"></script>
	<script>
		var $password = $('#password'), $profileInput = $('#profileInput')
		$profile = $('#profile'), submittable = false;

		$profileInput.change(function() {
			fileUpload('join/upload', $profileInput[0].files, function(json) {
				$profile.val(json.result)
			})
		});
		$('#joinForm').submit(function(e) { $password.val(sha512($password.val())) });
	</script>
</body>
</html>