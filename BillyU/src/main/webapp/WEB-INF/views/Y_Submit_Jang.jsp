<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    <%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="jang" class="jang.jangDAO" />
<%
Object apple = request.getParameter("apple");
String guest = apple.toString();

int pronum = Integer.parseInt(request.getParameter("pronum"));

jang.insert_jang(guest, pronum);
response.sendRedirect("Y_MyPage");
%>
</body>
</html>