<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONTACT US</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>

</head>
<body>

	<div>
		<%@ include file="header.jsp" %>
	</div>

	<div class="row">
	    <div class="col-sm-6">
	    <b><font size="5">
	    	<p> ADDRESS: SHREE E-STORE<br> SHOP NO 14, GROUND FLOOR,<br>BANYAN PALACE,NEAR BIKANER SWEETS,<br>OPPOSITE STARBUCKS CAFE, MAHAVIR NAGAR,<br>BORIVALI(WEST).</p>
	    	<br>
	    	<br>
	    	<p> PHONE NO: 022-677677 </p>
	    	<P> EMAIL ID: <a href=Mital.Vichare@niit.com>Mital.Vichare@niit.com</a></P>
	    </font></b>
	    </div>
		<div class="col-sm-6"><img height="400px" src="<c:url value="/resources/shop.jpg" />" alt="Shop"></div>
	</div>
	
	<div>
		<%@ include file="footer.jsp" %>
	</div>

</body>
</html>