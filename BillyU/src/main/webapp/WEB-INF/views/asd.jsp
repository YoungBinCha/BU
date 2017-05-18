<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
try{
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/billyu",
			"root",
			"1234"
			);
	Statement stmt = conn.createStatement();
	String sql="insert into a(a) values('a')";
	stmt.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>