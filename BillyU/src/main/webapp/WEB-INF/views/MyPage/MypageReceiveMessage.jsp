<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="java.sql.*" %>
    <%@ page import="rent.rentDAO" %>
    <%@ page import="rent.rentDTO" %>
    <%@ page import="mypage_reply.mypage_replyDAO" %>
    <%@ page import="mypage_reply.mypage_replyDTO" %>
    <jsp:useBean id="rent" class="rent.rentDAO" />
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
		
		int rentnumber = dto.getRentnumber();
		String producthost = dto.getProducthost();
		String productguest = dto.getProductguest();
		int productnumber = dto.getProductnumber();
		String startdate = dto.getStartdate();
		String enddate = dto.getEnddate();

		String message = dto.getMessage();
		int totalprice = dto.getTotalprice();
		Timestamp curtime = dto.getCurtime();
		
%>
    <tr id="tr">
        <td style="width:8%"><a href="ProductViewPage?productnumber=<%=productnumber %>"><%=productnumber %></a></td>
        <td style="width:8%"><%=rentnumber %></td>
        <td style="width:8%"><%=productguest %></td>
        <td style="width:10%"><%=startdate %>부터</td>
        <td style="width:10%"><%=enddate %>일 동안</td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=totalprice %>원</td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%"><p id="reply">답변</p>
        <div id="hidden_reply">
        <form action="Y_Reply" method="post">
        <textarea name="content" id="" cols="30" rows="10"></textarea>
        <input type="hidden" name="guest" value="<%=productguest %>"/>
        <input type="hidden" name="pronum" value="<%=productnumber %>"/>
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
		
		int productnumber = dto.getproductnumber();
		String producthost = dto.getproducthost();
		String productguest = dto.getproductguest();
		String message = dto.getMessage();
		Timestamp curtime = dto.getCurtime();
%>
    <tr id="tr">
        <td style="width:8%"><a href="K_view?pronum=<%=productnumber %>"><%=productnumber %></a></td>
        <td style="width:8%"><%=productguest %></td>
        <td style="width:8%"><%=producthost %></td>
        <td style="width:40%"><%=message %></td>
        <td style="width:10%"><%=curtime %></td>
        <td style="width:10%"><p id="reply">답변</p>
        <div id="hidden_reply">
        <form action="Y_Reply" method="post">
        <textarea name="content" id="" cols="30" rows="10"></textarea>
        <input type="hidden" name="guest" value="<%=productguest %>"/>
        <input type="hidden" name="pronum" value="<%=productnumber %>"/>
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