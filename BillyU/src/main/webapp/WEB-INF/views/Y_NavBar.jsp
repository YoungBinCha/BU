<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- 로그인창 팝업 뛰우기 위함 -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<style>
@media screen and (max-width: 1200px) {
  .Y_NavSearch {
    width: 60%;
  }
  .Y_NavLogo, .Y_NavAD {
    width: 20%;
  }
  #Y_NavContent_Left_Up{
  display:none;
  }
  #Y_NavContent_Left_Down{
  display:none;
  }
  .Y_NavSelect{
  display:none;
  }
}

@media screen and (max-width: 700px) {
  .Y_NavSearch {
    width: 80%;
  }
  .Y_NavAD {
    width: 20%;
  }
  .Y_NavLogo{
  display:none;
  }
  
}

.Y_NavBody {
  margin: 0px;
}

.Y_NavTop {
  width: 70%;
  height: 80px;
  maring: 0 auto;
  overflow: auto;
  margin-left: 50px;
}

.Y_NavTable {
  width: 100%;
  margin-top: 10px;
}

.Y_NavLogo {
  width: 15%;
  height: 65px;
}

.Y_NavSearch {
  width: 50%;
  height: 65px;
}

.Y_NavAD {
  width: 30%;
  height: 65px;
}

.Y_NavBlank {
  width: 5%;
}

.Y_NavBottom {
  width: 100%;
  height: 50px;
  border-top: 1px solid #D8D8D8;
  border-bottom: 2px solid blue;
  margin: 0;
}

.Y_SearchBar {
  width: 100%;
  box-sizing: border-box;
  border: 3px solid #2E2EFE;
  border-radius: 6px;
  font-size: 16px;
  background-color: white;
  padding: 12px 20px 12px 5px;
}

.Y_NavSelect {
  width: 100px;
  box-sizing: border-box;
  padding: 12px 20px 12px 5px;
  font-family: inherit;
  border-radius: 6px;
  font-size: 16px;
  background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%;
  border: 3px solid #2E2EFE;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  margin-left: 5px;
  margin-top: 6px;
}

.Y_SearchButton {
  width: 80px;
  box-sizing: border-box;
  padding: 12px 5px;
  font-family: inherit;
  border-radius: 6px;
  font-size: 16px;
  border: 3px solid #2E2EFE;
  margin-top: 6px;
}

.Y_NavTopButton {
  position: fixed;
  right: 25px;
  bottom: 20px;
  display: none;
}

.Y_NavContent {
  width: 70%;
  height: 100%;
}

#Y_NavContent_Left_Down {
  border: 0;
  outline: 0;
  background-color: white;
  height: 45px;
  border-left: 1px solid #D8D8D8;
  border-right: 1px solid #D8D8D8;
}

#Y_NavContent_Left_Up {
  display: none;
  border: 0;
  outline: 0;
  background-color: white;
  height: 45px;
  border-left: 1px solid #D8D8D8;
  border-right: 1px solid #D8D8D8;
}

#Y_NavContent_Right {
  height: 45px;
}

#Y_All_Back {
  width: 100%;
  height: 100%;
  display: none;
  overflow: auto;
}

#myNavbar {
  position: absolute;
  right: 10px;
}

