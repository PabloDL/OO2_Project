<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabajo practico - Sube</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<BR>
	<BR>
	<table border="1" align="center">
		<tr>
			<th>Persona</th>
			<th>DNI</th>
			<th>tarifa social</th>
			<th>boleto estudiantil</th>
			<th>Nombre de Usuario</th>
		</tr>
		<c:forEach items="${personas}" var="persona">
			<tr>
				<td>${persona.apellido} , ${persona.nombre}</td>
				<td>${persona.dni}</td>
				<td>${persona.esTarifaSocial}</td>
				<td>${persona.esTarifaEstudiantil}</td>
				<td>${persona.usuario.nombreUsuario}</td>
			</tr>
		</c:forEach>
	</table>
	<BR>
	<center> 
	<a href="/SUBE/index.jsp"><button>Volver</button></a> 
	</center>
</body>
</html>