<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List customers</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<br>
	<div id="Container">
		<div id="Content">
		
			<input type="button" value="Add Customer" 
			onclick="window.location.href='showFormForAdd'; return false;" class = "add-button"/>
		
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>					
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>