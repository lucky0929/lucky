<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Your Website Title</title>
<meta property="og.url" content="http://localhost/share.jsp" />
<meta property="og:type" content="article" />
<meta property="og:title" content="lucky jjang jjang man" />
<meta property="og:description" content="lucky lucky jjang" />
<meta property="og:image"         content="https://www.your-domain.com/path/image.jpg" />
</head>
<body>

  <!-- Load Facebook SDK for JavaScript -->
  <div id="fb-root"></div>
  <script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  </script>

  <div class="fb-share-button" 
  data-href="http://localhost/share.jsp/" 
  data-layout="button_count" 
  data-size="small" 
  data-mobile-iframe="true">
  <a class="fb-xfbml-parse-ignore" target="_blank" 
  href="https://www.facebook.com/sharer/sharer.php?u="+인코딩된 공유할 주소+"&amp;src=sdkpreparse">공유하기</a></div>
</body>
</html>