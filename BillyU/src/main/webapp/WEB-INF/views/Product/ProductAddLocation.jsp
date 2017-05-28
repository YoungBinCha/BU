<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
      	width: 60%;
        height: 58%;
        z-index: 999;
    	margin: auto;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
    
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
      #inputPanel{
      	width: 500px;
      	height : 100px;
      	text-align: center;
      	font-family: 'Roboto','sans-serif';
      	line-height: 40px;
      	font-size: 25px;
      	margin: auto;
      }
    </style>
    
  </head>
  <body>
  <jsp:include page="../Navigation/NavigationBar.jsp"></jsp:include>
	
    <div id="inputPanel">
      <input id="address" type="textbox" value="송내역">
      <input id="submit" type="button" value="검색">
      <div id="latlngform">
      <form action="regist.lo" method="post">
      <input id="sub" type="submit" value="등록">
      <input id="at" name="lat" type="hidden" >
      <input id="ng" name="lng" type="hidden" >
      </form>
      </div>
    </div>
    <div id="map"></div>
    <script>
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: {lat: 37.487, lng: 126.753}		//처음위치는 송내역 위도경도
        });
        var geocoder = new google.maps.Geocoder();
        $('#latlngform').hide();			//위도경도 등록버튼 처음에 안도이도록
        document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);	//장소를 검색하면 보이도록!
         $('#latlngform').show();
        });
      }
	
      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
       	var lat = "";
       	var lng = "";
  
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            results[0].geometry.location;
            lat = results[0].geometry.location.lat();
            lng = results[0].geometry.location.lng();
          
           // alert(lat +"  "+ lng);
            
            $('#at').val(lat);
            $('#ng').val(lng);

            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
            
            
            
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
        
      }
      
     
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD216mf70yKOSqZLC_KUiIPvhnXv_O7_5E&callback=initMap">
    </script>
    
  </body>
</html>