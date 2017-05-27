<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
#sub{
	display:none;
}
</style>
</head>
<body>
<jsp:useBean id="user" class="user.userDAO" />
<h1>닉네임 1글자 이상 10글자 이하로 만들어 주세요!</h1>
<%
	String kakao = request.getParameter("kakaoid");
	boolean check_kakao = user.kakaoid_check(kakao);

	if(check_kakao == false){
		response.sendRedirect("UserLoginForm");
	}
%>
<form method="post" action="UserJoinSuccess" name="name" id="form_check">
닉네임 : <input type="text" name="nickname" id="nick" placeholder="1글자 이상 10글자 이하" />
<input type="hidden" name="kakaoid" value="<%=kakao %>"/>
<input type="button" value="회원가입" id="sub" onclick="check()"/><p>
<div id="view"></div>
<div id="valview"></div>
</form>
<script type="text/javascript">
function check(){
	var first = $('#nick').val();
	var leng = first.length;
	if($('#nick').val().trim() == "")
		{
		alert('공백은 사용하실 수 없습니다.');
		return $('#nick').focus();
		}
	if(leng > 10)
		{
		alert('10글자 이상은 사용하실 수 없습니다.');
		$('#nick').val("");
		return $('#nick').focus();
		}
	else
		{
	$('#form_check').submit();
		}
}

$('#nick').keyup(function(){

	$.ajax({
		type:"POST",
		url:"./UserCheckID",
		data : {nickname : $('#nick').val() },
		success:WhenSuccess,
		error:WhenError
	});
});

function WhenSuccess(resdata){
		$('#view').html(resdata);
		$('#view').hide();
		var a = $('#view').text().trim();
		var check = false;
		if(a == "YES")
			{
			$('#valview').html("<span style='color:red'>사용중인 닉네임 입니다.</span>");
			check = false;
			}
		else{
			$('#valview').html("<span style='color:green'>사용하지 않은 닉네임 입니다.</span>");
			check = true;
		}
		if(check == false)
			{
			$('#sub').css('display','none');
			}
		if(check == true)
			{
			$('#sub').css('display','inline');
			}
		
}

function WhenError(){
	alert('error');
}
</script>
</body>
</html>