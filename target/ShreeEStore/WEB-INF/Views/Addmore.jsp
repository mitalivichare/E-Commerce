<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUCCESS</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
</head>
<body>
<div>
	<%@ include file="header.jsp" %>
</div>

<div>
<h2>DATA ADDED SUCCESSFULLY.</h2>
	<h3>Do you want to add more PRODUCTS?
		<a href="add">YES</a>|
		<a href="/ShreeEStore">NO</a>
	</h3>
</div>

<div>
	<%@ include file="footer.jsp" %>
</div>

</body>
</html>