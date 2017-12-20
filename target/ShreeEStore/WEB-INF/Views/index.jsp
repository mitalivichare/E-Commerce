<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SHREE E-STORE</title>
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="<c:url value='/resources/JS/AngularController.js'/>"></script>
  
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width:100%;
      height:500px;
      margin: auto;
  }
  </style>
	 
</head>
<body>

<div>
	<%@ include file="header.jsp" %>
</div>

	<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    

    <div class="item active">
      <img src="<c:url value='/resources/mobile-1.jpg'/>" alt="Mobile">
    </div>

    <div class="item">
      <img src="<c:url value='/resources/pc.png'/>" alt="Laptop">
    </div>

    <div class="item">
      <img src="<c:url value='/resources/camera-1.jpg'/>" alt="Camera">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>	
  
<div class="row" style="margin-top: 3%">
    <div class="col-sm-4"><a href="disp?id=1"><img height="300px" src="<c:url value="/resources/mobile-g.png" />" alt="MOBILES"></a></div>
    <div class="col-sm-4"><a href="disp?id=2"><img height="300px" src="<c:url value="/resources/pc-g1.jpg" />" alt="LAPTOPS"></a></div>
    <div class="col-sm-4"><a href="disp?id=3"><img height="300px" src="<c:url value="/resources/camera-g1.jpg" />" alt="CAMERAS"></a></div>
</div>


<div>
 	<%@ include file="footer.jsp" %>
</div> 

</body>

</html>