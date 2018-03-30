<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="val"/>
	<button id="access">검색</button>
	<div id="num">
	</div>
</body>
<script src="//sunx.cafe24.com/js/jquery.js"></script>
<script>
	$("#access").click(function() {
		
		var num = $("#val").val();
		
		 $.ajax({
	            
			 	url:'test' ,
	            type:'GET' ,
	            data:{num:num} ,
	            success:function(data){ $('div').append(data); }
	            ,
	            
	            error:function(textStatus, errorThrown){
	                alert("에러 발생 \n" + textStatus + " : " + errorThrown);
	                self.close();
	            }
	            
	        }) //ajax
	        
	})//access click
</script>
</html>