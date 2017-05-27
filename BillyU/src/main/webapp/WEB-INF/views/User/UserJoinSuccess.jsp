<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String kakao = request.getParameter("kakaoid");
String nickname = request.getParameter("nickname");

Class.forName("com.mysql.jdbc.Driver");
try{
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/BillyU",
			"root",
			"1234");
	Statement stmt = conn.createStatement();
	String sql="insert into user values('"+nickname+"','"+kakao+"')";
	stmt.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}
session.setAttribute("id", nickname);
response.sendRedirect("Index");
%>
</body>
</html>