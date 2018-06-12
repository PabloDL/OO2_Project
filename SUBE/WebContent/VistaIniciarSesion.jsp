<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Iniciar session</title>

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
				$( '#Iniciar' ).click( function () {
					var usr = $('#usr').val();
					var psw =  $('#psw').val();
					
					$.ajax({
					    type: "post",
					    url: "/SUBE/IniciarSesionJSP",
					    data:{ usr: usr ,
					    	psw: psw },
					    success: function (data, text) {
					        if(data == "correcto"){					        	
					        	   location.href ="/SUBE/StartPage";
					        }
					        else{
					        	alert("usuario incorrecto: " + data);
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
			<IMG src="/SUBE/images/Logo.jpg">
			<h1 class="h3 mb-3 font-weight-normal">Por favor inicie sesion</h1>
			<input id = "usr" type="text" id="inputEmail" class="form-control" autofocus>
			<input type="password" id="psw" class="form-control" placeholder="Contrase&ntilde;a" >

			<button id="Iniciar" class="btn btn-lg btn-primary btn-block" type="button">Iniciar</button>
			<div class="text-center">
				<p>No tiene una cuenta?
					<a href="VistaRegistrar.jsp">Registrese</a>
				</p>
			</div>
		</form>
	</body>
</html>
