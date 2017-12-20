<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT PRODUCT</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
	<script src="<c:url value='/resources/JS/AngularController.js'/>"></script>
	
<style>
	.errStyle
	{
		color:red;
		font-style: italic;
		font-weight: bold;
	}
</style>
</head>

<body style="background-color: #FDFDFD;">

<div>
	<%@ include file="header.jsp" %>
</div>
<div class="container" ng-app="myApp" ng-controller="ProductController">
<h2><center>UPDATE PRODUCT</center></h2>

<form:form role="form" enctype="multipart/form-data" action="edit" modelAttribute="product">
<form:input style="visibility:hidden" path="id"/>
<div class="form-group">
	<form:label  path="name">
					<spring:message text="NEW NAME:"/>
	</form:label>
	<form:input class="form-control" path="name" />
	<form:errors path="name" >
		<p class="errStyle">
			*NAME should be atleast 2 characters.
		</p>
	</form:errors>
</div>

<div class="form-group">
	<form:label  path="qty">
		<spring:message text="AVAILABLE QUANTITY:"/>
	</form:label>
	<form:input class="form-control" path="qty" />
	<form:errors path="qty" >
		<p class="errStyle">
			*QUANTITY cannot be less than 1.
		</p>
	</form:errors>
</div>

<div class="form-group">
	<form:label  path="price">
		<spring:message text="NEW PRICE:"/>
	</form:label>
	<form:input class="form-control" path="price" />
	<form:errors path="price" >
		<p class="errStyle">
			*PRICE cannot be less than 1.
		</p>
	</form:errors>
</div>

<div class="form-group">
	<form:label  path="category">
		<spring:message text="CATEGORY:"/>
	</form:label>
	<form:select class="form-control" path="category" >
		<form:option value="Mobiles">Mobile</form:option>
		<form:option value="Cameras">Camera</form:option>
		<form:option value="Laptops">Laptop</form:option>
	</form:select>
</div>
	
<div class="form-group">
	<form:label  path="description">
		<spring:message text="NEW DESCRIPTION:"/>
	</form:label>
	<form:input class="form-control" path="description" />
	<form:errors path="description">
		<p class="errStyle">
			*DESCRIPTION Cannot be blank.
		</p>
	</form:errors>
</div>
	 
<div class="form-group">
	 <label>UPLOAD IMAGE</label>
	 <form:input type="file" path="file" class="form-control" />
	 <form:errors path="file">
	 	<p class="errStyle">
	 		*Select an IMAGE.
	 	</p>
	 </form:errors>
	 Uploaded Image:<form:input disabled="true" path="image"/>
</div>
	
<div class="form-group">
	<input  class="btn btn-info"  type="submit" value="<spring:message text="UPDATE"/>" />
</div>
</form:form>
</div>
<div>
	<%@ include file="footer.jsp" %>
</div>

</body>
</html>