package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.PersonaABM;
import negocio.UsuarioABM;
import datos.Persona;
import datos.Usuario;

public class ControladorIniciarSesion extends HttpServlet {
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
			UsuarioABM usrABM = new UsuarioABM();
			String usuario = request.getParameter("usr");
			String password = request.getParameter("psw");
			
			Usuario u = usrABM.traerUsuario(usuario);
			if (u == null || (u.getPassword()).compareTo(password) != 0)
				throw new Exception("ERROR PASSWORD O USUARIO INVALIDO");
			
			//PersonaABM pAbm = new PersonaABM();
		//	Persona p = pAbm.traerPersona(u.getIdUsuario());
				
			//ARMO LA SESION PARA VALIDAR USUARIO EN FORMULARIOS
			HttpSession session = request.getSession();
			session.setAttribute("usr", u);  
		
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