<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<%@ page import="product.proDAO" %>
<%@ page import="product.proDTO" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="product_list" class="product.proDAO" />
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>마이페이지</title>
  <meta charset="utf-8">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  /* Note: Try to remove the following lines to see the effect of CSS positioning */
  .affix {
      top: 20px;
  }
  #product-container{
  	width:500px;
  	height:100%;
  	display:inline;

  }
  .All_wrap{
  	width:100%;
  	height:100%;
  }
.nav-pills a{
	display:inline;
	width:100px;
	height:65px;
	font-size:20pt;
	font-family: "맑은고딕";
}
#here{
width:100%;
}
</style>
  </style>
</head>
<body>
<%
if(session.getAttribute("id") == null){
response.sendRedirect("Y_Login");}
%>  
<jsp:include page="../Navigation/Y_NavBar.jsp" />

<div class="container">
  <div class="btn-group btn-group-justified nav-pills">
    <a id="#section1" class="btn btn-primary">내가 올린 상품</a>
    <a id="#section2" class="btn btn-primary">나에게 온 메세지</a>
    <a id="#section3" class="btn btn-primary">내가 보낸 메세지</a>
    <a id="#section4" class="btn btn-primary">개인정보 수정</a>
  </div>
</div>
<br />
<br />
<div class="All_wrap">
<center>
<div id="product-container">
<div id="here" style="width:80%">
<jsp:include page="Y_MyProduct.jsp" />
</div>
</center>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
$('.nav-pills li').click(function(){
	$('.nav-pills li').removeClass('active');
	$(this).addClass('active');
	
});
$('.nav-pills a:nth-child(1)').click(function(){
	$.ajax({
		type : "POST",
		url : "./Y_MyProduct",
		success : WhenSuccess,
		error : WhenError
	});
});
$('.nav-pills a:nth-child(2)').click(function(){
	$.ajax({
		type : "POST",
		url : "./Y_MyMail",
		success : WhenSuccess,
		error : WhenError
	});
});
$('.nav-pills a:nth-child(3)').click(function(){
	$.ajax({
		type : "POST",
		url : "./Y_MyWait",
		success : WhenSuccess,
		error : WhenError
	});
});
$('.nav-pills a:nth-child(4)').click(function(){
	$.ajax({
		type : "POST",
		url : "./Y_MyPerson",
		success : WhenSuccess,
		error : WhenError
	});
});
function WhenSuccess(resdata){
	$('#here').html(resdata);
}

function WhenError(){
	alert('error');
}

});


</script>
</body>
</html>
