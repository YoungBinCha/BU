<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rent" class="rent.rentDAO" />
<%
Object apple = request.getParameter("apple");
String guest = apple.toString();

int pronum = Integer.parseInt(request.getParameter("pronum"));
String way = request.getParameter("wayRadio");
String message = request.getParameter("message");
int startdate=Integer.parseInt(request.getParameter("startdate"));
int rentday=Integer.parseInt(request.getParameter("ren"));
int total=Integer.parseInt(request.getParameter("total"));

out.println(guest+"<br />");
out.println(pronum+"<br />");
out.println(way+"<br />");
out.println(message+"<br />");
out.println(startdate+"<br />");
out.println(rentday+"<br />");
out.println(total+"<br />");


rent.insert_rent(guest, pronum, message, way, startdate, rentday, total);
response.sendRedirect("Y_Rent?pronum="+pronum+"");
%>
</body>
</html>