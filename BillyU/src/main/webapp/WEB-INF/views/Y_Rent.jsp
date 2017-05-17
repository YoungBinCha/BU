<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("euc-kr");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rent" class="rent.rentDAO" />
<%
	int pronum = Integer.parseInt(request.getParameter("pronum"));
	Object id = session.getAttribute("id");
	String guest = id.toString();
	String nickname = rent.select_rent(pronum);
	
	rent.insert_nickname(nickname, guest, pronum);
%>
<script type="text/javascript">
alert("신청이 완료 되었습니다.");
history.go(-2);
</script>
</body>
</html>