//package controladores;
//
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import datos.Persona;
//import datos.Sube;
//import datos.TerminalColectivo;
//import datos.TerminalSubte;
//import datos.TerminalTren;
//import datos.Viaje;
//
//public class ControladorSimularViaje  extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request , HttpServletResponse response )
//				throws ServletException, IOException {
//		procesarPeticion( request , response );
//	}
//	
//	protected void doPost(HttpServletRequest request , HttpServletResponse response )
//				throws ServletException, IOException {
//		procesarPeticion( request , response );
//	}
//	
//	private void procesarPeticion(HttpServletRequest request , HttpServletResponse response ) 
//				throws ServletException, IOException {
//		try {
//			
//			String estacionT1 = request.getParameter("estacionE1");
//			String estacionT2 = request.getParameter("estacionE2");
//|			String estacionT3 = request.getParameter("estacionE3");
//			String lineaT1 = request.getParameter("lineaE1");
//			String lineaT2 = request.getParameter("lineaE2");
//			String lineaT3 = request.getParameter("lineaE3");
//			String ramalT1 = request.getParameter("ramalE1");
//			String ramalT2 = request.getParameter("ramalE2");
//			String ramalT3 = request.getParameter("ramalE3");
//			
//			String letraS1 = request.getParameter("letraS1");
//			String letraS2 = request.getParameter("letraS2");
//			
//			//int numeroC1 = Integer.parseInt(request.getParameter("numeroC1"));
//			String lineaC1 = request.getParameter("lineaC1");
//			String ramalC1 = request.getParameter("ramalC1");
//						
//			Persona p1 = new Persona("Perez","juan",33412412, false, false);
//			Sube s = new Sube(1, 1234, p1,  50);
//			
//			TerminalSubte ts1 = new TerminalSubte(letraS1);
//			TerminalSubte ts2 = new TerminalSubte(letraS2);
//			TerminalColectivo tc1 = new TerminalColectivo(lineaC1, ramalC1, 1);
//			TerminalTren tt1 = new TerminalTren(lineaT1,ramalT1,estacionT1);
//			TerminalTren tt2 = new TerminalTren(lineaT2,ramalT2,estacionT2);
//			TerminalTren tt3 = new TerminalTren(lineaT3,ramalT3,estacionT3);
//			
//			Viaje v6 = tt3.cobrar(s, 7);
//			if (v6 != null) {
//				s.agregarViaje(v6);
//			}
//			
//			Viaje v = ts1.cobrar( s, 7);
//			if (v != null) {
//				s.agregarViaje(v);
//			}
//			
//			Viaje v2 = tc1.cobrar(s,1);
//			if (v2 != null) {
//				s.agregarViaje(v2);
//			}
//			
//			Viaje v3 = ts2.cobrar(s,1);
//			if (v3 != null) {
//				s.agregarViaje(v3);
//			}
//			
//			Viaje v4 = tt1.cobrar(s,1);
//			
//			if (v4 != null) {
//				s.agregarViaje(v4);
//			}
//			
//			
//			Viaje v5 = tt2.cobrar(s,1);
//			if (v5 != null) {
//				//PARA TREN HAY QUE VERIFICAR QUE NO SEA -.SI LO ES -> ES UNA LLEGADA, TENGO QUE ACTUALIZAR EL PASAJE
//				s.agregarViaje(v5);
//			}
//
//			//System. out .println( ts1.toString());
//			System. out .println( s.toString());
//			
//		} catch (Exception e) {
//			response.sendError(500, "Problema al generar viaje.");
//		}
//	}
//}

//
//package controladores;
//
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import datos.Persona;
//import datos.Sube;
//import datos.Terminal;
//import datos.TerminalColectivo;
//import datos.TerminalSubte;
//import datos.TerminalTren;
//import datos.Viaje;
//import negocio.SubeABM;
//
//public class ControladorSimularViaje  extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request , HttpServletResponse response )
//				throws ServletException, IOException {
//		procesarPeticion( request , response );
//	}
//	
//	protected void doPost(HttpServletRequest request , HttpServletResponse response )
//				throws ServletException, IOException {
//		procesarPeticion( request , response );
//	}
//	
//	private void procesarPeticion(HttpServletRequest request , HttpServletResponse response ) 
//				throws ServletException, IOException {
//		try { 
//			SubeABM subeABM = new SubeABM();
//			int numeroSube = Integer.parseInt(request.getParameter("numeroSube"));
//			Sube sube = subeABM.traerSube(numeroSube);
//			
//			PrestamoABM prestamoAbm = new​ PrestamoABM();
//			List<Prestamo> lstPrestamos =
//			prestamoAbm.traerListaPrestamos(cliente);
//
//			request.setAttribute("cliente", cliente);
//			request.setAttribute("lstPrestamo", lstPrestamos);
//
//			request.getRequestDispatcher("/ajaxvistacliente.jsp").forward(request , response);
//
//			}
//			catch​ (Exception e) {
//			response.sendError(500, "El DNI Ingresado no existe en la base
//
//			de datos.");
//			}
//	}
//}
