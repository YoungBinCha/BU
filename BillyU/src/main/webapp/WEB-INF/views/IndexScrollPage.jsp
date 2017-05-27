<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<%@ page import="product.proDAO" %>
<%@ page import="product.proDTO" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="product_list" class="product.proDAO" />
<jsp:useBean id="category_list" class="category.cateDAO" />
<%@ page import="category.cateDTO" %>
<%@ page import="category.cateDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한민국 No2 중고거래</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
<div id="wrapper">
<div class="panel-group posts" style="clear:both">
<%
	ArrayList<proDTO> pro_list = product_list.pro_list();
	String Y_Category="";
	String cate_name="";
	
	for(int i=10;i<pro_list.size();i++){
		proDTO dto = pro_list.get(i);
		
		int pronum = dto.getProductnumber();
		int catnum = dto.getCategorynumber();
		String nickname = dto.getNickname();
		String title = dto.getTitle();
		String productinformation = dto.getProductinformation();
		String location = dto.getLocation();
		String productstate = dto.getProductstate();
		int rentprice = dto.getRentprice();
		int rentmaxdate = dto.getRentmaxdate();
		int rentdeposite = dto.getRentdeposite();
		String img = dto.getImg();
		Timestamp curtime = dto.getCurtime();
		
		if(catnum<200 && catnum>100){
			Y_Category="cate1";
			cate_name="의류";
		}else if(catnum<300 && catnum>200){
			Y_Category="cate2";
			cate_name="잡화";
		}else if(catnum<400 && catnum>300){
			Y_Category="cate3";
			cate_name="유아동";
		}else if(catnum<500 && catnum>400){
			Y_Category="cate4";
			cate_name="식품";
		}else if(catnum<600 && catnum>500){
			Y_Category="cate5";
			cate_name="생필품";
		}else if(catnum<700 && catnum>600){
			Y_Category="cate6";
			cate_name="홈데코";
		}else if(catnum<800 && catnum>700){
			Y_Category="cate7";
			cate_name="건강";
		}else if(catnum<900 && catnum>800){
			Y_Category="cate8";
			cate_name="문구";
		}else if(catnum<1000 && catnum>900){
			Y_Category="cate9";
			cate_name="스포츠";
		}else if(catnum<1100 && catnum>1000){
			Y_Category="cate10";
			cate_name="자동차";
		}else if(catnum<1200 && catnum>1100){
			Y_Category="cate11";
			cate_name="가전";
		}else if(catnum<1300 && catnum>1200){
			Y_Category="cate12";
			cate_name="디지털";
		}else if(catnum<1400 && catnum>1300){
			Y_Category="cate13";
			cate_name="컴퓨터";
		}else if(catnum<1500 && catnum>1400){
			Y_Category="cate14";
			cate_name="도서";
		}else if(catnum<1600 && catnum>1500){
			Y_Category="cate15";
			cate_name="여행";
		}else if(catnum<1700 && catnum>1600){
			Y_Category="cate16";
			cate_name="티켓";
		}%>
	<div class="panel panel-primary <%=Y_Category%> post rent">
      <div class="panel-heading" style="height:32px"><span style="float:left">상품번호(<%=pronum %>)</span><span style="text-align:center;">대여상품(<%=cate_name %>)</span><span style="float:right;color:white"><%=curtime %></span></div>
      <div class="panel-body">
      <div class="col-xs-3 col-md-3"><a href="ProductViewPage?pronum=<%=pronum %>"><img class="img-rounded" src="<%=img %>" alt="사진없음" /></a></div>
      <div class="col-xs-6 col-md-3"><a href="ProductViewPage?pronum=<%=pronum %>"><%=title %></a></div>
      <div class="col-xs-1 col-md-2">대여료(원)<br /><br /><%=rentprice %></div>
      <div class="col-xs-1 col-md-2">보증금(원)<br /><br /><%=rentdeposite %></div>
      <div class="col-xs-1 col-md-2">대여기간(일)<br /><br /><%=rentmaxdate %></div>
      </div>
    </div>
	<%}%>
    <br />
    <div id="here"></div>
  </div>
</div>
<br />
</body>
</html>