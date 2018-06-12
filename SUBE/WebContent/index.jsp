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
	
	<BR><input type="submit" value="Simular viaje" onclick = "location='/SUBE/agregarViaje.jsp'"/><BR><BR><BR>
	
	<BR><input type="submit" value="Alta y baja de sube" onclick = "location='/SUBE/subeABM.jsp'"/><BR><BR><BR>
	
	<FORM method="POST" action=" /SUBE/MostrarViaje ">
		<h3>Búsqueda de viajes </h3>
		<TABLE border="1">
			<TR>
				<TD>Numero Sube:</TD>
				<TD><INPUT name="numeroSube" required></TD>
			</TR>
			<TR>
				<TD><INPUT type="submit" value="Consultar"></TD>
			</TR>
		</TABLE>
	</FORM>
	<FORM method="POST" action=" /SUBE/MostrarPersonaJSP ">
		<BR><h3>Búsqueda de personas</h3>
		<TABLE border="1">
			<TR>
				<TD>DNI:</TD>
				<TD><INPUT name="dni" required></TD>
			</TR>
			<TR>
				<TD><INPUT type="submit" value="Consultar"></TD>
			</TR>
		</TABLE>
	</FORM>
</BODY>
<BR>
<BR>
<BR>
<BR>
<FORM method="POST" action="/SUBE/ListarPersonas">
	<input type="hidden" name="jstl" value="0" />
	<TABLE border="0">
		<TR>
			<TD><INPUT type="submit" value="Listar Personas"></TD>
		</TR>
	</TABLE>
</FORM>
<BR>
<BR>
<BR>
<BR>
<FORM method="POST" action="/SUBE/ListarPersonas">
	<input type="hidden" name="jstl" value="1" />
	<TABLE border="0">
		<TR>
			<TD><INPUT type="submit" value="Listar Personas con JSTL">
			</TD>
		</TR>
	</TABLE>
</FORM>
<BR>
<BR>
<BR>
<BR>
<BR>
</HTML>