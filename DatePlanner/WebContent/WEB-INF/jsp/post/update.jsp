<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.dateplanner.commons.Region"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<tr><td>제목: </td><td><input name="title" value="${post.title}" required></td></tr>
				<tr>
					<td>내용: </td>
					<td><textarea id="summernote" name="content" required>${post.content}</textarea></td>
				</tr>
				<tr>
					<td>사진: </td>
					<td><input id="imageInput" type="file"></td>
				</tr>
				<tr>
					<td>사진 주소: </td>
					<td><input id="image" name="image" value="${post.image}" readonly></td>
				</tr>
				<tr><td>lat: </td><td><input name="lat" value="${post.lat}"></td></tr>
				<tr><td>lng: </td><td><input name="lng" value="${post.lng}"></td></tr>
				<tr>
					<td>지역: </td>
					<td>
						<select name="regionNo">
							<c:forEach var="region" items="${Region.LIST}" varStatus="status">
								<option value="${status.index}"<c:if test="${status.index eq post.regionNo}"> selected</c:if>>${region}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr><td>packageable: </td><td><input type="checkbox" name="packageable"<c:if test="${post.packageable eq true}"> checked</c:if>></td></tr>
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
	<script src="../js/FileUpload.js"></script>
	<script>
		var $image = $('#image'),
			$summernote = $('#summernote');
		
		$('#imageInput').change(function() { fileUpload('img/upload', this.files, function(json) { $image.val(json.result) }) });
		$('#summernote').summernote({
			height: 400,
			callbacks: {
				onImageUpload: function(files) {
					fileUpload('img/upload/list', files, function(json) {
						$.each(json, function() { $summernote.summernote('editor.insertImage', '/post/img/'+this) })
					})
				}
			}
		})
	</script>
</body>
</html>