<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Cadastro de pessoa</title>

  <style type="text/css">
    div#frame {      
      width: 300px;
      /*height: 400px;*/
      border: 3px solid black;
      padding: 5px 3px 5px 10px;
    }
    </style>
</head>

<script type="text/javascript" language="javascript">

  function validacao(){
    var validaNome = validacaoNome();
    var validaIdade = validacaoIdade();
    if (validaNome == false || validaIdade == false){
      return false;
    } else {
      return true;
    }
  }
  function validacaoNome(){    
    var nome = document.getElementById('iNome').value;
    if (nome==""){
      alert("Por favor, insira o Nome");
      document.getElementById("iNome").focus(); 
      return false;
    } else {
      return true;
    }    
  }
  function validacaoIdade(){
    var idade = document.getElementById('iIdade').value;
    if (idade==""){
      alert("Por favor, insira a Idade");
      document.getElementById("iIdade").focus(); 
      return false;
    } else {
      return true;
    }    
  }
  

</script>

<body>
  <div id="frame">
  <form action="inserir" name="form1" method="post" onsubmit="return validacao()">
    <h1> Dados de Pessoa</h1><br> 
    Nome: <INPUT TYPE="text" NAME="iNome" id="iNome" value=""><br><br>
    Idade: <INPUT TYPE="text" NAME="iIdade" id="iIdade" value=""><br><br>
    Data Nascimento: <INPUT TYPE="text" NAME="iNasc" id="iNasc" value="dd/mm/aaaa" onfocus="if(this.value  == 'dd/mm/aaaa') { this.value = ''; } " onblur="if(this.value == '') { this.value = 'dd/mm/aaaa'; }"><br><br>
    Cidade: <INPUT TYPE="text" NAME="iCidade" id="iCidade" value=""><br><br>
    Estado Civil: <br><br>
    <input type="radio" name="check[]" id="Casado" value="Casado">Casado
    <br>
    <input type="radio" name="check[]" id="Solteiro" value="Solteiro">Solteiro<br>
    <input type="radio" name="check[]" id="Viuvo" value="Viuvo" >Viuvo<br>

    <INPUT TYPE="reset" value="Limpar">
    <INPUT TYPE="submit" id="btnSubmit" value="Cadastrar">
    <a href="listar?acao=lista">Listar</a>
  </form>
  	
  	<!-- <form action="listar" name="form2" method="get">
  		<INPUT TYPE="submit" id=btnListar value="Listar">
  	</form> -->
  
  
  </div>


</body>