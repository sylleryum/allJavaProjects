<%@page import="ad2.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de pessoa</title>
<%
	Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
	String dataFormatada = "";
	if (pessoa.getPessoaID() != -1) {
		System.out.println("oiio "+pessoa.getEstadoCivil());
		if (pessoa.getDataNasc() == null) {
			pessoa.setDataNasc("0000-00-00");
		}
		dataFormatada = pessoa.getDataNasc().substring(8, 10) + "/" + pessoa.getDataNasc().substring(5, 7) + "/"
				+ pessoa.getDataNasc().substring(0, 4);
		if (pessoa.getEstadoCivil()!="Casado" || pessoa.getEstadoCivil()!="Solteiro" || pessoa.getEstadoCivil()!="Viuvo") {
			pessoa.setEstadoCivil("Casado");
		}
	}
%><br>
<br>

<style type="text/css">
div#frame {
	width: 300px;
	/*height: 400px;*/
	border: 3px solid black;
	padding: 5px 3px 5px 10px;
}
</style>
</head>

<body>
	<%
		if (pessoa.getPessoaID() != -1) {
	%>
	<div id="frame">
		<form action="/ad2/alterar" name="form1" method="post">
			<h1>Dados de Pessoa</h1>
			<br> <INPUT TYPE="hidden" NAME="iID" ID="iID"
				value="<%=pessoa.getPessoaID()%>"> Nome: <INPUT
				TYPE="text" NAME="iNome" id="iNome" value="<%=pessoa.getNome()%>"><br>
			<br> Idade: <INPUT TYPE="text" NAME="iIdade" id="iIdade"
				value="<%=pessoa.getIdade()%>"><br>
			<br> Data Nascimento: <INPUT TYPE="text" NAME="iNasc" id="iNasc"
				value="<%=dataFormatada%>"><br>
			<br> Cidade: <INPUT TYPE="text" NAME="iCidade" id="iCidade"
				value="<%=pessoa.getCidade()%>"><br>
			<br> Estado Civil: <br>
			<br>
			<%
				if (pessoa.getEstadoCivil().equalsIgnoreCase("casado")) {
			%>
			<input type="radio" name="check[]" id="Casado" value="Casado" checked>Casado<br>
			<input type="radio" name="check[]" id="Solteiro" value="Solteiro">Solteiro<br>
			<input type="radio" name="check[]" id="Viuvo" value="Viuvo">Viuvo<br>
			<%
				} else if (pessoa.getEstadoCivil().equalsIgnoreCase("solteiro")) {
			%>
			<input type="radio" name="check[]" id="Casado" value="Casado">Casado<br>
			<input type="radio" name="check[]" id="Solteiro" value="Solteiro"
				checked>Solteiro<br> <input type="radio" name="check[]"
				id="Viuvo" value="Viuvo">Viuvo<br>
			<%
				} else if (pessoa.getEstadoCivil().equalsIgnoreCase("Viuvo")) {
			%>
			<input type="radio" name="check[]" id="Casado" value="Casado">Casado<br>
			<input type="radio" name="check[]" id="Solteiro" value="Solteiro">Solteiro<br>
			<input type="radio" name="check[]" id="Viuvo" value="Viuvo" checked>Viuvo<br>
			<%
				}
			%>
			<INPUT TYPE="reset" value="Limpar"> <INPUT TYPE="submit"
				id="btnSubmit" value="Alterar"> <a href="listar?acao=lista">Listar</a>
		</form>


	</div>
	<%
		} else {
	%>
	Nada encontrado!
	<br>
	<%
		}
	%>
	<a href="listar?acao=lista">Listar</a>
	<a href="/ad2/index.jsp">Homepage</a>


</body>