<%@page import="org.dateplanner.commons.Region"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>패키지 만들기 - DatePlanner</title>
</head>
<body>
	<form id="createForm" action="doCreate">
		<table>
			<tr><td>제목: </td><td><input name="title" required></td></tr>
			<tr><td>내용: </td><td><input name="content" required></td></tr>
			<tr><td>사진: </td><td><input id="imageInput" type="file"></td></tr>
			<tr><td>파일 주소: </td><td><input id="image" name="image" readonly></td></tr>
			<tr><td>글 목록: </td><td><input id="placeList" name="placeList" readonly></td></tr>
			<tr><td>선택됨</td><td>글목록</td></tr>
			<tr>
				<td>
					<ol id="selectedBox">
					</ol>
				</td>
				<td>
					<ul id="placeBox">
						<c:forEach var="place" items="${placeList}">
							<li data-no="${place.no}">${place.title}</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
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
			<tr>
				<td colspan="2" style="text-align: right">
					<a href="../">메인 페이지로</a>
					<button>패키지 작성</button>
				</td>
			</tr>
		</table>
	</form>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="../js/FileUpload.js"></script>
	<script>
		var $select = [$('#selectedBox'), $('#placeBox')],
			$image = $('#image'),
			$placeList = $('#placeList');
		
		$('#imageInput').change(function() { fileUpload('img/upload', this.files, function(json) { $image.val(json.result) }) });
		$.each($select, function(i, v) { v.on('click', 'li', function() { console.log(i); $(this).appendTo($select[1-i]) }) });
		$('#createForm').submit(function(e) {
			var arr = []; $.each($select[0].find('li'), function() { arr.push(this.dataset.no) });
			$placeList.val(arr.join(','))
		})
	</script>
</body>
</html>