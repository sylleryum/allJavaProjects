<%@page import="ad2.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
String dataFormatada = "";
if (pessoa.getPessoaID()!=-1){
dataFormatada = pessoa.getDataNasc().substring(8, 10) + 
		  "/" + pessoa.getDataNasc().substring(5, 7) + "/" + pessoa.getDataNasc().substring(0, 4);} %>


<title>Excluir pessoa</title>
</head>
<body>


<%if (pessoa.getPessoaID()!=-1){ %>
<h1>Confirme a exclusão da seguinte pessoa:</h1>

<table border="1">
<tr>
<td>Nome: </td><td><%= pessoa.getNome()%></td>
</tr>
<tr>
<td>Idade:</td><td> <%= pessoa.getIdade()%></td>
</tr>
<tr>
<td>Data Nascimento:</td><td> <%= pessoa.getDataNasc()%></td>
</tr>
<tr>
<td>Cidade:</td><td> <%= pessoa.getCidade()%></td>
</tr>
<tr>
<td>Estado Civil:</td><td> <%= pessoa.getEstadoCivil()%></td><br>
</tr>
</table><br><br>

<button NAME="excluir" VALUE="excluir" onclick="location.href='excluir?excluir=excluir&id=<%=pessoa.getPessoaID()%>'">Excluir</button> 
<button NAME="cancelar" VALUE="cancelar" onclick="location.href='listar?acao=lista'">Cancelar</button>
    


<%} else {%> Nada encontrado!<br> <% }%>
  <br><br><a href="listar?acao=lista">Listar</a>
  <a href="/ad2/index.jsp">Homepage</a>

</body>
</html>