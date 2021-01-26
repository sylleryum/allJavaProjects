<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

<title>Student Confirmation Page</title>

</head>

<body>

	The Student is: ${student.firstName} ${student.lastName}

	<br><br>
	
	Country: ${student.country}
	
	<br><br>
	
	Favorite language: ${student.favoriteLanguage}
	
	<br><br>
	
	Operating system:
	<ul>
		<c:forEach var="temp" items="${student.OS}">	
		<li>${temp}</li>
		</c:forEach>
	
	</ul>
</body>

<body>