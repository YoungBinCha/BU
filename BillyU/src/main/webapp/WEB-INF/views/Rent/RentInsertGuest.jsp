<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" 
    import="java.text.*" import="java.lang.*" 
    import="java.sql.*"%>
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
int rentprice = Integer.parseInt(request.getParameter("rentprice"));
int rentdeposite = Integer.parseInt(request.getParameter("rentdeposite"));

int totalprice = 0;

try{
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

Date beginDate = formatter.parse(startdate);
Date endDate = formatter.parse(enddate);
 
// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
long diff = endDate.getTime() - beginDate.getTime();
long diffDays = diff / (24 * 60 * 60 * 1000) +1;

totalprice = rentprice*(int)diffDays+rentdeposite;
}catch(Exception e){e.printStackTrace();}


rent.insert_rent(productguest, productnumber, message, startdate, enddate, totalprice);
response.sendRedirect("RentInsertHost?pronum="+productnumber+"");
%>
</body>
</html>