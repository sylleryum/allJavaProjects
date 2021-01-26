<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
		.error{color:red}
	
</style>

<title>Cadastro</title>
</head>
<body>
	<h3>Por favor, preencha os dados abaixo para se registrar, todos campos são obrigatórios</h3>
	
	<form:form action="checkregister" modelAttribute="client" method="POST">
	
		<div>		
		Nome de usuario (sem espaços): <form:input path="username"/>
		<form:errors path="username" cssClass="error"></form:errors>
		<br><br>		
		Senha: <form:password path="password"/>
		<form:errors path="password" cssClass="error"></form:errors>
		<br><br>
		Primeiro nome: <form:input path="nome"/>
		<form:errors path="nome" cssClass="error"></form:errors>
		<br><br>
		Sobrenome: <form:input path="sobrenome"/>
		<form:errors path="sobrenome" cssClass="error"></form:errors>
		<br><br>
		Telefone: <form:input path="tel"/>
		<form:errors path="tel" cssClass="error"></form:errors>
		<br><br>
		Endereço: <form:input path="endereco"/>
		<form:errors path="endereco" cssClass="error"></form:errors>
		<br><br>
		Email: <form:input path="email"/>
		<form:errors path="email" cssClass="error"></form:errors>
		<br>
		
		</div>

		<input type="submit" value="Registrar"/>
	</form:form>
	
</body>
</html>