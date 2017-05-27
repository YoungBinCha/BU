<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$(".K_trade").hide();

		$(".input").click(function() {
			$(".product").toggle();
			$(".K_trade").toggle(500);
			$(this).html($(this).html() == '다음' ? '이전' : '다음');
		});

		//대여 버튼 누르면 tratype의 value값이 rent로
		$('.re').click(function() {
			$('.tratype').val("대여");
		});
		//판매 버튼 누르면 tratype의 value값이 sale로 ,,
		$('.sa').click(function() {
			$('.tratype').val("판매");
		});
	});
</script>
<style type="text/css">
/*nav바와 상품등록 간격 줄이기*/
#page-content-wrapper{
		padding-top: 20px !important;
	}
</style>
</head>
<body>
	<jsp:include page="Y_NavBar.jsp"></jsp:include>
	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="K_productRegist">
					<center><h1>상품 정보 입력</h1></center><br />
					<form action="regist.do" method="post">
						<div class="product">
							<div class="form-group">
								<label for="title">제목 : </label> <input type="text"
									class="form-control" id="title" name="title"
									placeholder="Enter title">
							</div>
							<div class="form-group">
								<label for="category">대분류:</label> <select class="form-control"
									id="category">
									 <%-- <jsp:useBean id="sel"
										class="com.openmarket.Capstone_productDAO"></jsp:useBean>  --%>
										 <jsp:useBean id="select"
										class="regist.registDAO"></jsp:useBean> 
										<option>대분류를 선택해 주세요</option>
									<%
										ArrayList<String> al = select.selectCategory();
										for (int i = 0; i < al.size(); i++) {
									%>
									
									<option><%=al.get(i)%></option>
									<%
										}
									%>
								</select>
								<br />
								<label for="category">소분류:</label>
								 <select class="form-control" id="category2" name="category">
									<option value="">대분류를 선택해주세요</option>
								</select>
								<script>
								$('#category').change(function(){
									$.ajax({
										type : "POST",
										url : "./Y_ReturnCategory",
										data : {cate : $('#category').val()},
										success : WhenSuccess,
										error : WhenError
									});
								});
								function WhenSuccess(resdata){
									$('#category2').html(resdata);
								}

								function WhenError(){
									alert('error');
								}
								
								</script>
							</div>
							<div class="form-group">
								<label for="productstate">상품상태 :</label> <label
									class="radio-inline"> <input type="radio"
									name="productstate" value="s급">S급
								</label> <label class="radio-inline"> <input type="radio"
									name="productstate" value="a급">A급
								</label> <label class="radio-inline"> <input type="radio"
									name="productstate" value="b급">B급
								</label>
							</div>
							<div class="form-group">
								<label for="location">위치: </label> <input type="text"
									class="form-control" id="location" name="location"
									placeholder="Enter location">
							</div>
							<div class="form-group">
								<!--  이건 text가 아니라 다른 형식으로받는건 어떨까? -->
								<label for="productinformation">상품설명</label>
								<textarea class="form-control" rows="5" id="productinformation"
									placeholder="Input info" name="productinformation"></textarea>
							</div>

						</div>
						<!-- 여기부턴 대여 정보 입력 -->
						<div class="K_trade">
								<div class="form-group">
									<input class="tratype" type="hidden" name="tratype" value="대여" />
								</div>
								<div id="rent" class="re tab-pane fade in active">
									<h3>대여</h3>

									<div class="form-group">
										<label for="rentprice">대여금액 : </label> <input type="text"
											class="form-control" id="rentprice" name="rentprice"
											placeholder="Enter rentalFee">
									</div>
									<div class="form-group">
										<label for="rentdeposite">보증금 :</label> <input type="text"
											class="form-control" id="rentdeposit" name="rentdeposite"
											placeholder="Enter rentdeposit">
									</div>
									<div class="form-group">
										<label for="rentunit">대여가능일수 :</label> <input type="text"
											class="form-control" id="rentunit" name="rentunit"
											placeholder="Enter rentunit">
									</div>
									<button type="submit" class="submit btn btn-default btn-block">Submit</button>
								</div>
							</div>
							<!-- 거래 형식을 '판매'를 선택했을 때 -->		
						</div>
					</form>
					<button type="button" class="input btn btn-primary btn-block">다음</button>
				</div>
			</div>
			<div class="col-lg-3"></div>
			
		</div>
	</div>
	</div>
	<br />
	<br />
	<br />
</body>
</html>