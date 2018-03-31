<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
// 댓글 더보기 aJax
		var window = $(window);
		var $more = $("#more");
		var p = 2;
		
		$("#more").click(function(){
			$.ajax({
				url:'/post/commentSelect',
				type:'GET',
				data:{p:p, boardNo:${post.no}},
				success:function(data){
					if(data.length <= 0){
						alert("댓글이 없습니다.");
					} else {
						p+=1;
						 for (var i = 0; i < data.length; i++){ 
							 $('#comment_wrap').append("<div class='comment_box'>"+"<img src='/user/img/"+data[i].user.profileWithDefault +"'><p>"+ data[i].content+'</p></div>');
						 }
					}
				},
				error:function(textStatus, errorThrown){
                   alert("죄송합니다\n 예상치 못한 에러가 발생하였습니다.\n 나중에 다시 시도해주세요");
                   self.close();
	           }
			});
		});
// 페럴렉스
		$(window).scroll(function() {
			if ($(window).scrollTop() / 2 < 500) {
				$('.parallex').css('top', $(window).scrollTop() / 2);
			} //if
		});
		
</script>