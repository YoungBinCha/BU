<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("euc-kr");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="sale" class="sale.saleDAO" />
<%
Object apple = request.getParameter("apple");
String guest = apple.toString();

int pronum = Integer.parseInt(request.getParameter("pronum"));
String way = request.getParameter("wayRadio");
String message = request.getParameter("message");
int total=Integer.parseInt(request.getParameter("total"));

sale.insert_sale(guest, pronum, way, message, total);
response.sendRedirect("Y_Sale?pronum="+pronum+"");
%>
</body>
</html>