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
        <th>수여자</th>
        <th>거래방식</th>
        <th>시작일</th>
        <th>대여기간</th>
        <th>메세지</th>
        <th>총액</th>
        <th>날짜</th>
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
		Timestamp curtime = dto.getCurtime();
		
%>
    <tr>
        <td style="width:8%"><a href="K_view?pronum=<%=pronum %>"><%=pronum %></a></td>
        <td style="width:8%"><%=rentnum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:10%"><%=startdate %>부터</td>
        <td style="width:10%"><%=rentday %>일 동안</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%">
        <button style="width:80px;text-align:center" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">답변</button>
        </td>
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
        <th>수여자</th>
        <th>거래방식</th>
        <th>메세지</th>
        <th>총액</th>
        <th>날짜</th>
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
		Timestamp curtime = dto.getCurtime();
%>
    <tr>
        <td style="width:8%"><a href="K_view?pronum=<%=pronum %>"><%=pronum %></a></td>
        <td style="width:8%"><%=salenum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%">
        <a id="reple" data-toggle="popover" title="Popover Header" data-content="Some content inside the popover">답변</a>
        <form action="Y_Reply" method="post" id="myform" style="display:none">
          <textarea name="content" id="" cols="30" rows="10"></textarea>
          <input type="hidden" name="guest" value="<%=guest%>"/>
          <input type="hidden" name="pronum" value="<%=pronum%>"/>
          <input type="submit" value="전송"/>
        </form>
        </td>
    </tr>
    
    <%} %>
    </tbody>
  </table>
  <br />
    <h2>답변 메세지</h2>
</div>
  <!-- Modal -->
<div class="modal fade" id="myModal" role="dialog"><div class="modal-dialog modal-lg"><div class="modal-content">
<div class="modal-header"><button type="button" class="close" data-dismiss="modal">&times;</button><h4 class="modal-title">메세지</h4></div>
        <div class="modal-body">
          <form action="Y_Reply" method="post">
          <textarea name="content" id="" cols="30" rows="10"></textarea>
          <input type="text" name="guest" value="<%=11%>"/>
          <input type="text" name="pronum" value="<%=11%>"/>
          <input type="submit" value="전송"/>
          </form>
        </div>
<div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></div>
</div></div></div>
</body>
</html>