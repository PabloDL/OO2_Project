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
	
	<FORM method="POST" action=" /SUBE/terminalesSubte"><BR> <BR>
		
		<div align="center">			
			
			<h1> Terminales de Subte </h1><BR>				
			
		
		
		<select name="terminal">
   			 <option value="16">Terminal Subte - Linea "A"</option> 
  			 <option value="17">Terminal Subte - Linea "B"</option> 	
  			 <option value="18">Terminal Subte - Linea "C"</option> 
  			 <option value="19">Terminal Subte - Linea "D"</option> 
  			 <option value="20">Terminal Subte - Linea "E"</option> 
  			 <option value="21">Terminal Subte - Linea "H"</option>   			 
		</select><BR> <BR>		
		
		<% Sube sube=(Sube) request.getAttribute("sube"); %>	
		
		<input type="hidden" name="numeroSube" value=<%= sube.getNumero() %>>
		
		<INPUT type="submit" value="Finalizar">
		</div>
	</FORM>

</body>
</html>