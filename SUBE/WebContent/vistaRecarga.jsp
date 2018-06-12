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
	<h1 class="h3 mb-3 font-weight-normal" align="center" id="msj"> <%=request.getAttribute("msj")%></h1>	
	<h1 class="h3 mb-3 font-weight-normal" align="center">nuevo saldo: <%=request.getAttribute("saldo")%></h1>
	<center>
		<a href="/SUBE/StartPage"><button class="btn btn-lg btn-primary">Volver a inicio</button></a>
	</center>
</BODY>
</html>