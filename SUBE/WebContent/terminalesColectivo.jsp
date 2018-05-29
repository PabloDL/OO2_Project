<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="datos.Sube"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	
	<FORM method="POST" action=" /SUBE/terminalesColectivo"><BR> <BR>
		
		<div align="left">
			<h1> Terminales de Colectivo</h1><BR>
		</div>
		
		<select name="terminal">
   			 <option value="22">Terminal linea de Colectivo 100 - Ramal 1</option> 
  			 <option value="23">Terminal linea de Colectivo 100 - Ramal 2</option> 	
  			 <option value="24">Terminal linea de Colectivo 100 - Ramal 3</option> 
  			 <option value="25">Terminal linea de Colectivo 295 - Ramal Cordoba</option> 
  			 <option value="26">Terminal linea de Colectivo 295 - Ramal Madariaga</option> 
  			 <option value="27">Terminal linea de Colectivo 295 - Ramal Magan</option> 
  			 <option value="28">Terminal linea de Colectivo 299 - Ramal A</option> 
  			 <option value="29">Terminal linea de Colectivo 299 - Ramal B</option>   			 
		</select><BR> <BR>
		
		<select name="tramo">
   			 <option value="1">Tramo 1</option> 
  			 <option value="2">Tramo 2</option> 	
  			 <option value="3">Tramo 3</option> 
  			 <option value="4">Tramo 4</option> 
  			 <option value="5">Tramo 5</option>   			   			 
		</select><BR> <BR>	
		
		<% Sube sube=(Sube) request.getAttribute("sube"); %>	
		
		<input type="hidden" name="numeroSube" value=<%= sube.getNumero() %>>
		
		<INPUT type="submit" value="Siguiente">
		
	</FORM>

</body>
</html>