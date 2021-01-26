<%@page import="ad2.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Pessoas</title>
<script>
function getID() {
    var txt;
    var ID = prompt("Digite o ID da pessoa para alterar", "");
    if (ID == null || ID == "") {
    } else {
    	//window.location="/ad2/alterarpessoa.jsp?ID="+ID;
    	window.location="/ad2/alterar?ID="+ID;
        //return pessoaID;
    }
}
function getIDExcluir() {
    var txt;
    var ID = prompt("Digite o ID da pessoa para Excluir", "");
    if (ID == null || ID == "") {
    } else {
    	//window.location="/ad2/alterarpessoa.jsp?ID="+ID;
    	window.location="/ad2/excluir?ID="+ID;
        //return pessoaID;
    }
}

</script>

<%
//get pessoa
	List<Pessoa> listaPessoas = (List<Pessoa>) request.getAttribute("pessoa");
%>
<%	
//get status
	if (request.getAttribute("status")!=null){		
		String status = (String) request.getAttribute("status");
		System.out.println("testetete: "+status);
		%> <script>
		var status = "<%=status%>";
		alert("Pessoa "+status+ " com sucesso!")</script> <%
		//if (status.equalsIgnoreCase("inserido")){
			
		//} else if (status.equalsIgnoreCase("alterado")){
			
		//} else if (status.equalsIgnoreCase("excluido")){
		
	}
	
%>
</head>
<body>
	<h1>Listagem de pessoas</h1>
	<%
		//InserirPessoa ip = new InserirPessoa();
	%>
	
	<table border="1">
		<tr style="font-weight: bold;">
			<td>Id</td>
			<td>Nome</td>
			<td>Idade</td>
			<td>Data Nascimento</td>
			<td>Cidade</td>
			<td>Estado Civil</td>
			
			<td border="0">			
			<a href="javascript:getID()">Alterar Pessoa</a>			
			</td>
			<td border="0">			
			<a href="javascript:getIDExcluir()">Excluir Pessoa</a>			
			</td>
			
			
		</tr>			

	<%	for (Pessoa p : listaPessoas) { %>
		<tr>
			<td><%=p.getPessoaID() %></td>
			<td><%=p.getNome() %></td>
			<td><%=p.getIdade() %></td>
			<td><%=p.getDataNasc() %></td>
			<td><%=p.getCidade() %></td>
			<td><%=p.getEstadoCivil() %></td>
			
		</tr>
		
	<% }%>
	
	</table>
	<br><a href="/ad2/index.jsp">Homepage</a>
	
</body>
</html>