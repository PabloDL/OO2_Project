package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.PersonaABM;
import negocio.UsuarioABM;
import datos.Persona;
import datos.Sube;
import datos.Usuario;

public class ControladorAgregarPersonaJSP extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = "correcto";
		try {
			PersonaABM personaabm = new PersonaABM();
			UsuarioABM usuarioabm = new UsuarioABM();

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));

			boolean esTarifaSocial = request.getParameter("social").compareTo("false") != 0;
			boolean esTarifaEstudiantil = request.getParameter("estudiantil").compareTo("false") != 0;
			String nombreUsuario = request.getParameter("usr");
			String password = request.getParameter("psw");

			Sube s = new Sube();
			Persona persona = personaabm.traerPersona(dni);
			Usuario usuario = usuarioabm.traerUsuario(nombreUsuario);
			
			if (persona != null )
				throw new Exception("ERROR DNI YA INGRESADO");
			if (usuario != null )
				throw new Exception("ERROR USUARIO EXISTENTE");
				
			long ultimoIdCliente = personaabm.agregar(apellido, nombre, dni, esTarifaSocial, esTarifaEstudiantil);
			long ultimoIdUsuario = usuarioabm.agregar(nombreUsuario, password, ultimoIdCliente);
			// SI LA AGREGUE OK, LO MUESTRO POR PANTALLA
			//persona = personaabm.traerPersona(dni);
			//			request.setAttribute("persona", persona);
			//request.getRequestDispatcher("/vistapersona.jsp").forward(request, response);
			
		} catch (Exception e) {
			text = e.getMessage().toString();
		}
		finally {
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    response.getWriter().write(text);       // Write response body.
		}
	}
}