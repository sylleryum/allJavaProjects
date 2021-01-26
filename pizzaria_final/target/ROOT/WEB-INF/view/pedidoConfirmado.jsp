<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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
    
        <title>Pedido confirmado!</title>
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
                    <div class="row bg-verde-interno">
                        <div class="col-xs-12 col-sm-12 col-md-6">        
                            <h2>Pedido confirmado! Numero do pedido: <c:out value="${id}"/></h2>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/">Fazer outro pedido</a>
                            <br>
                            <a href="${pageContext.request.contextPath}/acompanhaPedido">Acompanhar pedido</a>
                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-6">
                                            <img src="<%=request.getContextPath()%>/resources/imagens/img1.png" alt="" class="img-responsive img-rounded" />
                                    </div>

                    </div>
                </div>
        </div>
    </body>
</html>