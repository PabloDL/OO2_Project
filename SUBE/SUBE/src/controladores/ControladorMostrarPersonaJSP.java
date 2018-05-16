package controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.PersonaABM;
import datos.Persona;

public class ControladorMostrarPersonaJSP extends HttpServlet {

	protected void doGet(HttpServletRequest request , HttpServletResponse response )
		throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
		procesarPeticion( request , response );
	}	
	private void procesarPeticion(HttpServletRequest request , HttpServletResponse
		response ) throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		try {
			int dni = Integer. parseInt ( request .getParameter( "dni" ));
			PersonaABM personaabm = new PersonaABM();
			Persona persona = personaabm.traerPersona( dni );
			request.setAttribute( "persona" , persona );
			request.getRequestDispatcher( "/vistapersona.jsp" ).forward( request ,
			response );
		}
		catch (Exception e ) {
			response .sendError(500, "El DNI Ingresado no existe en la base de datos." );
		}
	}
}