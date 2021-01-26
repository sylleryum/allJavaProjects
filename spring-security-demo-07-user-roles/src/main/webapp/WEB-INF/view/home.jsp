<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
<h1>Pure Java configuration, Hello World</h1>

	<hr>
		<p>
			User <security:authentication property="principal.username"/>
			<br>
			Role <security:authentication property="principal.authorities"/>
			<br>	
		</p>
		
		<p>
			<security:authorize access="hasRole('manager')">
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for managers)
			</security:authorize>
		</p>
		
			

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>