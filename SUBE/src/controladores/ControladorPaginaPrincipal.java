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

public class ControladorPaginaPrincipal extends HttpServlet {
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
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usr");  
			
			PersonaABM pABM = new PersonaABM();
			SubeABM sABM = new SubeABM();
			
			Persona p = pABM.traerPersona(usuario.getIdUsuario());
			
			
			request.setAttribute("nombrePersona", p.getNombre());
			request.setAttribute("apellidoPersona", p.getApellido());
			request.setAttribute("dni", p.getDni());
			
			if (p.getSube() != null) {
				request.setAttribute("numeroSube", p.getSube().getNumero());
			}
			
			if (!usuario.isAdministrador())
				request.getRequestDispatcher("/vistaUsuario.jsp").forward(request, response);
			else 
				request.getRequestDispatcher("/vistaAdministrador.jsp").forward(request, response);
			
		}
		catch (Exception e ) {
			response .sendError(500, "El DNI Ingresado no existe en la base de datos." );
		}
	}
}

