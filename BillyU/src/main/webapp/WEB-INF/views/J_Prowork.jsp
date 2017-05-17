<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("euc-kr");
String cate = request.getParameter("J_category");
String ti = request.getParameter("J_r_title");
String jrent =request.getParameter("J_rent");
String jdepo =request.getParameter("J_deposit");
String comment = request.getParameter("J_comment");


Class.forName("com.mysql.jdbc.Driver");
try{
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/BillyU", "root", "1234");
	
	Statement stmt = conn.createStatement();
	
	String sql = "insert into product (nickname,categoryname,title,imagline,productinfo) values ('kim','"+cate+"','"+ti+"','qweqwe','"+comment+"')";
	String ret = "insert into rental (productnum,rentalfee,deposit) values (6,'"+jrent+"','"+jdepo+"')";
	
	stmt.executeUpdate(sql);
	stmt.executeUpdate(ret);
	stmt.close();
	conn.close();
	
	out.println("MySql jdbc test: connect ok!!");
}catch(SQLException ex){
	out.println(ex.getMessage());
}

%>
</body>
</html>