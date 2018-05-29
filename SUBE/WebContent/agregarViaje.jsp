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
	
	<FORM method="POST" action=" /SUBE/agregarViaje"><BR> <BR>
		<TABLE border="0">
					
			<TR>		
				<TD>Numero Sube:</TD>
				<TD><INPUT name="numeroSube"></TD>		
			</TR>			
		</TABLE>		
		
		<input type="radio" name="transporte" value="1" /> Subte <br/>
		<input type="radio" name="transporte" value="2" /> Tren <br/>
		<input type="radio" name="transporte" value="3" /> Colectivo <br/>
		
		<INPUT type="submit" value="Siguiente">
		
	</FORM>

</body>
</html>