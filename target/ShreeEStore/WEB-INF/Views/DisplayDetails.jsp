<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRODUCT DETAILS</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="<c:url value='/resources/JS/AngularController.js'/>"></script>
</head>

<body> 
<div>
	<%@ include file="header.jsp" %>
</div>

<div ng-app="myApp" ng-controller="ProductController" ng-init="loadDataById('${param.id}')">
<center>
	<img src="<c:url value='/resources/{{Data.category}}/{{Data.image}}'/>" height="400px" width="400px" />
</center>


<table class="table table-striped">
<tr>
	<th>Name</th>
	<td>{{Data.name}}</td>
</tr>
<tr>
	<th>Available Quantity</th>
	<td>{{Data.qty}}</td>
</tr>
<tr>
	<th>Price</th>
	<td>{{Data.price}}</td>
</tr>
<tr>
	<th>Details</th>
	<td>{{Data.description}}</td>
</tr>
<tr>
	<th>Category</th>
	<td>{{Data.category}}</td>
</tr>

</table>

<table class="table" >
		<tr>
		<td>
		
		<a href="<c:url value="disp?id=4" />" class="btn btn-primary">Back</a>
			</td>
			<td>	
			<sec:authorize access="isAuthenticated()">
			<sec:authorize access="hasRole('ROLE_USER')">
		<a href="#" class="btn btn-primary" ng-click="addItemToCart('${param.id}')">
		<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
							</a>
							</sec:authorize>
		  </sec:authorize>
		  <sec:authorize access="isAnonymous()">
		  <a href="login" class="btn btn-primary">
		<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
							</a>
		  </sec:authorize>
							</td>
							<td>
							<sec:authorize access="isAuthenticated()">
							<sec:authorize access="hasRole('ROLE_USER')">
										<a href="<c:url value='/memberShip'/>"  class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
										</sec:authorize>
										</sec:authorize>
										<sec:authorize access="isAnonymous()">
											<a href="login"  class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
										</sec:authorize>
							</td>
			</tr>						
</table>
</div>

<div>
	<%@ include file="footer.jsp" %>
</div>

</body>
</html>