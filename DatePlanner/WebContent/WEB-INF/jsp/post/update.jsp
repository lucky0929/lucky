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
	<style>
			input[name="packageable"] {
			width:15px;
			height:15px;
		}
		input[name="title"] {
			height : 45px;
			line-height: 45px;
			text-indent :10px;
			font-size:30px;
		}
		input[name="title"]:FOCUS { outline-style: none; }
		table tr>td:NTH-CHILD(1) {
			min-width: 100px;
			padding: 20px;
			text-align: center;
			font-size:20px;
			font-weight: 800;
			background-color: #999;
		}
		.button:HOVER {
			background-color: #000;
			color: #fff;
		}
		.button {
			transition: .4s ease;
			float:right;
		    width: 200px;
		    height: 50px;
		    font-size: 23px;
		    font-weight: 600;
		    background: center;
		    border: 3px solid gray;
		}
		        table{
            width: 100%;
            text-align: center;
        }

        input{
            width: 100%;
        }

        .jumbotron table{
            font-size: 18px;
        }

        table tr td{
            padding: 10px;
        }

        ul{
            list-style: none;
        }
	</style>
</head>
<jsp:include page="../include/nav.jsp" flush="false"/>
<body>
	<div class="container">
		<form action="../doUpdate" method="POST">
		<input type="hidden" value="${post.no}" name="no" />
			<table border="1" style="width: 100%; border-collapse: collapse">
				<tr><td>제목: </td><td colspan="3"><input name="title" value="${post.title}" required></td></tr>
				<tr> 
					<td>내용: </td>
					<td colspan="3"><textarea id="summernote" name="content" required>${post.content}</textarea></td>
				</tr>
				<tr>
					<td >사진: </td>
					<td colspan="3"><input id="imageInput" type="file"></td>
				</tr> 
				<tr class="hidden">
					<td>사진 주소: </td>
					<td colspan="3"><input type="hidden" id="image" name="image" value="${post.image}" readonly></td>
				</tr>
				<tr>
					<td>지역: </td>
					<td>
						<select name="regionNo" disabled="disabled">
							<c:forEach var="region" items="${Region.LIST}" varStatus="status">
								<option value="${status.index}"<c:if test="${status.index eq post.regionNo}"> selected</c:if>>${region}</option>
							</c:forEach>
						</select>
					</td>
					<td>패키지 가능 여부: </td><td><input type="checkbox" name="packageable"<c:if test="${post.packageable eq true}"> checked</c:if>></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: right">
						<button>수정하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.min.js"></script>
	<script src="../../js/FileUpload.js"></script>
		
	<script>
		var $image = $('#image'),
			$summernote = $('#summernote');
		
		$('#imageInput').change(function() { fileUpload('../img/upload', this.files, function(json) { $image.val(json.result) }) });
		$('#summernote').summernote({
			height: 400,
			callbacks: {
				onImageUpload: function(files) {
					fileUpload('../img/upload/list', files, function(json) {
						$.each(json, function() { $summernote.summernote('editor.insertImage', '/post/img/'+this) })
					})
				}
			}
		})
	</script>
</body>
</html>