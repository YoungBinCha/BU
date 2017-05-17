<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*" %>
    <%@ page import="rent.rentDAO" %>
    <%@ page import="rent.rentDTO" %>
    <%@ page import="sale.saleDAO" %>
    <%@ page import="sale.saleDTO" %>
    <jsp:useBean id="rent" class="rent.rentDAO" />
    <jsp:useBean id="sale" class="sale.saleDAO" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>나에게 온메일</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>내가 올린 상품에 대한 메세지</h2>
<div class="container">          
<h3>대여</h3>  
  <table class="table table-striped">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>대여번호</th>
        <th>신청자</th>
        <th>거래방식</th>
        <th>대여시작날짜</th>
        <th>몇일동안</th>
        <th>메세지</th>
        <th>총금액</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
    <%
	Object id = session.getAttribute("id");
	String nickname = id.toString();

	ArrayList<rentDTO> rent_list = rent.rent_list(nickname);
	
	for(int i=0;i<rent_list.size();i++){
		rentDTO dto = rent_list.get(i);
		int rentnum = dto.getRentnum();
		String hoster = dto.getHoster();
		String guest = dto.getGuest();
		int pronum = dto.getPronum();
		String way = dto.getWay();
		int startdate = dto.getStartdate();
		int rentday = dto.getRentday();
		String message = dto.getMessage();
		int total = dto.getTotal();
		
%>
    <tr>
        <td style="width:8%"><%=pronum %></td>
        <td style="width:8%"><%=rentnum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:10%"><%=startdate %>부터</td>
        <td style="width:10%"><%=rentday %>일동안</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%">답변</td>
    </tr>
    <%} %>
    </tbody>
  </table>
  <br />
</div>
<div class="container">          
<h3>판매</h3>  
  <table class="table table-striped">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>판매번호</th>
        <th>신청자</th>
        <th>거래방식</th>
        <th>메세지</th>
        <th>총금액</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
    <%
	ArrayList<saleDTO> sale_list = sale.sale_list(nickname);
	
	for(int i=0;i<sale_list.size();i++){
		saleDTO dto = sale_list.get(i);
		int salenum = dto.getSalenum();
		String hoster = dto.getHoster();
		String guest = dto.getGuest();
		int pronum = dto.getPronum();
		String way = dto.getWay();
		String message = dto.getMessage();
		int total = dto.getTotal();
%>
    <tr>
        <td style="width:8%"><%=pronum %></td>
        <td style="width:8%"><%=salenum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%">답변</td>
    </tr>
    <%} %>
    </tbody>
  </table>
  <br />
    <h2>내가 신청한 메세지에 대한 답변</h2>
</div>

</body>
</html>