<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TP - SUBE -AGREGAR PERSONA</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<FORM method="POST" action=" /SUBE/AgregarPersonaJSP">
		Agregar Persona <BR> <BR>
		<TABLE border="0">
			<TR>
				<TD>Nombre:</TD>
				<TD><INPUT name="nombre"></TD>
			<TR>
				<TD>Apellido:</TD>
				<TD><INPUT name="apellido"></TD>
			<TR>
				<TD>DNI:</TD>
				<TD><INPUT name="dni"></TD>
			<TR>
				<TD>Usa Tarifa social:</TD>
				<TD><input type="checkbox" name="esTarifaSocial"></TD>
			<TR>
				<TD>Usa Boleto estudiantil:</TD>
				<TD><input type="checkbox" name="esTarifaEstudiantil"></TD>
			<TR>
				<TD>nombre de usuario:</TD>
				<TD><INPUT name="nombreUsuario"></TD>
			<TR>
				<TD>password:</TD>
				<TD><input type="Password" name="password" onkeyup="this.form.hash.value = MD5(this.form.pass.value)"><br />
				</TD>
			<TR>
				<TD><INPUT type="submit" value="Agregar"></TD>
			<TR>
			</TR>
		</TABLE>
	</FORM>

</body>
</html>