<%@page import="funciones.Funciones"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.Viaje"%>
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
			<th>Transporte</th>
		</tr>
		<%List<Viaje> viajes=(List)request.getAttribute("viajes");
		for (Viaje viaje:viajes){%>
		<tr>
			<td>ID: <%=viaje.getIdViaje()%><BR>
			Tarifa: <%=viaje.getTarifa()%><BR>
			Fecha de Inicio: <%=Funciones.traerFechaCorta(viaje.getFechaHoraInicio())%><BR>
			<%=viaje.getTransporte().mostrarTranporte()%></td>	
			
		<%}%>
	</table>
	<BR>
	<A href="/SUBE/index.jsp"> Volver... </A>
</body>
</html>