package controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubeDao;
import negocio.*;
import datos.*;

public class ControladorSimularViaje extends HttpServlet {

	protected void doGet(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {		
		procesarPeticion( request , response );
	}	
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {		
			SubeDao subeDao = new SubeDao();
					
			int transporte = Integer.parseInt(request.getParameter("transporte"));	
			
			int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));		
			
			Sube sube = subeDao.traerSube(numeroSube);			
			
			request.setAttribute("sube", sube);		
			
			if (transporte == 1) request.getRequestDispatcher("/terminalesSubte.jsp").forward(request, response);
			
			if (transporte == 2) request.getRequestDispatcher("/terminalesTren.jsp").forward(request, response);
			
			if (transporte == 3) request.getRequestDispatcher("/terminalesColectivo.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			response.sendError(500, "Error en ControladorSimularViaje.");
			
		}
	}
}