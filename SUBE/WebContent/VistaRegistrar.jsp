<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar</title>
		<!-- Bootstrap core CSS -->
		<link href="../../../../dist/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="signInUp.css" rel="stylesheet">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<script type = "text/javascript">
			$(document).ready( function () {
				$( '#registrar' ).click( function () {
					var nombreUsuario = $('#usr').val();
					var pasword =  $('$pass').val();
					var nombre = $('#nombre').val();
					var apellido = $('#apellido').val();
					var dni = $('#dni').val();
					var esTarifaSocial = $("#social").val();
					var esTarifaEstudiantil = $('#estudiantil"').val();

						$.ajax({
						method: "POST" ,
							url: "AgregarPersonaJSP" ,
							data: {
								nombreUsuario : usr
								password : pass
								nombre : Nombre
								apellido : Apellido
								dni : dni
								esTarifaSocial : esTarifaSocial
								esTarifaEstudiantil : esTarifaEstudiantil
							},
							async: false
						}).done( function (data) {
						$( "#responsecliente" ).html(data);
					})
				});
			});
		</script >


	</head>
	<body class="text-center">
		<form class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal">Registrar nuevo usuario</h1>
			<input type="email" id="inputEmail" class="form-control" placeholder="Correo electr&oacute;nico" required autofocus>
			<input type="password" id="inputPassword" class="form-control" placeholder="Contrase&ntilde;a" required>
			<input type="text"  class="form-control" placeholder="Nombre" required>
			<input type="inputMiddle" class="form-control" placeholder="Apellido" required>
			<input type="number" class="form-control" placeholder="D.N.I" required>
			<div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Solicitar tarifa social
        </label>
      </div>
			<div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Solicitar boleto estudiantil
        </label>
      </div>
			<button class="btn btn-lg btn-primary btn-block" type="registrar">Registrar</button>
		</form>

	</body>

</html>
