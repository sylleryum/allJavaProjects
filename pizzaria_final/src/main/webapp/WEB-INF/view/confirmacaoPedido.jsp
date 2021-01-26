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
    
            <title>Confirmação do pedido</title>

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

                <div>
                        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                            User <security:authentication property="principal.username"/> <input type="submit" value="Logout"/>
                        </form:form>
                </div>
                <br>
                <br>
                <div>Parte 3 de 3</div>
                <a href="${pageContext.request.contextPath}/processPedido?retorna=true">Voltar a pagina anterior</a>
                <a href="${pageContext.request.contextPath}/">Voltar ao inicio do pedido</a>


                <h3>Confirmação do pedido</h3>

                <form:form action="pedidoCompleto" modelAttribute="pedido" method="GET">

                <br>
                <div>
                Tamanho da Pizza:
                <c:out value="${pedidoCompl.getTamanho()}"/>
                <br>

                Tipo de massa:
                <c:out value="${pedidoCompl.getMassa()}"/>
                <br>

                Borda:
                <c:out value="${pedidoCompl.getBorda()}"/>
                <br>

                Quantidade de sabores:
                <c:out value="${pedidoCompl.getDividida()}"/>
                <br>

                Sabor:
                <c:out value="${pedidoCompl.getSabor1()}"/>
                <br>

                <c:if test="${pedidoCompl.getDividida()==2}">
                2º Sabor:
                <c:out value="${pedidoCompl.getSabor2()}"/>
                <br>
                </c:if>

                <c:if test="${pedidoCompl.getDividida()==3}">
                2º Sabor:
                <c:out value="${pedidoCompl.getSabor2()}"/>
                <br>

                3º Sabor:
                <c:out value="${pedidoCompl.getSabor3()}"/>
                <br>	
                </c:if>

                Adicional:
                <c:out value="${pedidoCompl.getAdicional()}"/>
                <br>

                Personalização:
                <c:out value="${pedidoCompl.getPersonalizar()}"/>
                <br>

                Bebida:
                <c:out value="${pedidoCompl.getBebida()}"/>
                <br>

                Preço total:
                <c:out value="${pedidoCompl.getPreco()}"/>
                <br>

                <c:if test="${pedidoCompl.getSelectedAddress()=='outro'}">
                Endereço:

                <form:input path="oEndereco"/>
                <c:if test="${erroEndereco == true}">
                        <div class="error">Por favor, selecione o endereço</div>
                </c:if> 

                <br>
                </c:if>

                <c:if test="${pedidoCompl.getSelectedAddress()=='default'}">
                Endereço: 
                <c:out value="${pedidoCompl.getoEndereco()}"/>
                <br>

                </c:if>

                <br>	
                <input type="submit" value="Finalizar pedido"/>

                </div>

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