<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*" import="java.sql.*" %>
    <%@ page import="rent.rentDAO" %>
    <%@ page import="rent.rentDTO" %>
    <%@ page import="sale.saleDAO" %>
    <%@ page import="sale.saleDTO" %>
    <jsp:useBean id="rent" class="rent.rentDAO" />
    <jsp:useBean id="sale" class="sale.saleDAO" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>대기중인 상품</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
        <h2>�뿩</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>��ǰ��ȣ</th>
        <th>�뿩��ȣ</th>
        <th>������</th>
        <th>�ŷ����</th>
        <th>�뿩���۳�¥</th>
        <th>���ϵ���</th>
        <th>�޼���</th>
        <th>�ѱݾ�</th>
        <th>��¥</th>
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
        <td style="width:10%"><%=startdate %>����</td>
        <td style="width:10%"><%=rentday %>�ϵ���</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:12%"><%=total %>��</td>
        <td style="width:8%"><%=curtime %></td>
    </tr>
    <%} %>
    </tbody>
  </table>

</div>


<div class="container">
        <h2>�Ǹ�</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>��ǰ��ȣ</th>
        <th>�ǸŹ�ȣ</th>
        <th>������</th>
        <th>�ŷ����</th>
        <th>�޼���</th>
        <th>�ѱݾ�</th>
        <th>��¥</th>
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
        <td style="width:12%"><%=total %>��</td>
        <td style="width:8%"><%=curtime %></td>
    </tr>
    <%} %>
    </tbody>
  </table>

</div>
</body>
</html>