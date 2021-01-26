<html>
	<head>
		<title>Validacao PHP</title>
		<script type="text/javascript" language="javascript">
		
  			function validaForm(){		
				  alert("test");
				<?php
				$tet = "ok";
					echo "oioiiiii";
					 $error = true;
					 
					 if ($erro==true){ ?> 
					alert("contem erro");
					return false;
					<?php } ?>
				return false;
			  }
		</script>
	</head>
	<body>
	
		<form name="form" action="#" method="post" onsubmit="return validaForm()">
			<table align="center" border="0">
				<tr>
					<td colspan="2" align="center"><b>Formulario de cadastro</b></td>
				</tr>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="nome"/></td>
				</tr>
				<tr>
					<td>Idade</td>
					<td><input type="text" name="idade"/></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td>
						<input type="radio" name="sexo" value="M"/>Masculino
						<input type="radio" name="sexo" value="F"/>Feminino
					</td>
				</tr>
				<tr>
					<td>Turno</td>
					<td>
						<input type="checkbox" name="turno[]" value="Matutino"/>Matutino
						<input type="checkbox" name="turno[]" value="Vespertino"/>Vespertino
						<input type="checkbox" name="turno[]" value="Noturno"/>Noturno
					</td>
				</tr>
				<tr>
					<td><input type="submit" name="enviar" value="Enviar"/></td>
				</tr>
			</table>
			 <?php
				if(isset($_POST['enviar'])){
					$teste = "oiiooiiooi";
					$mensagem = "";
					$nome  = $_POST["nome"];
					$idade = $_POST["idade"];
					$sexo  = isset($_POST["sexo"]);
					$turno  = "";
					$erro = false;
					if(isset($_POST['turno'])){
						foreach($_POST["turno"] as $key => $value){
							$turno = $turno . "," . $value;
						}
					}
					if(count (explode(" ", $nome))<=1){
						$mensagem = $mensagem . "NOME: Deve ter duas palavras</br>";
						$erro = true;
					}
					if(strlen($idade) == 0 || $idade <= 0 || $idade > 150){
						$mensagem = $mensagem .  "IDADE: invalida</br>";
						$erro = true;
					}
					if(empty($sexo) || ($sexo != 'F' && $sexo != 'M')){
						$mensagem = $mensagem . "SEXO: Deve ser selecionado</br>";
						$erro = true;
					}
					if(strlen($turno) == 0){
						$mensagem = $mensagem . "TURNO(s): Deve(m) ser selecionado(s)</br>";
						$erro = true;
					
					if(strpos($turno,"Noturno") > 0 && $idade<18){
						$mensagem = $mensagem . "TURNO NOTURNO: Proibido para menores de 18 anos</br>";
						$erro = true;
					}
					if(!$erro){
						$mensagem = $mensagem . "NOME: ".$nome."</br>";
						$mensagem = $mensagem . "IDADE: ".$idade."</br>";
						$mensagem = $mensagem . "SEXO: ".$sexo."</br>";
						$mensagem = $mensagem . "TURNO(s): ".$turno."</br>";
					}
			 ?>
			<table align="center" border="1" cellspacing="0" cellpadding="0" width="80%">
				<tr><td><?php echo $mensagem; ?></td></tr>
			</table>
			<?php
				}
			?>
			
		</script>
		</form>
	</body>
</html>