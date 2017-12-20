<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONFIRM DELETION</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
</head>

<body style="background-color: #FDFDFD;">
	
<div>
	<%@ include file="header.jsp" %>
</div>
	
<div>
	<h4><center>ARE YOU SURE YOU WANT TO DELETE?</center></h4>
	<div class="row">
		<div class="col-sm-6">
		<form action="delete" method="post" role="form">
  			<input type="text" name="id" value="${param.id}" style="visibility:hidden;">
  			<input type="submit" value="DELETE" class="btn btn-info" />
 		</form>
 		</div>

		<div class="col-sm-6">
		<a href="<c:url value="disp?id=4" />" class="btn btn-primary">CANCEL</a>
 		</div>
	</div>
	
<div>
	<%@ include file="footer.jsp" %>
</div>

</div>
</body>
</html>