<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 밑에서 css파일 적용위함! -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>viewPage</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container img {
	margin: 0 auto;
}

.affix {
	top: 0;
	width: 360px;
}

#map {
        height: 400px;
        width: 100%;
       }
       tr > td:first-child{
       	width: 100px;
       }
</style>

<!-- resources/css 밑에있는 cssFile 사용하기 위한 코드-->
<spring:url value="/resources/css/cssFile.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet">

</head>
<body>
	<%
	if(session.getAttribute("id") == null){
		response.sendRedirect("Y_Login");
	}
	%>
	<jsp:include page="../Navigation/NavigationBar.jsp"></jsp:include>
	<%
		int y_productnumber = Integer.parseInt(request.getParameter("productnumber"));
	%>
	<jsp:useBean id="category" class="category.cateDAO"></jsp:useBean>
	<jsp:useBean id="sel" class="regist.registDAO"></jsp:useBean>
	<%
		ArrayList<String> al = sel.selectProduct(y_productnumber);
		String categorynumber = al.get(0);
		String title = al.get(1);
		String productinformation = al.get(2);
		String location = al.get(3); //위치
		String productstate = al.get(4); //상품상태(s급)
		String rentprice_s = al.get(5); //대여비
		String rentunit_s = al.get(6); //??
		String rentdeposite_s = al.get(7); //보증금
		String nickname = al.get(8);
		String kakaotalkid = al.get(9);
		String phone = al.get(10);
		
		if(kakaotalkid == null){
			kakaotalkid = "입력안함";
		}
		if(phone == null){
			phone = "입력안함";
		}
		
		int rentprice = Integer.parseInt(rentprice_s);
		int rentdeposite = Integer.parseInt(rentdeposite_s);
		int rentunit = Integer.parseInt(rentunit_s);

		String categorySmall = category.receivecategorysmall(Integer.parseInt(categorynumber));
		//img 한개일 때 사용하던 코드
		String img = sel.receiveImage(y_productnumber);
		//img 여러개 일 때 사용하는 코드
		ArrayList<String> arrayListImg = sel.selectImage(y_productnumber);
	%>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<mark>카테고리</mark>
				<h3><%= categorySmall %></h3>
			</div>
			<div class="col-lg-3">
				<mark>공여자</mark>
				<h3><%=nickname %></h3>
			</div>
			<div class="col-lg-6">
				<mark>제목</mark>
				<h3><%= title %></h3>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-lg-8">
				<%-- <img class="img-responsive" src="<%= img %>" alt="Chania"
					width="600" height="400"> --%>
			
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
				<% 
				for(int i = 0 ; i<arrayListImg.size(); i++){
					if(!arrayListImg.get(i).equals("resources/img/null")){
						if(i == 0 ){
							%>
								<li data-target="#myCarousel" data-slide-to="<%= i %>" class="active"></li>
							<%
						}else{
							%>
							<li data-target="#myCarousel" data-slide-to="<%= i %>"></li>
							<%
						}
						%>
							
						<%
					}
				}
				%>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
				<% 
				for(int i = 0 ; i<arrayListImg.size(); i++){
					if(!arrayListImg.get(i).equals("resources/img/null")){
						String imageSrc = arrayListImg.get(i);
						if(i == 0){
							%>
								<div class="item active">
								<img src="<%= imageSrc %>" alt="사진없음" style="width: 100%;">
								</div>
							<%
						}else{
							%>
								<div class="item">
								<img src="<%= imageSrc %>" alt="사진없음" style="width: 100%;">
								</div>
							<%
						}
						%>
							
						<%
					}
				}
				%>		
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
				</div>
			</div>
			<!-- 이미지 끝나는 라인 -->
			<div class="col-lg-4">
				<%
			%>
				<div class="panel panel-default panel-rent" data-spy="affix"
					data-offset-top="360">
					<div class="panel-heading">
						
						<h1 class="text-center" id="title_cost"><%= (rentprice+rentdeposite) +"원" %></h1>
						<br>
						<p class="text-center">
							<small> 대여비 <%= rentprice %>(1일) + 보증금 <%=rentdeposite %>
							</small>
						</p>
					</div>
					<div class="panel-body">
						<form id="form" action="RentInsertGuest" method="post">
							<input type="hidden" name="productnumber" value="<%=y_productnumber %>" /> <input
								type="hidden" name="apple"
								value="<%=session.getAttribute("id")%>">
								<input type="hidden" name="rentprice" value="<%=rentprice %>"/>
								<input type="hidden" name="rentdeposite" value="<%=rentdeposite %>"/>
							<div class="form-group">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>요소</th>
											<th>내용</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><label for="fee">대여료 : </label></td>
											<td><input type="hidden" id="rent_cost"
												value="<%= rentprice %>" /><%= al.get(5) %><small>/1일</small></td>
										</tr>
										<tr>
											<td><label for="deposit">보증금 : </label></td>
											<td><input type="hidden" id="bo_cost"
												value="<%= rentdeposite %>" /><%= al.get(7) %></td>
										</tr>
										<tr>
											<td><label for="possibleDay">최대 일수 : </label></td>
											<td><%= rentunit %></td>
										</tr>
										<tr>
											<td><label for="possibleDay">시작 날짜 : </label></td>
											<td><input id="start" type="date" name="startdate"
												placeholder="ex)20170516" /></td>
										</tr>
										<tr>
											<td><label for="possibleDay">반납 날짜 : </label></td>
											<td><input type="date" id="ren" name="enddate" onkeyPress="if ((event.keyCode<48) || (event.keyCode>57)) event.returnValue=false;" /></td>
										</tr>
										<tr>
											<td><label for="possibleDay">총 액 : </label></td>
											<td><span id="total_money">0원</span></td>
											<input type="hidden" id="hidden_total" name="total" />
										</tr>
										<tr>
											<td><label for="possibleDay">메세지 : </label></td>
											<td><textarea id="message" name="message" cols="21" rows="5"></textarea></td>
										</tr>
									</tbody>
								</table>

								<input type="submit" class="btn btn-primary btn-lg btn-block"
									value="메시지 보내기">
						</form>
						<form action="CartInsertJang" method="POST">
							<input type="hidden" name="productnumber" value="<%=y_productnumber %>" /> <input
								type="hidden" name="apple"
								value="<%=session.getAttribute("id")%>"> <input
								type="submit" class="btn btn-default btn-lg btn-block"
								value="찜하기">
						</form>
					</div>


				</div>
			</div>
			<%
		
		%>

			<!-- 판매패널 -->

		</div>
	</div>
	<!--2 img , panel row's end -->
	<div class="row">
		<br> <br>

		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-body">
					<h1>상세내역</h1>
					<table class="table">
						<thead>
							<tr>
								<th>요소</th>
								<th>내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>위치 :</td>
								<td>
								
								<%
									String loc = sel.selectLocation(y_productnumber);
									String[] locArr = loc.split(",");
									String lat = locArr[0];
									String lng = locArr[1];
								%>
					
   
    <div id="map"></div>
    <script>
      function initMap() {
          var uluru = {lat: <%= lat%>, lng: <%= lng%>};
          var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 14,
            center: uluru
          });
          var marker = new google.maps.Marker({
            position: uluru,
            map: map
          });
        }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD216mf70yKOSqZLC_KUiIPvhnXv_O7_5E&callback=initMap">
    </script>
								</td>
							</tr>
							<tr>
								<td>카카오톡 ID :</td>
								<td><%= kakaotalkid %></td>
							</tr>
							<tr>
								<td>연락처 :</td>
								<td><%= phone %></td>
							</tr>
							<tr>
								<td>물품상태 :</td>
								<td><%= productstate %></td>
							</tr>
							<tr>
								<td>상품설명 :</td>
								<td><%= productinformation %></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
		<div class="col-lg-5"></div>
	</div>

	</div>
	<div class="container-fluid">
		<h1>FOOTER SPACE</h1>
		<p>This space belong to space for FOOTER.</p>
	</div>
	<script type="text/javascript">
	$('#ren').keyup(function(){
		var to = Number($('#ren').val());
		var rent =  Number($('#rent_cost').val());
		var bo =  Number($('#bo_cost').val());
		var total =  Math.floor(Number(to*(rent/7)+bo));

		$('#hidden_total').val(total);
		$('#total_money').text(total+'원');
		$('#title_cost').html(total+'원');
	});
	$('#ren').blur(function(){
		$.ajax({
			type:"POST",
			url:"./ProductReturnTotalMoney",
			data : {
				start : $('#start').val(),
				end : $('#ren').val(),
				rent : $('#rent_cost').val(),
				depo : $('#bo_cost').val()
				},
			success:WhenSuccess,
			error:WhenError
		});
	})
function WhenSuccess(resdata){
		$('#total_money').html(resdata);
		$('#title_cost').html(resdata+"원");
}
function WhenError(){
	alert('error');
}
	
	$('#form').submit(function(){
		if($('#message').val().length == 0){
			alert('비어있음');
			$('#message').focus();
			return false;
		}
		if($('#message').val().length > 100){
			alert('100글자 이하로 작성해 주세요');
			$('#message').focus();
			return false;
		}
		if($('#start').val().length == 0){
			alert('비어있음');
			$('#start').focus();
			return false;
		}
		if($('#rentday').val().length == 0){
			alert('비어있음');
			$('#ren').focus();
			return false;
		}
		
		else{
			return true;
		}
	})
	
	</script>
</body>
</html>