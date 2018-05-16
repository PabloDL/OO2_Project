<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.Persona"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TRABAJO PRACTICO - SUBE</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<BR> Listado Sin utilizar JSTL
	<table border="1">
		<tr>
			<th>Persona</th>
			<th>tarifa social</th>
			<th>boleto estudiantil</th>
			<th>DNI</th>
		</tr>
		<%List<Persona> personas=(List)request.getAttribute("personas");
for (Persona persona:personas){%>
		<tr>
			<td><%=persona.getApellido()+ ", " +persona.getNombre()%></td>
			<td><%=persona.usaBoletoEstudiantil()%></td>
			<td><%=persona.usaTarifaSocial()%></td>
			<td><%=persona.getDni()%></td>
		</tr>
		<%}%>
	</table>
	<BR>
	<A href="/SUBE/index.jsp"> Volver... </A>
</body>
</html>