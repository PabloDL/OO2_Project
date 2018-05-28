<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simulacion de viajes en red sube</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#consultar').click(function() {
			var dni = $('#dni').val();
			$.ajax({
				method : "POST",
				url : "MostrarClienteJSP",
				data : {
					dni : dni
				},
				async : false
			}).done(function(data) {
				$("#responsecliente").html(data);
			})
		});
	});
	function traerTerminalTransporte() {
		var idTerminal = $('#inputGroupElegirTerminal').val();
		if (idTerminal != "0") {
			$.ajax({
				method : "POST",
				url : "MostrarTerminal",
				data : {
					idTerminal : idTerminal
				},
				async : false
			}).done(function(data) {
				$("#TerminalesPorTransporte").html(data);
			})
		} else {
			$("#TerminalesPorTransporte").html("");
		}
	}
</script>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<div class="container">
		<form action="/SUBE/agregarViaje" method="post" role="form" data-toggle="validator">
			<c:if test="${empty action}">
				<c:set var="action" value="viajar!" />
			</c:if>
			<input type="hidden" id="action" name="action" value="${action}">
			<input type="hidden" id="idSube" name="idSube" value="${sube.id}">
			<h2>Nuevo Viaje</h2>
			<class="form-group"> 
				<label for="numeroSube" class="control-label col-xs-4">Nro sube:</label> 
				<input type="text" name="numeroSube" id="numeroSube" class="form-control" value="${sube.idSube}" required="true" />

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroupElegirTranposrte">Transporte</label>
				</div>
				<select class="custom-select" id="inputGroupElegirTranposrte" onchange="traerTerminalTransporte();">
					<option selected>transporte...</option>
					<option value="1">Tren</option>
					<option value="2">Colectivo</option>
					<option value="3">Sube</option>
				</select>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroupElegirTerminal">Elegir Terminal</label>
				</div>
				<select class="custom-select" id="inputGroupElegirTerminal">
					<option selected>terminal...</option>
					<option value="1">Tren</option>
					<option value="2">Colectivo</option>
					<option value="3">Sube</option>
				</select>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroupElegirTranposrte">Tramo Colectivo</label>
				</div>
				<select class="custom-select" id="inputGroupElegirTranposrte">
					<option selected>tramo...</option>
					<option value="1">Tramo 1</option>
					<option value="2">Tramo 2</option>
					<option value="3">Tramo 3</option>
					<option value="4">Tramo 4</option>
					<option value="5">Tramo 5</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Viajar!</button>
	</div>
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.js"></script>
</body>
</html>