package controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.*;
import datos.*;

public class ControladorTerminalesColectivo extends HttpServlet {

	protected void doGet(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		procesarPeticion( request , response );
	}	
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {			
						
			TerminalColectivoABM terminalColectivoABM = new TerminalColectivoABM();
			
			int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));
			
			int idTerminal = Integer.parseInt(request.getParameter("terminal"));
			
			int tramo = Integer.parseInt(request.getParameter("tramo"));
			
			terminalColectivoABM.agregarViaje(numeroSube, idTerminal,tramo);
			
			request.getRequestDispatcher("/viajeExitoso.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			response.sendError(500, "Error en ControladorTerminalesColectivo.");
			
		}
	}
}