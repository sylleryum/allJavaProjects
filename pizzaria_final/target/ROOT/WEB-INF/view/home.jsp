<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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


            <title>Faça seu pedido</title>
	</head>
	<body class="bg-verde">
		<div class="container-fluid  bg-amarelo">
		
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12">
						<h1>Sistema de Gerenciamento de Pedidos</h1>
					</div>
				</div>
			</div>
		</div>
		
            <div class="container-fluid">
                    <div class="container">
                            <div class="row bg-verde-interno">
                                    <div class="col-xs-12 col-sm-12 col-md-6">

                                            <h1>Login efetuado com sucesso, bem vindo <security:authentication property="principal.username"/></h1>

                                                    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                                          <!--   User <security:authentication property="principal.username"/> -->	
                                                            <input type="submit" value="Logout" class="botao"/>
                                                    </form:form>
                                                    <br>
                                                    <!-- Role <security:authentication property="principal.authorities"/> -->
                                                    <br>

                                                    <p>
                                                            <security:authorize access="hasRole('FUNC')">
                                                                    <a href="${pageContext.request.contextPath}/admin">Administração de pedidos</a>
                                                            </security:authorize>
                                                    </p>

                                                    <a href="${pageContext.request.contextPath}/acompanhaPedido">Acompanhar pedido</a>

                                                    <br>


                                            <h2>Faça seu Pedido</h2>
                                            <hr>

                                            <form:form action="processPedido" modelAttribute="pedido" method="GET">

                                                    <h3>Tamanho da Pizza &nbsp;<form:errors path="tamanho" cssClass="error"></form:errors></h3>
                                                    <form:radiobutton path="tamanho" value="Broto"/>Broto
                                                    <form:radiobutton path="tamanho" value="Medio"/>Medio
                                                    <form:radiobutton path="tamanho" value="Grande"/>Grande
                                                    <form:radiobutton path="tamanho" value="Familia"/>Familia

                                                    <h3>Tipo da Massa &nbsp;<form:errors path="massa" cssClass="error"></form:errors></h3>
                                                    <form:radiobutton path="massa" value="Fina"/>Fina
                                                    <form:radiobutton path="massa" value="Media"/>Media (Normal)
                                                    <form:radiobutton path="massa" value="Grossa"/>Grossa

                                                    <h3>Tipo da Borda &nbsp;&nbsp;&nbsp;<form:errors path="borda" cssClass="error"></form:errors></h3>
                                                    <form:radiobutton path="borda" value="Sem"/>Sem Borda
                                                    <form:radiobutton path="borda" value="Muzzarela"/>Muzzarela
                                                    <form:radiobutton path="borda" value="Catupiry"/>Catupiry
                                                    <form:radiobutton path="borda" value="Chocolate"/>Chocolate

                                                    <h3>Quantidade de Sabores &nbsp;<form:errors path="dividida" cssClass="error"></form:errors></h3>
                                                    <form:radiobutton path="dividida" value="1"/>1 Sabor
                                                    <form:radiobutton path="dividida" value="2"/>2 Sabores
                                                    <form:radiobutton path="dividida" value="3"/>3 Sabores
                                                    <br>
                                                    <br>
                                                    <input type="submit" value="Proximo" class="botao" />
                                            </form:form>

                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-6">
                                            <img src="<%=request.getContextPath()%>/resources/imagens/img1.png" alt="" class="img-responsive img-rounded" />
                                    </div>

                            </div>
                    </div>
            </div>
			
	</body>
</html>