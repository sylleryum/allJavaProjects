<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>

<title>Student registration form</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>	
	<br><br>
	Last name: <form:input path="lastName"/>
	<br><br>
	
	<form:select path="country">
		
		//load from the Student class
		
		<form:options items="${student.countryList}"/>
		 		 
		
	</form:select>
	
	<br><br>
	
	Favorite language:
	 
	<form:radiobutton path="favoriteLanguage" value="Java"/>Java
	<form:radiobutton path="favoriteLanguage" value="C#"/>C#
	<form:radiobutton path="favoriteLanguage" value="PHP"/>PHP
	<form:radiobutton path="favoriteLanguage" value="Ruby"/>Ruby
	 
	<br><br>
	
	Operating systems:
	<form:checkbox path="OS" value="Linux"/>Linux
	<form:checkbox path="OS" value="Windows"/>Windows
	<form:checkbox path="OS" value="Mac"/>Mac
	
	<input type="submit" value="Submit"/>
	
	</form:form>

</body>

<body>