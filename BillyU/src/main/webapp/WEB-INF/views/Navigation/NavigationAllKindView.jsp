<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="DAO" class="category.cateDAO" />
<%@ page import="category.cateDTO" %>
<%@ page import="category.cateDAO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.Y_All_Container{
width:70%;
}
.Y_All_Block{
width:100%;
height:100%;
background-color:white;
}
.Y_Nav_TopMenu{
background-color:gray;
}
.Y_Nav_Menu_Content a{
text-decoration: none;
color:black;
}
.Y_Nav_Menu_Content a:hover{
color:blue;
}
.Y_NavCategory_Table{
width:100%;
}
.Y_rowspan{
background-color:#f3f3f3;
}
</style>
</head>
<body>
<center>
<div class="Y_All_Container">
<div class="Y_All_Block">
<table class="Y_NavCategory_Table table table-bordered">
<tr class="Y_Nav_TopMenu">
<%
	ArrayList<cateDTO> categorybig_list = DAO.categorybig_list();
	ArrayList<cateDTO> categorysmall_list = DAO.categorysmall_list();
	
	for(int i=0;i<categorybig_list.size();i++){
		cateDTO dto = categorybig_list.get(i);
		String categorybig = dto.getcategorybig();
		
	}

%>

<th>의류</th><th>잡화</th><th>유아동</th><th>식품</th>
<th>생필품</th><th>홈데코</th><th>건강</th><th>문구</th>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">여성의류</a></td>
<td><a href="#">신발</a></td>
<td><a href="#">기저귀</a></td>
<td><a href="#">신선식품</a></td>
<td><a href="#">세제/구강</a></td>
<td><a href="#">가구/DIY</a></td>
<td><a href="#">건강/의료용품</a></td>
<td><a href="#">문구/사무용품</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">남성의류</a></td>
<td><a href="#">가방</a></td>
<td><a href="#">분유/유아식</a></td>
<td><a href="#">가공식품</a></td>
<td><a href="#">화장지/물티슈</a></td>
<td><a href="#">침구/커튼</a></td>
<td><a href="#">건강식품</a></td>
<td><a href="#">사무기기</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">언더웨어</a></td>
<td><a href="#">유아동신발</a></td>
<td><a href="#">육아용품</a></td>
<td><a href="#">커피/음료</a></td>
<td><a href="#">여성용품</a></td>
<td><a href="#">조명/인테리어</a></td>
<td><a href="#">운동용품</a></td>
<td><a href="#">악기/수집</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">유아동의류</a></td>
<td><a href="#">쥬얼리/시계</a></td>
<td><a href="#">브랜드아동패션</a></td>
<td class="Y_rowspan" rowspan="3"></td>
<td><a href="#">바디/헤어</a></td>
<td><a href="#">생활용품</a></td>
<td class="Y_rowspan" rowspan="3"></td>
<td><a href="#">반려동물용품</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td class="Y_rowspan" rowspan="2"></td>
<td><a href="#">화장품/향수</a></td>
<td class="Y_rowspan" rowspan="2"></td>
<td class="Y_rowspan" rowspan="2"></td>
<td><a href="#">주방용품</a></td>
<td class="Y_rowspan" rowspan="2"></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td class="Y_rowspan"></td>
<td><a href="#">꽃/이벤트</a></td>
</tr>

<tr class="Y_Nav_TopMenu">
<th>스포츠</th><th>자동차</th><th>가전</th><th>디지털</th>
<th>컴퓨터</th><th>도서</th><th>여행</th><th>티켓</th>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">스포츠의류</a></td>
<td><a href="#">자동차부품</a></td>
<td><a href="#">대형가전</a></td>
<td><a href="#">휴대폰</a></td>
<td><a href="#">노트북/PC</a></td>
<td><a href="#">도서/음반</a></td>
<td><a href="#">여행</a></td>
<td><a href="#">티켓</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">운동화</a></td>
<td><a href="#">타이어/부품</a></td>
<td><a href="#">주방가전</a></td>
<td><a href="#">카메라</a></td>
<td><a href="#">모니터/프린터</a></td>
<td><a href="#">e교육</a></td>
<td><a href="#">항공권</a></td>
<td><a href="#">e쿠폰</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">휘트니스/수영</a></td>
<td><a href="#">공구설비/자재</a></td>
<td><a href="#">계절가전</a></td>
<td><a href="#">태블릿</a></td>
<td><a href="#">PC주변기기</a></td>
<td class="Y_rowspan" rowspan="6"></td>
<td class="Y_rowspan" rowspan="6"></td>
<td><a href="#">상품권</a></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">구기/라켓</a></td>
<td class="Y_rowspan" rowspan="5"></td>
<td><a href="#">생활/미용가전</a></td>
<td><a href="#">게임</a></td>
<td><a href="#">저장장치</a></td>
<td class="Y_rowspan" rowspan="5"></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">골프</a></td>
<td><a href="#">음향가전</a></td>
<td><a href="#">음향기기</a></td>
<td class="Y_rowspan" rowspan="4"></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">자전거/보드</a></td>
<td><a href="#">건강가전</a></td>
<td class="Y_rowspan" rowspan="3"></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">캠핑/낚시</a></td>
<td class="Y_rowspan" rowspan="2"></td>
</tr>

<tr class="Y_Nav_Menu_Content">
<td><a href="#">등산</a></td>
</tr>
<script>
$('a').click(function(){
	var th = $(this).text();
	$('a').attr('href','Y_Search_Result?category=all&search='+th+'');
})
</script>
</table>
</div>
</div>
</center>
</body>
</html>