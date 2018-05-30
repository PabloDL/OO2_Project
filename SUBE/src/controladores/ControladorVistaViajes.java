package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubeDao;
import negocio.SubeABM;
import negocio.ViajeABM;
import datos.Sube;
import datos.Viaje;

@SuppressWarnings("serial")
public class ControladorVistaViajes extends HttpServlet {
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
		
		int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));
		try {
			ViajeABM Viajeabm = new ViajeABM();
			SubeABM subeabm = new SubeABM();
			Sube s = subeabm.traerSube(numeroSube);
			List<Viaje> Viajes = Viajeabm.traerViaje(s);
			request.setAttribute("viajes", Viajes);
			
			SubeDao subeDao = new SubeDao();
			Sube sube = subeDao.traerSube(numeroSube);			
			request.setAttribute("sube", sube);
			
			request.getRequestDispatcher("/vistaviajes.jsp").forward(request, response);
	
		} catch (Exception e) {
			response.sendError(500, "Hubo un problema al traer el listado de clientes.");
		}
	}
}