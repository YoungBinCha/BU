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
String productguest = apple.toString();

int productnumber = Integer.parseInt(request.getParameter("productnumber"));
String message = request.getParameter("message");
String startdate=request.getParameter("startdate");
String enddate = request.getParameter("enddate");
int totalprice=Integer.parseInt(request.getParameter("total"));

rent.insert_rent(productguest, productnumber, message, startdate, enddate, totalprice);
response.sendRedirect("RentInsertHost?pronum="+productnumber+"");
%>
</body>
</html>