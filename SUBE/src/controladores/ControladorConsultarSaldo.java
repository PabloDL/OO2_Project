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

public class ControladorConsultarSaldo extends HttpServlet {
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
			
			Persona p = pABM.traerPersona(usuario.getIdUsuario());

			request.setAttribute("saldo",p.getSube().getSaldo());
			request.getRequestDispatcher("/vistaConsultaSaldo.jsp").forward(request, response);
			
		}
		catch (Exception e ) {
			response .sendError(500, "El DNI Ingresado no existe en la base de datos." );
		}
	}
}

