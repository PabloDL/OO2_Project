package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.PersonaABM;
import negocio.SubeABM;
import negocio.UsuarioABM;
import datos.Persona;
import datos.Usuario;

public class ControladorValidarLogin extends HttpServlet {
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
			HttpSession session = request.getSession();
				
			if (session.getAttribute("usr") == null )
				text = "no logueado";
			
		}
		catch (Exception e ) {
			response .sendError(500, "Error al verificar usuario");
		}
	}
}

