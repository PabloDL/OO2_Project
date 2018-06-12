<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar</title>
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="css/signInUp.css" rel="stylesheet">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<script type = "text/javascript">
			$(document).ready( function () {
				$( '#Registrar' ).click( function () {
					var usr = $('#usr').val();
					var psw =  $('#psw').val();
					var nombre =  $('#nombre').val();
					var apellido =  $('#apellido').val();
					var dni =  $('#dni').val();
					var social =  $('#social').is(':checked') ;
					var estudiantil =  $('#estudiantil').is(':checked') ;
					  
					$.ajax({
					    type: "post",
					    url: "/SUBE/AgregarPersonaJSP",
					    data:{ usr: usr ,
					    	psw: psw ,
					    	nombre: nombre,
					    	apellido: apellido,
					    	dni: dni,
					    	social: social,
					    	estudiantil: estudiantil
					    	},
					    success: function (data, text) {
					        if(data == "correcto"){					        	
					        	   location.href ="/SUBE/VistaIniciarSesion.jsp";
					        }
					        else{
					        	alert("error al registrarse: " + data);
					        }
					    },
					    error: function (request, status, error) {
					    	console.log(error);
					        alert(request.responseText);
					    }
					});
				});
			});
		</script>


	</head>
	<body class="text-center">
		<form class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal">Registrar nuevo usuario</h1>
			<input type="text" id="usr" class="form-control" placeholder="Usuario" required autofocus>
			<input type="password" id="psw" class="form-control" placeholder="Contrase&ntilde;a" required>
			<input type="text" id="nombre" class="form-control" placeholder="Nombre" required>
			<input type="text" id="apellido" class="form-control" placeholder="Apellido" required>
			<input type="text" id="dni" class="form-control" placeholder="D.N.I" required>
			<div class="checkbox mb-3">
        <label>
          <input type="checkbox" id="social"> Solicitar tarifa social
        </label>
      </div>
			<div class="checkbox mb-3">
        <label>
          <input type="checkbox"  id="estudiantil"> Solicitar boleto estudiantil
        </label>
      </div>
			<button id="Registrar" class="btn btn-lg btn-primary btn-block" type="button">Registrar</button>
			
		</form>

	</body>

</html>
