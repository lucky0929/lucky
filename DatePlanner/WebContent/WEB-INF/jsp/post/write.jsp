<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css">
	<title>글쓰기</title>
</head>
<body>
	<div class="container">
		<form action="doWrite" method="POST">
			<table border="1" style="width: 100%; border-collapse: collapse">
				<tr><td>제목: </td><td><input name="title"></td></tr>
				<tr>
					<td>내용: </td>
					<td><textarea id="summernote" name="content"></textarea></td>
				</tr>
				<tr>
					<td>사진: </td>
					<td><input type="file"></td>
				</tr>
				<tr>
					<td>사진 주소: </td>
					<td><input name="image" readonly></td>
				</tr>
				<tr><td>lat: </td><td><input name="lat" value="123.123"></td></tr>
				<tr><td>lng: </td><td><input name="lng" value="123.123"></td></tr>
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
				<tr><td>packageable: </td><td><input type="checkbox" name="packageable"></td></tr>
				<tr>
					<td colspan="2" style="text-align: right">
						<a href="../">메인 페이지로</a>
						<button>글쓰기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.min.js"></script>
	<script>
		var $image = $('input[name=image]');
		$('input[type=file]').change(function() {
			var data = new FormData();
			data.append('file', this.files[0]);
			$.ajax('write/upload', {
				data: data,
				type : "POST",
				cache : false,
				contentType : false,
				processData : false,
				success: function(json) { $image.val(json[0]) }
			})
		});
		$(function() { $('#summernote').summernote({
			height: 400,
			callbacks: {
				onImageUpload: function(files) {
					var data = new FormData();
					$.each(files, function(i, v) { data.append(i, v) });
					var editor = this;
					$.ajax({
						data : data,
						type : "POST",
						url : "write/upload",
						cache : false,
						contentType : false,
						processData : false,
						success : function(data) { $.each(data, function() { $(editor).summernote('editor.insertImage', '/post/img/'+this) }) }
					});
				}
			}
		})})
	</script>
</body>
</html>