<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/SUBE/favicon.ico">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/started-template.css" rel="stylesheet">
</head>
<body>
	<TABLE border="0" width="100%">
		<TR>
			<TD align="left"><IMG src="/SUBE/images/Logo.jpg"></TD>
			<TD align="center">
				<div class="started-template">
					<h1>TP SUBE - ORIENTACION A OBJETOS II</h1>
					<p class="lead">Grupo 7</p>
				</div>

			</TD>
			<TD align="right">
				<a href="/SUBE/loginError.jsp" ><button id="Logout" class="btn btn-link"
					type="button">Salir</button></a>
			</TD>
		 	<%HttpSession nsession = request.getSession();
			   if (session.getAttribute("usr") == null )
	   				request.getRequestDispatcher("/").forward(request, response); %>
		</TR>
	</TABLE>
	<HR>
</body> 
	</html>

	