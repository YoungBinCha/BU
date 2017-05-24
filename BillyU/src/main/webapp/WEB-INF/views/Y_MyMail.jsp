<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="java.sql.*" %>
    <%@ page import="rent.rentDAO" %>
    <%@ page import="rent.rentDTO" %>
    <%@ page import="sale.saleDAO" %>
    <%@ page import="sale.saleDTO" %>
    <%@ page import="mypage_reply.mypage_replyDAO" %>
    <%@ page import="mypage_reply.mypage_replyDTO" %>
    <jsp:useBean id="rent" class="rent.rentDAO" />
    <jsp:useBean id="sale" class="sale.saleDAO" />
    <jsp:useBean id="reply" class="mypage_reply.mypage_replyDAO" />
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
		String startdate = dto.getStartdate();
		int rentday = dto.getRentday();
		String message = dto.getMessage();
		int total = dto.getTotal();
		Timestamp curtime = dto.getCurtime();
		
%>
    <tr id="tr">
        <td style="width:8%"><a href="K_view?pronum=<%=pronum %>"><%=pronum %></a></td>
        <td style="width:8%"><%=rentnum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:10%"><%=startdate %>부터</td>
        <td style="width:10%"><%=rentday %>일 동안</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%"><p id="reply">답변</p>
        <div id="hidden_reply">
        <form action="Y_Reply" method="post">
        <textarea name="content" id="" cols="30" rows="10"></textarea>
        <input type="hidden" name="guest" value="<%=guest %>"/>
        <input type="hidden" name="pronum" value="<%=pronum %>"/>
        <input type="submit" value="보내기" />
        </form>
        </div>
        </td>
        <td><a href="Y_Delete_fromMail">X</a></td>
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
    <tr id="tr">
        <td style="width:8%"><a href="K_view?pronum=<%=pronum %>"><%=pronum %></a></td>
        <td style="width:8%"><%=salenum %></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:10%"><%=way %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=total %>원</td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%"><p id="reply">답변</p>
        <div id="hidden_reply">
        <form action="Y_Reply" method="post">
        <textarea name="content" id="" cols="30" rows="10"></textarea>
        <input type="hidden" name="guest" value="<%=guest %>"/>
        <input type="hidden" name="pronum" value="<%=pronum %>"/>
        <input type="submit" value="보내기" />
        </form>
        </div>
        </td>
        <td><a href="Y_Delete_fromMail">X</a></td>
    </tr>
    
    <%} %>
    </tbody>
  </table>
  </div>
  <br />
  <div class="container">          
	<h3>답변 메세지</h3>  
  	<table class="table table-striped">
    <thead>
    <tr>
        <th>상품번호</th>
        <th>받는사람</th>
        <th>보낸사람</th>
        <th>메세지</th>
        <th>날짜</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
    <%
	ArrayList<mypage_replyDTO> reply_list = reply.reply_list(nickname);
	
	for(int i=0;i<reply_list.size();i++){
		mypage_replyDTO dto = reply_list.get(i);
		int pronum = dto.getPronum();
		String hoster = dto.getHoster();
		String guest = dto.getGuest();
		String message = dto.getMessage();
		Timestamp curtime = dto.getCurtime();
%>
    <tr id="tr">
        <td style="width:8%"><a href="K_view?pronum=<%=pronum %>"><%=pronum %></a></td>
        <td style="width:8%"><%=guest %></td>
        <td style="width:8%"><%=hoster %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%"><p id="reply">답변</p>
        <div id="hidden_reply">
        <form action="Y_Reply" method="post">
        <textarea name="content" id="" cols="30" rows="10"></textarea>
        <input type="hidden" name="guest" value="<%=guest %>"/>
        <input type="hidden" name="pronum" value="<%=pronum %>"/>
        <input type="submit" value="보내기" />
        </form>
        </div>
        </td>
        <td><a href="Y_Delete_fromMail">X</a></td>
    </tr>
    
    <%} %>
    </tbody>
  </table>
  </div>
  <br />

<script>
$('#tr #hidden_reply').hide();
$('#reply').click(function(){
	$('#tr #hidden_reply').toggle();
});
</script>
</body>
</html>