<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.text.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String start = request.getParameter("start");
	String end = request.getParameter("end");
	int rent = Integer.parseInt(request.getParameter("rent"));
	int depo = Integer.parseInt(request.getParameter("depo"));
	
	try{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
    Date beginDate = formatter.parse(start);
    Date endDate = formatter.parse(end);
     
    // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
    long diff = endDate.getTime() - beginDate.getTime();
    long diffDays = diff / (24 * 60 * 60 * 1000) +1;
    
    long result = diffDays*rent+depo;
    
    out.println(result);
    
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>