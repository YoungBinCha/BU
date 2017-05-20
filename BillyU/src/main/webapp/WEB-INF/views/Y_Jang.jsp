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
  <title>찜바구니</title>
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
.container{
	display:inline;
	width:300px;
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
<jsp:include page="Y_NavBar.jsp" />
<br />
<br />

<div class="All_wrap">
<center>
<div id="product-container">
<div id="here" style="width:80%">
<jsp:include page="Y_MyJang.jsp" />
</div>
</center>
</div>
</div>
</body>
</html>
