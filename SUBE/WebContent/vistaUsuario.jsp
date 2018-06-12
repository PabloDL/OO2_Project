<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>TRABAJO PRACTICO - SUBE</TITLE>
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>

	<FORM method="POST" action=" /SUBE/MostrarViaje ">
		<h1>
			Bienvenido, 
			<%=request.getAttribute("nombrePersona")%>
			<%=request.getAttribute("apellidoPersona")%>
		</h1>
		<h3>
			Numero Sube:
			<%=request.getAttribute("numeroSube")%></h3>
		<INPUT type="hidden" name="numeroSube"
			value=<%=request.getAttribute("numeroSube")%>>
		<TABLE border="1">
			<TR>
				<TD><INPUT type="submit" value="Consultar viajes" class="btn btn-lg btn-primary"></TD>
			</TR>
		</TABLE>
	</FORM>
	<FORM method="POST" action=" /SUBE/vincularSube">
		<TABLE border="0">
			<TR>
				<h3>Vincular sube</h3>
			</TR>
			<TR>
				<TD>Numero Sube:</TD>
				<TD><INPUT name="numeroSube" required></TD>
			</TR>
			<TR>
				<TD>DNI:</TD>
				<TD><%=request.getAttribute("dni")%></TD>
			</TR>
		</TABLE>
		<INPUT type="submit" value="Siguiente" class="btn btn-lg btn-primary">
	</FORM>
	
	<FORM method="POST" action="/SUBE/recargarSaldo">
		<TABLE border="0">
			<tr>
				<h3>Recargar Saldo</h3>
			</TR>
			<TR>
				<TD>Saldo a recargar</TD>
				<TD><INPUT name="recarga" required></TD>
			</TR>
		</TABLE>
		<INPUT type="submit" value="Recargar Saldo" class="btn btn-lg btn-primary">
	</FORM>
	
	<FORM method="POST" action="/SUBE/consultarSaldo">
		<INPUT type="submit" value="Consultar Saldo" class="btn btn-lg btn-primary">
	</FORM>
</BODY>
</HTML>