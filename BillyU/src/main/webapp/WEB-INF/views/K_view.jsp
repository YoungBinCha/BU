<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
	<jsp:include page="Y_NavBar.jsp"></jsp:include>
	<%
	if(session.getAttribute("id") == null){response.sendRedirect("Y_Login");}
	int y_pronum = Integer.parseInt(request.getParameter("pronum"));
	%>
	<jsp:useBean id="sel" class="regist.registDAO"></jsp:useBean>
	<%
		ArrayList<String> al = sel.selectProduct(y_pronum);
		String type = al.get(4);
		

		ArrayList<String> al2 = sel.selectImage();
		String mimg = ""+al2.get(0);
		String img = sel.receiveImage(y_pronum);
	%>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<mark>ī�װ�</mark><h3><%= al.get(9) %></h3>
			</div>
			<div class="col-lg-3">
				<mark>�ŷ�����</mark><h3><%= type %></h3>
			</div>
			<div class="col-lg-6">
				<mark>����</mark><h3><%= al.get(0) %></h3>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-lg-7">
				<img class="img-responsive" src="<%= img %>" alt="Chania" width="600"
					height="400">	
			</div>
			<div class="col-lg-4">
			<%
			if(type.equals("�뿩")){
			%>
				<div class="panel panel-default panel-rent" data-spy="affix"
					data-offset-top="360">
					<div class="panel-heading">
					<%
						int renprice = Integer.parseInt(al.get(5));
						int deposit = Integer.parseInt(al.get(7));
					%>
						<h1 class="text-center" id="title_cost"><%= (renprice+deposit) +"��" %></h1>
						<br>
						<p class="text-center">
							<small> �뿩�� <%= renprice %>(1��) + ������ <%=deposit %> </small>
						</p>
					</div>
					<div class="panel-body">
					<form action="Y_Submit_Product" method="post">
					<input type="hidden" name="pronum" value="<%=y_pronum %>" />
					<input type="hidden" name="apple" value="<%=session.getAttribute("id")%>">
						<div class="form-group">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>���</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><label for="fee">�뿩�� : </label></td>
										<td><input type="hidden" id="rent_cost" value="<%= al.get(5) %>" /><%= al.get(5) %><small>/1��</small></td>
									</tr>
									<tr>
										<td><label for="deposit">������ : </label></td>
										<td><input type="hidden" id="bo_cost" value="<%= al.get(7) %>" /><%= al.get(7) %></td>
									</tr>
									<tr>
										<td><label for="possibleDay">�뿩���� �ϼ� : </label></td>
										<td><%= al.get(6) %></td>
									</tr>
									<tr>
										<td><label for="possibleDay">�뿩���� ��¥ : </label></td>
										<td><input type="text" name="startdate" placeholder="ex)20170516" /></td>
									</tr>
									<tr>
										<td><label for="possibleDay">��û�� �ϼ� : </label></td>
										<td><input type="number" step="1" id="ren" name="ren"/></td>
									</tr>
									<tr>
										<td><label for="possibleDay">�� �� : </label></td>
										<td><span id="total_money">0��</span></td>
										<input type="hidden" id="hidden_total" name="total" />
									</tr>
									<tr>
										<td><label for="tradeWay">�ŷ���� : </label></td>
										<td>

										<label class="radio-inline"><input
												type="radio" name="wayRadio" value="���ŷ�">���ŷ�</label>

										<label
											class="radio-inline"><input type="radio" value="�ù�"
												name="wayRadio">�ù�</label>
												</td>
									</tr>
									<tr>
										<td><label for="possibleDay">�޼��� : </label></td>
										<td><textarea name="message" cols="21" rows="5"></textarea></td>
									</tr>
								</tbody>
							</table>
							
							<input type="submit" class="btn btn-primary btn-lg btn-block" value="��û�ϱ�">
							</form>
							<form action="Y_Submit_Jang" method="POST"> 
							<input type="submit" class="btn btn-default btn-lg btn-block" value="���ϱ�">
							<input type="hidden" name="pronum" value="<%=y_pronum %>" />
							<input type="hidden" name="apple" value="<%=session.getAttribute("id")%>">
							</form>
						</div>
						
						<!-- form �� �� -->

					</div>
				</div>
			<%
		}else if(type.equals("�Ǹ�")){
			%>
				<div class="panel panel-default panel-sale" data-spy="affix"
					data-offset-top="360">
					<div class="panel-heading">
					<%
						int salprice = Integer.parseInt(al.get(8));
					%>
						<h1 class="text-center"><%= (salprice) +"��" %></h1>
						<br>
						<p class="text-center">
							<small> �Ǹűݾ� <%= salprice %></small>
						</p>
					</div>
					<div class="panel-body">
						<div class="form-group">
						<form action="Y_Submit_Sale" method="POST">
						<input type="hidden" name="pronum" value="<%=y_pronum %>" />
						<input type="hidden" name="apple" value="<%=session.getAttribute("id")%>">
						<input type="hidden" name="total" value="<%= al.get(8) %>">
						
						
							<table class="table table-hover">
								<thead>
									<tr>
										<th>���</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><label for="fee">�Ǹűݾ� : </label></td>
										<td> <%= al.get(8) %></td>
									</tr>
									<tr>
										<td><label for="possibleDay">�޼��� : </label></td>
										<td><textarea name="message" cols="21" rows="5"></textarea></td>
									</tr>
									<tr>
										<td><label for="tradeWay">�ŷ���� : </label></td>
										<td>

										<label class="radio-inline"><input
												type="radio" name="wayRadio" value="���ŷ�">���ŷ�</label>

										<label
											class="radio-inline"><input type="radio"
												name="wayRadio" value="�ù�">�ù�</label>
												</td>
									</tr>
								</tbody>
							</table>
							<input type="submit" class="btn btn-primary btn-lg btn-block" value="��û�ϱ�"> 
							</form>
							<form action="Y_Submit_Jang" method="POST"> 
							<input type="submit" class="btn btn-default btn-lg btn-block" value="���ϱ�">
							<input type="hidden" name="pronum" value="<%=y_pronum %>" />
							<input type="hidden" name="apple" value="<%=session.getAttribute("id")%>">
							</form>
						</div>
						<!-- form �� �� -->

					</div>
				</div>
			<%
		}%>
				
				<!-- �Ǹ��г� -->
				
			</div>
		</div>
		<!--2 img , panel row's end -->
		<div class="row">
			<br>
			<br>

			<div class="col-lg-7">
				<div class="panel panel-default">
					<div class="panel-body">
						<h1>�󼼳���</h1>
						<table class="table">
							<thead>
								<tr>
									<th>���</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>��ǰ���� :</td>
									<td><%= al.get(2) %></td>
								</tr>
								<tr>
									<td>��ǰ���� :</td>
									<td><%= al.get(1) %></td>
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
	$('#ren').blur(function(){
		var to = Number($('#ren').val());
		var rent =  Number($('#rent_cost').val());
		var bo =  Number($('#bo_cost').val());
		var total =  Math.floor(Number(to*(rent/7)+bo));
		
		$('#hidden_total').val(total);
		$('#total_money').text(total+'��');
		$('#title_cost').html(total+'��');
	});
	</script>
</body>
</html>