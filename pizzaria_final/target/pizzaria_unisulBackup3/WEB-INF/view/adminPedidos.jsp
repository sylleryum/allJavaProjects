<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        
        <title>Administração de pedidos</title>
        
            <script>
                    function changeStatus(status, id) {
                        //var status = document.getElementById("statusP"+${pedido.getId()}).value;

                        //var id = document.getElementById("theId").innerHTML;
                        console.log(status);
                        console.log(id);
                        //document.write(status);
                        window.location.href = '${pageContext.request.contextPath}/admin/changeStatus?status='+status+'&theId='+id;
                    }
            </script>

    </head>
    <body class="bg-verde">
        <div class=" container-fluid bg-amarelo">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                         <h1>Sistema de pedidos</h1>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container-fluid">
            <div>
                <div class="row bg-verde-interno">       
                    
                </div>
                    <div class="row bg-verde-interno">
                        <div class="col-xs-12 col-sm-12 col-md-12">
                            <div>
                                    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                                    User <security:authentication property="principal.username"/> <input type="submit" value="Logout" class="botao"/>
                                    </form:form>
                            </div>
                            <br>
                            <a href="${pageContext.request.contextPath}/">Voltar a pagina inicial</a>
                            <br>
                            <!--<c:out value="${pedidos}"/>-->
                                <table border="1">
                                       <tr>
                                 <th>Pedido Nº</th>
                                 <th>Tamanho</th>
                                 <th>Massa</th>
                                 <th>Borda</th>
                                 <th>Quant. sabores</th>
                                 <th>Sabor 1</th>
                                 <th>Sabor 2</th>
                                 <th>Sabor 3</th>
                                 <th>Adicional</th>
                                 <th>Personalização</th>
                                 <th>Bebida</th>
                                 <th>Endereço</th>
                                 <th>Preço</th>
                                 <th>Status</th>
                               </tr>
                               <c:forEach var="pedido" items="${pedidos}">
                                   <tr>
                                       <td><div id="theId${pedido.getId()}">${pedido.getId()}</div></td>
                                       <td>${pedido.getTamanho()}</td>
                                       <td>${pedido.getMassa()}</td>
                                       <td>${pedido.getBorda()}</td>
                                       <td>${pedido.getDividida()}</td>
                                       <td>${pedido.getSabor1()}</td>
                                       <td>${pedido.getSabor2()}</td>
                                       <td>${pedido.getSabor3()}</td>
                                       <td>${pedido.getAdicional()}</td>
                                       <td>${pedido.getPersonalizar()}</td>
                                       <td>${pedido.getBebida()}</td>
                                       <td>${pedido.getoEndereco()}</td>
                                       <td>${pedido.getPreco()}</td>
                                       <td>
                                                <select id="statusP${pedido.getId()}" onchange="changeStatus(statusP${pedido.getId()}.value, theId${pedido.getId()}.innerHTML)">
                                                                         <option value="${pedido.getStatus()}">${pedido.getStatus()}</option>
                                                                         <option value="Agendado">Agendado</option>
                                                                         <option value="Em preparo">Em preparo</option>
                                                                         <option value="Em transporte">Em transporte</option>
                                                                         <option value="Entregue">Entregue</option>
                                                               </select> 
                                       </td>
                                   </tr>
                               </c:forEach>
                       </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>