@import "http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css";
@import "https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css";
@import "https://daneden.github.io/animate.css/animate.min.css";
/*-------------------------------*/
/*           VARIABLES           */
/*-------------------------------*/
.nav .open > a {
  background-color: transparent;
}
.nav .open > a:hover {
  background-color: transparent;
}
.nav .open > a:focus {
  background-color: transparent;
}
/*-------------------------------*/
/*           Wrappers            */
/*-------------------------------*/
#wrapper {
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  padding-left: 0;
  transition: all 0.5s ease;
}
#wrapper.toggled {
  padding-left: 220px;
}
#wrapper.toggled #sidebar-wrapper {
  width: 220px;
}
#wrapper.toggled #page-content-wrapper {
  margin-right: -220px;
  position: absolute;
}
#sidebar-wrapper {
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  background: #1a1a1a;
  height: 100%;
  left: 220px;
  margin-left: -220px;
  overflow-x: hidden;
  overflow-y: auto;
  transition: all 0.5s ease;
  width: 0;
  z-index: 1000;
}
#sidebar-wrapper::-webkit-scrollbar {
  display: none;
}
#page-content-wrapper {
  padding-top: 70px;
  width: 100%;
}
/*-------------------------------*/
/*     Sidebar nav styles        */
/*-------------------------------*/
.sidebar-nav {
  list-style: none;
  margin: 0;
  padding: 0;
  position: absolute;
  top: 0;
  width: 220px;
}
.sidebar-nav li {
  display: inline-block;
  line-height: 20px;
  position: relative;
  width: 100%;
}
.sidebar-nav li:before {
  background-color: #1c1c1c;
  content: '';
  height: 100%;
  left: 0;
  position: absolute;
  top: 0;
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 3px;
  z-index: -1;
}
.sidebar-nav li:first-child a {
  background-color: #1a1a1a;
  color: #ffffff;
}
.sidebar-nav li:nth-child(2):before {
  background-color: #402d5c;
}
.sidebar-nav li:nth-child(3):before {
  background-color: #4c366d;
}
.sidebar-nav li:nth-child(4):before {
  background-color: #583e7e;
}
.sidebar-nav li:nth-child(5):before {
  background-color: #64468f;
}
.sidebar-nav li:nth-child(6):before {
  background-color: #704fa0;
}
.sidebar-nav li:nth-child(7):before {
  background-color: #7c5aae;
}
.sidebar-nav li:nth-child(8):before {
  background-color: #8a6cb6;
}
.sidebar-nav li:nth-child(9):before {
  background-color: #987dbf;
}
.sidebar-nav li:hover:before {
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 100%;
}
.sidebar-nav li a {
  color: #dddddd;
  display: block;
  padding: 10px 15px 10px 30px;
  text-decoration: none;
}
.sidebar-nav li.open:hover before {
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 100%;
}
.sidebar-nav .dropdown-menu {
  background-color: #222222;
  border-radius: 0;
  border: none;
  box-shadow: none;
  margin: 0;
  padding: 0;
  position: relative;
  width: 100%;
}
.sidebar-nav li a:hover,
.sidebar-nav li a:active,
.sidebar-nav li a:focus,
.sidebar-nav li.open a:hover,
.sidebar-nav li.open a:active,
.sidebar-nav li.open a:focus {
  background-color: transparent;
  color: black;
  text-decoration: none;
}
.sidebar-nav > .sidebar-brand {
  font-size: 20px;
  height: 65px;
  line-height: 44px;
}
/*-------------------------------*/
/*       Hamburger-Cross         */
/*-------------------------------*/
.hamburger {
  background: transparent;
  border: none;
  display: block;
  height: 32px;
  margin-top:200px;
  margin-left: 15px;
  position: fixed;
  top: 20px;
  width: 32px;
  z-index: 999;
}
.hamburger:hover {
  outline: none;
}
.hamburger:focus {
  outline: none;
}
.hamburger:active {
  outline: none;
}
.hamburger.is-closed:before {
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  color: black;
  content: '';
  display: block;
  font-size: 14px;
  line-height: 32px;
  opacity: 0;
  text-align: center;
  width: 100px;
}
.hamburger.is-closed:hover before {
  -webkit-transform: translate3d(-100px, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  display: block;
  opacity: 1;
}
.hamburger.is-closed:hover .hamb-top {
  -webkit-transition: all 0.35s ease-in-out;
  top: 0;
}
.hamburger.is-closed:hover .hamb-bottom {
  -webkit-transition: all 0.35s ease-in-out;
  bottom: 0;
}
.hamburger.is-closed .hamb-top {
  -webkit-transition: all 0.35s ease-in-out;
  background-color: black;
  top: 5px;
}
.hamburger.is-closed .hamb-middle {
  background-color: black;
  margin-top: -2px;
  top: 50%;
}
.hamburger.is-closed .hamb-bottom {
  -webkit-transition: all 0.35s ease-in-out;
  background-color: black;
  bottom: 5px;
}
.hamburger.is-closed .hamb-top,
.hamburger.is-closed .hamb-middle,
.hamburger.is-closed .hamb-bottom,
.hamburger.is-open .hamb-top,
.hamburger.is-open .hamb-middle,
.hamburger.is-open .hamb-bottom {
  height: 4px;
  left: 0;
  position: absolute;
  width: 100%;
}
.hamburger.is-open .hamb-top {
  -webkit-transform: rotate(45deg);
  -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
  background-color: black;
  margin-top: -2px;
  top: 50%;
}
.hamburger.is-open .hamb-middle {
  background-color: black;
  display: none;
}
.hamburger.is-open .hamb-bottom {
  -webkit-transform: rotate(-45deg);
  -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
  background-color: black;
  margin-top: -2px;
  top: 50%;
}
.hamburger.is-open:before {
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  color: black;
  content: '';
  display: block;
  font-size: 14px;
  line-height: 32px;
  opacity: 0;
  text-align: center;
  width: 100px;
}
.hamburger.is-open:hover before {
  -webkit-transform: translate3d(-100px, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  display: block;
  opacity: 1;
}
/*-------------------------------*/
/*          Dark Overlay         */
/*-------------------------------*/
.overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 1;
}

</style>
</head>
<body>
<div class="Y_NavBody">
<center>
<div class="Y_NavTop">
<table class="Y_NavTable">
<tr>
<td class="Y_NavLogo">
<a href="Y_Main"><img src="resources/img/BillyU_Logo.png" alt="로고" width="100%" height="80%" /></a>
</td>
<td class="Y_NavBlank"> </td>

<form action="a.jsp" method="post">
<td class="Y_NavSearch">
  <input class="Y_SearchBar" type="text" name="search" placeholder="검색어를 입력해 주세요.">
</td>
<td class="Y_NavAD">
<div style="width:100%;height:100%">

<select name="category" class="Y_NavSelect">
<option value="제목">제목</option>
<option value="공여자">공여자</option>
<option value="판매">판매</option>
<option value="나눔">나눔</option>
</select>

<input type="submit" value="검색" class="Y_SearchButton" />
</form>

</div>
</td>
</tr>
</table>
</div><!-- Y_NavTop 끝 -->


<div class="Y_NavBottom">
<div class="Y_NavContent">

<nav id="navbar" class="navbar">
<div class="container-fluid">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
<span class="glyphicon glyphicon-align-justify"></span>
</button>
<button id="Y_NavContent_Left_Down" class="navbar-brand" ><span class="glyphicon glyphicon-align-justify"> 전체카테고리▼</span></button>
<button id="Y_NavContent_Left_Up" class="navbar-brand" ><span class="glyphicon glyphicon-align-justify"> 전체카테고리▲</span></button>
</div>
<div class="collapse navbar-collapse" id="myNavbar">
<ul class="nav navbar-nav navbar-right">
<li><a id="Y_NavContent_Right" href="Y_Jang"><span class="glyphicon glyphicon-shopping-cart"></span>관심상품</a></li>
<li><a id="Y_NavContent_Right" href="Y_MyPage"><span class="glyphicon glyphicon-user"></span>마이페이지</a></li>
<li><a id="Y_NavContent_Right" href="Y_Login"><span class="glyphicon glyphicon-log-in"></span>
          <%
          if(session.getAttribute("id") != null){
        	  out.println("로그아웃");
          }
          else{
        	  out.println("로그인");
          }
          %>
          
          </a></li>
<li><a id="Y_NavContent_Right" href="Y_JoinForm"><span class="glyphicon glyphicon-check"></span>회원가입</a></li>
<li><a id="Y_NavContent_Right" href="K_product"><span class="glyphicon glyphicon-plus"></span>상품등록</a></li>
</ul>
</div>
</div>
</nav>

</div><!-- Y_NavContent 끝 -->
</div><!-- Y_NavBottom 끝 -->
</center>
<script>
      $(document).ready(function(){
        $(window).scroll(function(){
          if ($(this).scrollTop()>200){
            $('.Y_NavTopButton').fadeIn();
          }else{
            $('.Y_NavTopButton').fadeOut();
          }
        });
        $( '.Y_NavTopButton' ).click( function() {
          $( 'html, body' ).animate({scrollTop:0},300);
          return false;
        } );
        
        $('#Y_NavContent_Left_Down').click(function() {
        	$('#Y_NavContent_Left_Down').css('display','none');
        	$('#Y_NavContent_Left_Up').css('display','block');
        	$.ajax({
        		type : "POST",
        		url : "./Y_All_Category",
        		success:WhenSuccess,
        		error:WhenError
        	});
        });
        $('#Y_NavContent_Left_Up').click(function() {
        	$('#Y_NavContent_Left_Down').css('display','block');
        	$('#Y_NavContent_Left_Up').css('display','none');
        	$('#Y_All_Back').css('display','none');
        });
        
        function WhenSuccess(resdata){
        	$('#Y_All_Back').css('display','block').html(resdata);
        }

        function WhenError(){
        	alert('error');
        }
      } );
      //function open_win()
      //{
    //  window.open('Y_JoinForm.jsp','popup', 'width=400, height=600, scrollbars= no, toolbar=no, menubar=no,status=no,location=no,directories=no,resizeable=no')
      //}
      
    </script>
    <div>
      <a href="#" class="Y_NavTopButton" style="width:20px;height:20px">▲Top</a>
    </div>
    <center>
    <div id="Y_All_Back"></div>
    </center>
    </div>
    
<div id="wrapper">
<div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="Y_Main">
                       BillyU
                    </a>
                </li>
                <li>
                    <a href="Y_Login"><i class="fa fa-fw fa-home"></i> 로그인</a>
                </li>
                <li>
                    <a href="Y_JoinForm"><i class="fa fa-fw fa-folder"></i> 회원가입</a>
                </li>
                <li>
                    <a href="Y_MyPage"><i class="fa fa-fw fa-file-o"></i> 마이페이지</a>
                </li>
                <li>
                    <a href="K_product"><i class="fa fa-fw fa-cog"></i> 상품등록</a>
                </li>
                <li>
                    <a href="Y_Jang"><i class="fa fa-fw fa-bank"></i> 찜바구니</a>
                </li>
                <li>
                    <a href="Y_Introduce"><i class="fa fa-fw fa-dropbox"></i> 사이트소개</a>
                </li>
                <li>
                    <a href="Y_Information"><i class="fa fa-fw fa-twitter"></i> 게시판</a>
                </li>
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>
        </div>
</div>
<script>

$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;

	    trigger.click(function () {
	      hamburger_cross();      
	    });

	    function hamburger_cross() {

	      if (isClosed == true) {          
	        overlay.hide();
	        trigger.removeClass('is-open');
	        trigger.addClass('is-closed');
	        isClosed = false;
	      } else {   
	        overlay.show();
	        trigger.removeClass('is-closed');
	        trigger.addClass('is-open');
	        isClosed = true;
	      }
	  }
	  
	  $('[data-toggle="offcanvas"]').click(function () {
	        $('#wrapper').toggleClass('toggled');
	  });  
	});
</script>
</body>
</html>