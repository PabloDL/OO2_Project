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
		
		<div align="left">
			<h1> Terminales de Tren</h1><BR>
		</div>
		
		<select name="terminal">
   			 <option value="5">Terminal linea Roca - Ramal Ezeiza - Estacion Constitucion</option> 
  			 <option value="6">Terminal linea Roca - Ramal Ezeiza - Estacion Irigoyen</option> 	
  			 <option value="7">Terminal linea Roca - Ramal Ezeiza - Estacion Avellaneda</option> 
  			 <option value="8">Terminal linea Roca - Ramal Ezeiza - Estacion Gerli</option> 
  			 <option value="9">Terminal linea Roca - Ramal Ezeiza - Estacion Lanus</option> 
  			 <option value="10">Terminal linea Roca - Ramal Ezeiza - Estacion Escalada</option> 
  			 <option value="11">Terminal linea Roca - Ramal Ezeiza - Estacion Banfield</option> 
  			 <option value="12">Terminal linea Roca - Ramal Ezeiza - Estacion Lomas de Zamora</option> 
  			 <option value="13">Terminal linea Roca - Ramal Ezeiza - Estacion Temperley</option> 
  			 <option value="14">Terminal linea Roca - Ramal Ezeiza - Estacion Llavallol</option> 
  			 <option value="15">Terminal linea Roca - Ramal Ezeiza - Estacion Turdera</option> 		 
		</select><BR> <BR>	
		
		<% Sube sube=(Sube) request.getAttribute("sube"); %>	
		
		<input type="hidden" name="numeroSube" value=<%= sube.getNumero() %>>
		
		<INPUT type="submit" value="Siguiente">
		
	</FORM>

</body>
</html>