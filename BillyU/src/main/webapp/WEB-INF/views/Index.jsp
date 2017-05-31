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
<title>대여전문 사이트</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<style>
.toggles {
  width: 800px;
  margin: auto;
  display: block;
  clear: both;
  overflow: hidden;
}
.button {
  border: 2px solid #D8D8D8;
  border-radius: 40px;
  color: #5E610B;
  display: block;
  float: left;
  margin: auto;
  padding: 10px;
  width: 150px;
  cursor: pointer;
  font-size: 14px;
  margin: 5px 5px;
}

.posts {
  width: 800px;
  margin: 2em auto;
}

.panel-group{
  font: 16px/18px Arial;
  width: 1000px;
  height: 150px;
  margin: 10px auto;
  display: block;
  text-align: center;
}
.img-rounded{
width:200px;
height:150px;
}

</style>
</head>
<body>
<jsp:include page="Navigation/NavigationBar.jsp" />
<!-- 사이트 설명 시작 -->
<center>
<div class="container" style="height:600px;">
  <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/img/arin.jpg" alt="Los Angeles" style="height:600px;width:100%;">
      </div>

      <div class="item">
        <img src="resources/img/bird.jpg" alt="Chicago" style="height:600px;width:100%;">
      </div>
    
      <div class="item">
        <img src="resources/img/flower.jpg" alt="New york" style="height:600px;width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</center>
<br />
<!-- 사이트 설명 끝 -->
<div id="wrapper">
<div class="toggles">
<button class="button" value="전체보기" id="showall">전체보기</button> 
<%
	ArrayList<cateDTO> categorybig_list = category_list.categorybig_list();
	for(int i=0;i<categorybig_list.size();i++){
		cateDTO dto = categorybig_list.get(i);
		String categorybig = dto.getcategorybig();

		%>
		<button class="button" value="<%=categorybig %>" id="cate<%=i+1%>"><%=categorybig %></button>
		<%
	}
%>
</div>
<center>
<div style="width:1000px" class="way">
<h2 id="Y_result" style="float:left;display:inline-block;">최근등록상품</h2>
<!-- 판매 대여 나눴던 부분인데 안쓸듯
<div style="background:#428bca;width:20px;height:20px;display:inline-block;float:right"> </div><a value="대여" id="rent" style="display:inline-block;float:right">대여</a>
<div style="background:#ebcccc;width:20px;height:20px;display:inline-block;float:right"> </div><a value="판매" id="sale" style="display:inline-block;float:right">판매</a>
-->
</div>
</center>

<div class="panel-group posts" style="clear:both">
<%
	ArrayList<proDTO> pro_list = product_list.pro_list();
	ArrayList<cateDTO> categorynumber_list = new ArrayList<cateDTO>();
	String Y_Category="";
	String cate_name="";
	int maxsize = 0;
	if(pro_list.size() <= 10){
		maxsize = pro_list.size();
	}else{
		maxsize=10;
	}
	
	for(int i=0;i<maxsize;i++){
		proDTO dto = pro_list.get(i);
		int productnumber = dto.getProductnumber();
		String img = dto.getImg();
		String title = dto.getTitle();
		int rentprice = dto.getRentprice();
		int rentdeposite = dto.getRentdeposite();
		int rentmaxdate = dto.getRentmaxdate();
		int categorynumber = dto.getCategorynumber();
		String productinformation = dto.getProductinformation();
		Timestamp curtime = dto.getCurtime();
		
		categorynumber_list = category_list.categorynumber(categorynumber);
		cateDTO cdto = categorynumber_list.get(i);
		String listsmall = cdto.getcategorysmall();
		String listbig = cdto.getcategorybig();
		
		if(categorynumber<200 && categorynumber>100){
			Y_Category="cate1";
		}else if(categorynumber<300 && categorynumber>200){
			Y_Category="cate2";
		}else if(categorynumber<400 && categorynumber>300){
			Y_Category="cate3";
		}else if(categorynumber<500 && categorynumber>400){
			Y_Category="cate4";
		}else if(categorynumber<600 && categorynumber>500){
			Y_Category="cate5";
		}else if(categorynumber<700 && categorynumber>600){
			Y_Category="cate6";
		}else if(categorynumber<800 && categorynumber>700){
			Y_Category="cate7";
		}else if(categorynumber<900 && categorynumber>800){
			Y_Category="cate8";
		}else if(categorynumber<1000 && categorynumber>900){
			Y_Category="cate9";
		}else if(categorynumber<1100 && categorynumber>1000){
			Y_Category="cate10";
		}else if(categorynumber<1200 && categorynumber>1100){
			Y_Category="cate11";
		}else if(categorynumber<1300 && categorynumber>1200){
			Y_Category="cate12";
		}else if(categorynumber<1400 && categorynumber>1300){
			Y_Category="cate13";
		}else if(categorynumber<1500 && categorynumber>1400){
			Y_Category="cate14";
		}else if(categorynumber<1600 && categorynumber>1500){
			Y_Category="cate15";
		}else if(categorynumber<1700 && categorynumber>1600){
			Y_Category="cate16";
		}
			%>
	<div class="panel panel-primary <%=Y_Category%> post rent">
      <div class="panel-heading" style="height:32px"><span style="float:left">상품번호(<%=productnumber %>)</span><span style="text-align:center;"><%=listbig %>(<%=listsmall %>)</span><span style="float:right;color:white"><%=curtime %></span></div>
      <div class="panel-body">
      <div class="col-xs-3 col-md-3"><a href="ProductViewPage?productnumber=<%=productnumber %>"><img class="img-rounded" src="<%=img %>" onerror="this.src='resources/img/noimage.jpg'" alt="사진없음" /></a></div>
      <div class="col-xs-6 col-md-3"><a href="ProductViewPage?productnumber=<%=productnumber %>"><%=title %></a></div>
      <div class="col-xs-1 col-md-2">대여료(원)/1일<br /><br /><%=rentprice %></div>
      <div class="col-xs-1 col-md-2">보증금(원)<br /><br /><%=rentdeposite %></div>
      <div class="col-xs-1 col-md-2">최대일수(일)<br /><br /><%=rentmaxdate %></div>
      </div>
    </div>
			<%
	}
%>
<div id="here"></div>
    <br />
  </div>
</div>
<br />

<script type="text/javascript">
$(document).ready(function() {
    $('.toggles button').click(function(){
      var get_id = this.id;
      var get_current = $('.posts .' + get_id);
      var name = $(this).attr('value');
      $('#Y_result').text('"'+name+'"'+" 검색결과");
  
        $('.post').not( get_current ).hide(500);
        get_current.show(500);
    });
    $('#showall').click(function() {
        $('.post').show(500);
    });
    
    $('.way a').click(function(){
    	var getid=this.id;
    	var getcurrent=$('.posts .'+getid);
    	var na = $(this).attr('value');
    	$('#Y_result').text('판매/대여');
    	  
        $('.post').not( getcurrent ).hide(500);
        getcurrent.show(500);
    })
}); 

$(document).ready(function () {
$(document).scroll(function() {
var maxHeight = $(document).height();
var currentScroll = $(window).scrollTop() + $(window).height();
var page=1;
if (maxHeight <= currentScroll+100) {
$.ajax({
	type : "POST",
	url : "./IndexScrollPage",
	success : WhenSuccess,
	error : WhenError	
});
}
})
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