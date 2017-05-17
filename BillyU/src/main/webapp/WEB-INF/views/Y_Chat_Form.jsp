<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" import="java.text.*" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<style>
        .container { width: 600px; padding: 10px; border: 2px solid #3e3e41;}
        .talk_view { position: relative; width: 580px; height: 200px; padding: 5px; border: 1px dotted #3e3e41; overflow-y:scroll;}
        .talk_input { position: relative; margin-top: 20px; width: 500px; padding: 5px; border: 1px dotted #3e3e41; }
    </style>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script language="javascript" type="text/javascript">  
    function pagestart() {
    	window.setTimeout("pagereload()", 60000);
    	}
    	function pagereload() {
    	location.reload();
    	}
    var id="";
    
    $(window).load(function(){
    	id = $('#userid').val();
    	$.ajax({
        	type:"POST",
        	url:"./Y_Select_content.jsp",
        	success:WhenSuccess,
        	error:WhenError
        });
    });
    
    function delete_content(){
    	$.ajax({
        	type:"POST",
        	url:"./Y_delete_content.jsp",
    		error:WhenError
        });
    	location.reload();
    	alert('대화내용삭제');
    }
    
        function sendTalk() {
        	
            var obj = document.getElementById("talk_input");
            if($('#talk_input').val() == ""){
            	alert('내용을 입력해 주세요');
            	$('#talk_input').focus();
            }
            else{
            $.ajax({
            	type:"POST",
            	url:"./Y_Insert_content.jsp",
            	data : { content : id+" : "+obj.value},
            });

            
            if(obj) {
                addTalk(obj.value);
                obj.value = ""; 
                obj.focus(); 
            }
            }
            location.reload();
        }

        function WhenSuccess(resdata){
        	$('#talk_view').html(resdata);
        }

        function WhenError(){
        	alert('error');
        }
        
        function addTalk(content) {
            var obj = document.getElementById("talk_view");
            if(obj) {
            		var line = id+ " : " +content +"<br>";
                    obj.innerHTML += line; 
            }          
        }
    </script>
</head>
<body onLoad="pagestart()">

<div class="container">
			<input id="userid" type="text" value="<%=session.getAttribute("id") %>" />
            <div id="talk_view" class="talk_view"></div>   
            <input type="text" name="talk_input" id="talk_input" class="talk_input">
            <input type="button" name="talk_send" id="talk_send" value="입력" OnClick="sendTalk()">
        </div>
        <center>
        <p>새로고침하면 대화내용이 업데이트 됩니다.</p>
        <p>1분에 한번씩 새로고침 됩니다.</p>
        <p>날짜와 시간은 서버 기준입니다.</p>
        <input type="button" id="delete" value="대화내용 모두 삭제" onclick="delete_content()"/>
        </center>
        <script>
        
        </script>
</body>
</html>