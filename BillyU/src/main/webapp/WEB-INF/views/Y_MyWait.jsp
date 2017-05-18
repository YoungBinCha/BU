<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="java.sql.*" %>
    <%@ page import="rent.rentDAO" %>
    <%@ page import="rent.rentDTO" %>
    <%@ page import="sale.saleDAO" %>
    <%@ page import="sale.saleDTO" %>
    <jsp:useBean id="rent" class="rent.rentDAO" />
    <jsp:useBean id="sale" class="sale.saleDAO" />
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>마이페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
        <h2>대여</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>대여번호</th>
        <th>공여자</th>
        <th>거래방식</th>
        <th>시작일</th>
        <th>대여기간</th>
        <th>메세지</th>
        <th>총액</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
<%
	Object id = session.getAttribute("id");
	String nickname = id.toString();

	ArrayList<rentDTO> rent_list = rent.rent_list2(nickname);
	
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
		Timestamp curtime = dto.getCurtime();
%>
    <tr>
        <td style="width:8%"><%=pronum %></td>
        <td style="width:8%"><%=rentnum %></td>
        <td style="width:8%"><%=hoster %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:10%"><%=startdate %>부터</td>
        <td style="width:10%"><%=rentday %>일 동안</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:12%"><%=total %>원</td>
        <td style="width:8%"><%=curtime %></td>
    </tr>
    <%} %>
    </tbody>
  </table>

</div>


<div class="container">
        <h2>판매</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>판매번호</th>
        <th>공여자</th>
        <th>거래방식</th>
        <th>메세지</th>
        <th>총액</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
<%


	ArrayList<saleDTO> sale_list = sale.sale_list2(nickname);
	
	for(int i=0;i<sale_list.size();i++){
		saleDTO dto = sale_list.get(i);
		int salenum = dto.getSalenum();
		String hoster = dto.getHoster();
		String guest = dto.getGuest();
		int pronum = dto.getPronum();
		String way = dto.getWay();
		String message = dto.getMessage();
		int total = dto.getTotal();
		Timestamp curtime = dto.getCurtime();
%>
    <tr>
        <td style="width:8%"><%=pronum %></td>
        <td style="width:8%"><%=salenum %></td>
        <td style="width:8%"><%=hoster %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:12%"><%=total %>원</td>
        <td style="width:8%"><%=curtime %></td>
    </tr>
    <%} %>
    </tbody>
  </table>

</div>
</body>
</html>