package controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.*;
import datos.*;

public class ControladorTerminalesSubte extends HttpServlet {

	protected void doGet(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		procesarPeticion( request , response );
	}	
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {	
			
			
			TerminalSubteABM terminalSubteABM = new TerminalSubteABM();
			
			int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));
			
			int idTerminal = Integer.parseInt(request.getParameter("terminal"));
			
			terminalSubteABM.agregarViaje(numeroSube, idTerminal);
			
			request.getRequestDispatcher("/viajeExitoso.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			
			response.sendError(500, "Error en ControladorTerminalesSubte." + e.getMessage());
			
		}
	}
}