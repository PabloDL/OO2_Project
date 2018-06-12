<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>+
<%@page import="datos.Sube"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	
	<FORM method="POST" action=" /SUBE/terminalesTren"><BR> <BR>
		
		<div align="center">
			<h1> Terminales de Tren</h1><BR>
		
		
		<select name="terminal">
   			 <option value="5">Terminal linea Roca - Ramal Ezeiza - Estacion Constitucion</option>
  			 <option value="9">Terminal linea Roca - Ramal Ezeiza - Estacion Lanus</option>  
  			 <option value="13">Terminal linea Roca - Ramal Ezeiza - Estacion Temperley</option> 
  			 <option value="14">Terminal linea Roca - Ramal Ezeiza - Estacion Llavallol</option> 	 
		</select><BR> <BR>	
		
		<% Sube sube=(Sube) request.getAttribute("sube"); %>	
		
		<input type="hidden" name="numeroSube" value=<%= sube.getNumero() %>>
		
		<INPUT type="submit" value="Finalizar" class="btn btn-lg btn-primary">
		</div>
	</FORM>

</body>
</html>