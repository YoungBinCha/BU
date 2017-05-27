<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
div{height:100vh;}
</style>
</head>
<body>
   <div class="aritcleView">
         <div>1</div>
         <div>2</div>
         <div>3</div> 
   </div>
</body>

<script type="text/javascript">
// Add contents for max height
$(document).ready(function () {
$(document).scroll(function() {
var maxHeight = $(document).height();
var currentScroll = $(window).scrollTop() + $(window).height();

if (maxHeight <= currentScroll + 100) {
$('.aritcleView div').append('<div>aaaaaa</div>');
}
})
});
</script>
</html>
