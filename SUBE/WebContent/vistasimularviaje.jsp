<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<FORM method="POST" action=" /SUBE/SimularViajeJsp">
		Simular Viaje <BR> <BR>
		<TABLE border="0">
			<TR>
				<TD>Seleccionar Estaciones de Tren:</TD>
			<TR>
			<TR>
				<TD>Nombre Estacion 1:</TD>
				<TD><INPUT estacionE1=""></TD>
				<TD>Linea:</TD>
				<TD><INPUT lineaE1=""></TD>
				<TD>Ramal:</TD>
				<TD><INPUT ramalE1=""></TD>
			<TR>
			<TR>
				<TD>Nombre Estacion 2:</TD>
				<TD><INPUT estacionE2=""></TD>
				<TD>Linea:</TD>
				<TD><INPUT lineaE2=""></TD>
				<TD>Ramal:</TD>
				<TD><INPUT ramalE2=""></TD>
			<TR>
				<TD>Nombre Estacion 3:</TD>
				<TD><INPUT estacionE3=""></TD>
				<TD>Linea:</TD>
				<TD><INPUT lineaE3=""></TD>
				<TD>Ramal:</TD>
				<TD><INPUT ramalE3=""></TD>
			<TR>
			<TR>
				<TD>Seleccionar terminales Subte:</TD>
			<TR>
			<TR>
				<TD>Letra Terminal 1:</TD>
				<TD><INPUT letraS1=""></TD>
			<TR>
			<TR>
				<TD>Letra terminal 2:</TD>
				<TD><INPUT letraS2=""></TD>
			<TR>
			<TR>
				<TD>Seleccionar terminales Colectivo:</TD>
			<TR>
				<TD>Linea:</TD>
				<TD><INPUT lineaC1=""></TD>
				<TD>Ramal:</TD>
				<TD><INPUT ramalC1=""></TD>
				<TD>numero:</TD>
				<TD><INPUT numeroC1=""></TD>
			<TR>
			<TR>
				<TD><INPUT type="submit" value="simular"></TD>
			<TR>
			</TR>
		</TABLE>
	</FORM>

</body>
</html>