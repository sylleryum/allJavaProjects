<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quero me registrar</title>
</head>
<body>
	<h3>Por favor, preencha os dados abaixo para se registrar</h3>
	
	<form:form action="/checkregister" modelAttribute="cliente" method="POST">
	
		<div>
		Nome de usuario (sem espaços): <form:input path="username"/>
		<br>
		Senha: <form:password path="password"/>
		<br>
		Primeiro nome: <form:input path="nome"/>
		<br>
		Sobrenome: <form:input path="sobrenome"/>
		<br>
		Telefone: <form:input path="tel"/>
		<br>
		Endereço: <form:input path="endereco"/>
		<br>
		Email: <form:input path="email"/>
		<br>
		
		</div>
	<!-- 
  `id` int NOT NULL AUTO_INCREMENT,  NAO VAI
  `username` varchar(50) NOT NULL UNIQUE,	TEXTFIELD
  `password` varchar(50) NOT NULL,	PASSWORD FIELD
  `nome` varchar(50) NOT NULL,  TEXTFIELD
  `sobrenome` varchar(50) NOT NULL, TEXTFIELD
  `tel` BIGINT(14) NOT NULL, TEXTFIELD
  `endereco` varchar(50) NOT NULL, TEXTFIELD
  `email` varchar(50) NOT NULL, TEXTFIELD
  `enabled` tinyint(1) NOT NULL, NÃO VAI  
	private int enabled;
	 -->
		<input type="submit" value="Registrar"/>
	</form:form>
	
</body>
</html>