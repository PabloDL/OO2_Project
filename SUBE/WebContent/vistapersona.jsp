<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.Persona"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TRABAJO PRACTICO - SUBE</title>
</head>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	<%
		Persona persona = (Persona) request.getAttribute("persona");
	%>
	<div align="center">
		<BR> Apellido:
		<%=persona.getApellido()%>
		<BR> Nombre :
		<%=persona.getNombre()%>
		<BR> DNI :
		<%=persona.getDni()%>
		<BR> ID :
		<%=persona.getIdPersona()%>
		<BR>
	</div>
	<BR>
	<center>
		<a href="javascript:window.history.back();"><button>Volver</button></a>
	</center>
</BODY>
</html>