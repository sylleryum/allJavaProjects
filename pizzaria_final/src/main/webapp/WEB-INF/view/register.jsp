<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        <link rel="stylesheet"
              href="<c:url value='/resources/estilo/estilo.css' /> ">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Cadastro</title>
</head>
<body class="bg-verde">

    	<div class=" container-fluid bg-amarelo">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                         <h1>Bem vindo ao sistema de pedido da Pizzaria X</h1>
                    </div>
                </div>
            </div>
        </div>
    
    <div class="container-fluid">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    
                    <h3>Por favor, preencha os dados abaixo para se registrar, todos campos são obrigatórios</h3>

                    <form:form action="checkregister" modelAttribute="client" method="POST">

                            <div>		
                            Nome de usuario (sem espaços) 
                            <br>
                            <form:input path="username"/>
                            <c:if test="${username=='erro'}">
                            <div class="error">Usuario já existe</div>
                            </c:if>
                            <form:errors path="username" cssClass="error"></form:errors>		
                            <br><br>		
                            Senha
                            <br>
                            <form:password path="password"/>
                            <form:errors path="password" cssClass="error"></form:errors>
                            <br><br>
                            Primeiro nome
                            <br>
                            <form:input path="nome"/>
                            <form:errors path="nome" cssClass="error"></form:errors>
                            <br><br>
                            Sobrenome
                            <br>
                            <form:input path="sobrenome"/>
                            <form:errors path="sobrenome" cssClass="error"></form:errors>
                            <br><br>
                            Telefone
                            <br>
                            <form:input path="tel"/>
                            <form:errors path="tel" cssClass="error"></form:errors>
                            <br><br>
                            Endereço completo
                            <br>
                            <form:input path="endereco"/>
                            <form:errors path="endereco" cssClass="error"></form:errors>
                            <br><br>
                            Email
                            <br>
                            <form:input path="email"/>
                            <form:errors path="email" cssClass="error"></form:errors>
                            <br><br>

                            </div>

                            <input type="submit" value="Registrar"/>
                    </form:form>
                </div>
                
                <div class="col-md-6">
                    <img src="<%=request.getContextPath()%>/resources/imagens/img1.png" alt=""/>
                </div>
            </div>
        </div>
    </div>
	
</body>
</html>