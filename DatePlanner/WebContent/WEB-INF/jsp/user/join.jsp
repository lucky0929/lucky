<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<form id="joinForm" action="doJoin" method="POST" enctype="multipart/form-data">
		<table border="1" style="border-collapse: collapse">
			<tr><td>아이디: </td><td><input name="id" required></td></tr>
			<tr><td>비밀번호: </td><td><input type="password" name="password" required></td></tr>
			<tr><td>이름: </td><td><input name="name"></td></tr>
			<tr><td>닉네임: </td><td><input name="nickname" required></td></tr>
			<tr>
				<td>지역: </td>
				<td>
					<select name="regionNo">
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
				</td>
			</tr>
			<tr><td>프로필: </td><td><input type="file"></td></tr>
			<tr><td>파일 주소: </td><td colspan="2"><input name="profile" readonly></td></tr>
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
	<script src="../js/sha512.js"></script>
	<script>
		var $password = $('input[name=password]'),
			$profile = $('input[name=profile]');
		$('input[type=file]').change(function() {
			var data = new FormData();
			data.append('file', this.files[0]);
			$.ajax('join/upload', {
				data: data,
				type : "POST",
				cache : false,
				contentType : false,
				processData : false,
				success: function(json) { $profile.val(json.fileName) }
			})
		});
		$('#joinForm').submit(function(e) { $password.val(sha512($password.val())) });
	</script>
</body>
</html>