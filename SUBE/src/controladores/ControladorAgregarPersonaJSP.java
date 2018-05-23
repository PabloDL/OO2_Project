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
		try {
			PersonaABM personaabm = new PersonaABM();
			UsuarioABM usuarioabm = new UsuarioABM();
			
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));
			boolean esTarifaSocial = request.getParameter("esTarifaSocial") != null;
			boolean esTarifaEstudiantil = request.getParameter("esTarifaEstudiantil") != null;
			String nombreUsuario = request.getParameter("nombreUsuario");
			String password = request.getParameter("password");
			
			//if (usuarioabm.traerUsuario(nombreUsuario) == null && personaabm.traerPersona(dni) == null) {
					Sube s = new Sube();
					long ultimoIdCliente = personaabm.agregar(apellido, nombre, dni, esTarifaSocial, esTarifaEstudiantil, s);
					long ultimoIdUsuario = usuarioabm.agregar(nombreUsuario, password, ultimoIdCliente);				
					//SI LA AGREGUE OK, LO MUESTRO POR PANTALLA
					Persona persona = personaabm.traerPersona(dni );
					request.setAttribute( "persona" , persona );
					request.getRequestDispatcher( "/vistapersona.jsp" ).forward( request ,
					response );
//			}
	//		else {
			//	request.setAttribute("msjError", "ERROR");
		//	}
			
		} catch (Exception e) {
			response.sendError(500, "Hubo un problema al agregar al clientes.");
		}
	}
}