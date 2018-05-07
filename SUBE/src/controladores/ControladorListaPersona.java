package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.PersonaABM;
import datos.Persona;

public class ControladorListaPersona extends HttpServlet {
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
		int jstl = Integer.parseInt(request.getParameter("jstl"));
		try {
			PersonaABM personaabm = new PersonaABM();
			List<Persona> personas = personaabm.traerPersona();
			request.setAttribute("personas", personas);
			if (jstl == 0)
				request.getRequestDispatcher("/vistalistapersona.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/vistalistapersonajstl.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Hubo un problema al traer el listado de clientes.");
		}
	}
}