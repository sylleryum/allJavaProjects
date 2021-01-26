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

        
        
                        <div>
                                <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                                User <security:authentication property="principal.username"/> 
                                                <input type="submit" value="Logout" class="botao"/>
                                </form:form>
                        </div>
                    <br>
                    <br>
                    <div>Parte 2 de 3</div>
                    <a href="${pageContext.request.contextPath}/">Voltar ao inicio do pedido</a>

                            <form:form action="processPedido2" modelAttribute="pedido" method="GET">

                            <br>
                            <div>
                            Tamanho da Pizza:
                            <c:out value="${pedidoParc.getTamanho()}"/>
                            <br>

                            Tipo de massa:
                            <c:out value="${pedidoParc.getMassa()}"/>
                            <br>

                            Borda:
                            <c:out value="${pedidoParc.getBorda()}"/>
                            <br>

                            Quantidade de sabores:
                            <c:out value="${pedidoParc.getDividida()}"/>
                            <br>
                            <br>

                             <!-- 1 sabores -->
                            1º sabor:
                            <form:select path="sabor1">
                                    <form:option value="Selecione o sabor" /> 
                                    <form:options items="${saboresOptions}"/>
                            </form:select>
                            <c:if test="${erroSabor1 == true}">
                                            <div class="error">Por favor, selecione o sabor</div>
                            </c:if>
                            <br>
                            <br>

                            <!-- 2 sabores -->
                            <c:if test="${pedidoParc.getDividida() == 2}">
                                    2º sabor:
                                    <form:select path="sabor2"> 
                                            <form:option value="Selecione o sabor" />
                                            <form:options items="${saboresOptions}" />
                                    </form:select>
                                    <c:if test="${erroSabor2 == true}">
                                            <div class="error">Por favor, selecione o sabor</div>
                                    </c:if>
                                    <br>
                                    <br>
                            </c:if>

                            <!-- 3 sabores -->
                            <c:if test="${pedidoParc.getDividida() == 3}">
                                    2º sabor:		
                                    <form:select path="sabor2"> 
                                            <form:option value="Selecione o sabor" />
                                            <form:options items="${saboresOptions}" />
                                    </form:select>
                                    <c:if test="${erroSabor2 == true}">
                                            <div class="error">Por favor, selecione o sabor</div>
                                    </c:if>
                                    <br>
                                    <br>
                                    3º sabor:		
                                    <form:select path="sabor3"> 
                                            <form:option value="Selecione o sabor" />
                                            <form:options items="${saboresOptions}" />
                                    </form:select>
                                    <c:if test="${erroSabor3 == true}">
                                            <div class="error">Por favor, selecione o sabor</div>
                                    </c:if>
                                    <br>
                                    <br>
                            </c:if>

                            <!-- adicional -->	
                            Adicional (opcional)
                            <form:select path="adicional"> 
                                            <form:option value="Sem adicional" />
                                            <form:options items="${theAdicionalOptions}" />
                            </form:select>
                            <br>
                            <br>

                            <!-- personalizar -->
                            Personalizar (opcional)
                            <form:textarea path="personalizar"/>
                            <br>
                            <br>

                            <!-- bebida -->
                            Bebida:
                            <form:select path="bebida"> 
                                            <form:option value="Sem bebida" />
                                            <form:options items="${theBebidaOptions}" />
                            </form:select>
                            <br>
                            <br>

                            Selecione o endereço:
                            <c:if test="${erroAddress == true}">
                                    <div class="error">Por favor, selecione o endereço</div>
                            </c:if>
                            <br>
                            <form:radiobutton path="selectedAddress" value="default"/><c:out value="${pedidoParc.getoEndereco()}"/>
                            <br>
                            <br>

                            <form:radiobutton path="selectedAddress" value="outro"/>Outro endereço
                            <br>
                            <br>

                            <input type="submit" value="Proximo" class="botao"/>

                            </form:form>
                    </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-6">
                                            <img src="<%=request.getContextPath()%>/resources/imagens/img1.png" alt="" class="img-responsive img-rounded" />
                                    </div>

                            </div>
                    </div>
            </div>

    </body>
</html>