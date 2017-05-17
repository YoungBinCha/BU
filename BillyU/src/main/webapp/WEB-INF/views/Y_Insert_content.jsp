<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" import="java.util.*" import="java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM월-"+"dd일-"+"HH시-"+"mm분-"+"ss초");
String today = formatter.format(new java.util.Date());

out.println(today);
String content = request.getParameter("content");

Class.forName("com.mysql.jdbc.Driver");
try{
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/BillyU",
			"root",
			"1234");
	Statement stmt = conn.createStatement();
	String sql="insert into chat values('"+content+"("+today+")')";
	stmt.executeUpdate(sql);
	

}catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>