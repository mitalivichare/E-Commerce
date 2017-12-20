<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.logoutblock {
	color: blue;
	background-color: lightgreen;
	border: 3px solid blue;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<div>
		<%@ include file="header.jsp"%>
		</div>
		<div class="container">
		<c:if test="${error=='true'}">
			<div class="errorblock">LOGIN UNSUCCESSFULL. TRY AGAIN.</div>
		</c:if>
		<c:if test="${not empty logoutmsg }">
			<div class="logoutblock">
				<c:out value="${logoutmsg}" />
			</div>
		</c:if>
		<form role="form" action="<c:url value='j_spring_security_check' />"
			method="post">
			<div class="form-group">
				<label for="username">USERNAME:</label> <input type="text"
					name="j_username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">PASSWORD:</label> <input type="password"
					class="form-control" name="j_password" />
			</div>

			<button type="submit" class="btn btn-default">SUBMIT</button>
		</form>
		
		<h4>Not A User ? <a href="register">Sign Up Here</a></h4>
		</div>
		<div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>