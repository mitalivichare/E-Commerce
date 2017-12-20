<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HEADER</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/ShreeEStore">SHREE E-STORE</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/ShreeEStore">HOME</a></li>
      <li><a href="aboutus">ABOUT US</a></li> 
      <li><a href="disp?id=4">VIEW ALL</a></li>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
      <li><a href="add">ADD PRODUCTS</a></li>
      </sec:authorize>
      <li><a href="contactus">CONTACT US</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
		<sec:authorize access="isAnonymous()">	
			<li><a href="register"><span class="glyphicon glyphicon-user"></span>REGISTER</a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>LOGIN</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li> <a href='<c:url value="/j_spring_security_logout" />' > <span class="glyphicon glyphicon-log-out"></span>LOGOUT</a> </li>
		</sec:authorize>
    </ul>
  </div>
</nav>

</body>
</html>