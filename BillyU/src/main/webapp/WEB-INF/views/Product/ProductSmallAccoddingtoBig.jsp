<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="category" class="regist.registDAO" />
<%
	String cate = request.getParameter("cate");

	ArrayList<String> al = category.selectCategory2(cate);
	for (int i = 0; i < al.size(); i++) {
	%>
	<option><%=al.get(i)%></option>
	<%
	}
%>
</body>
</html>