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
import datos.Sube;
import datos.Usuario;

import static java.lang.Math.toIntExact;
public class ControladorAltaSube extends HttpServlet {
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
			if (!usuario.isAdministrador())
				request.getRequestDispatcher("/errorPermisos.jsp").forward(request, response);
			//if (session.getAttribute("usr") != null )
			//request.getRequestDispatcher("/IniciarSesionJSP").forward(request, response);
			
			SubeABM subeABM = new SubeABM();			
			
			int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));
			
			if(subeABM.traerSube(numeroSube) != null) throw new ServletException();
			
			Sube sube = new Sube();		
			sube.setNumero(numeroSube);
			sube.setSaldo(0);
			subeABM.agregar(sube);
			
			request.getRequestDispatcher("/altaSubeExitosa.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, "Hubo un problema al agregar la sube.");
		}
	}
}
