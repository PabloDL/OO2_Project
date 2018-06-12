<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	
	<FORM method="POST" action=" /SUBE/altaSube">	
		<TABLE border="0">
			<TR>
			<h3>Alta de sube</h3>
			</TR>					
			<TR>		
				<TD>Numero Sube:</TD>
				<TD><INPUT name="numeroSube" required></TD>		
			</TR>			
		</TABLE>	
		
		<INPUT type="submit" value="Siguiente" class="btn btn-lg btn-primary">
		
	</FORM>
	
	<FORM method="POST" action=" /SUBE/bajaSube">
	
		<TABLE border="0">
			<TR>
			<h3>Baja de sube</h3>
			</TR>					
			<TR>		
				<TD>Numero Sube:</TD>
				<TD><INPUT name="numeroSube" required></TD>		
			</TR>			
		</TABLE>	
		
		<INPUT type="submit" value="Siguiente" class="btn btn-lg btn-primary">
		
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
				<TD><INPUT name="dni" required></TD>		
			</TR>			
		</TABLE>	
		
		<INPUT type="submit" value="Siguiente" class="btn btn-lg btn-primary">
		
	</FORM>
	<FORM method="POST" action=" /SUBE/vistaAdministrador.jsp">
		<TABLE border="1">
			<TR>
				<TD><INPUT type="submit" value="Volver" class="btn btn-lg btn-primary"></TD>
			</TR>
		</TABLE>
	</FORM>

</body>
</html>