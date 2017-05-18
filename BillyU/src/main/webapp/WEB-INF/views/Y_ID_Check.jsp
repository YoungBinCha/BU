<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	String nickname = request.getParameter("nickname");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String str="";
	
	Class.forName("com.mysql.jdbc.Driver");
	try{
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/billyu",
				"root",
				"1234"
				);
		stmt = conn.createStatement();
		String sql="select * from user";
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			if(nickname.equals(rs.getString("nickname")))
			{
				str="YES";
				out.print(str);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		rs.close();
		stmt.close();
		conn.close();
	}
%>
</body>
</html>