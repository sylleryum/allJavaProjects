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
		 		 
		 <!-- //load from file
		<form:options items="${theCountryOptions}" />
		 -->		
		
		<!-- jeito manual  
		<form:option value="Brazil" label="Brazil"></form:option>
		<form:option value="France" label="France"></form:option>
		<form:option value="Germany" label="Germany"></form:option>
		<form:option value="India" label="India"></form:option>
		-->
	</form:select>
	
	<br><br>
	
	Favorite language: 
	 
	<form:radiobutton path="favoriteLanguage" value="Java"/>Java
	<form:radiobutton path="favoriteLanguage" value="C#"/>C#
	<form:radiobutton path="favoriteLanguage" value="PHP"/>PHP
	<form:radiobutton path="favoriteLanguage" value="Ruby"/>Ruby
	 
	 
	 <!-- //load from student class 
	 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguage}"/>
	 -->
	
	
	<input type="submit" value="Submit"/>
	
	</form:form>

</body>

<body>