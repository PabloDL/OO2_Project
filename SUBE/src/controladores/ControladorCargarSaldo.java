package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.DatosFuncionalesABM;
import negocio.PersonaABM;
import negocio.SubeABM;
import negocio.UsuarioABM;
import datos.DatosFuncionales;
import datos.Persona;
import datos.Usuario;

public class ControladorCargarSaldo extends HttpServlet {
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
		String msj = "";
		try {
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usr");
			DatosFuncionalesABM dfABM = DatosFuncionalesABM.getInstance();
			DatosFuncionales df = dfABM.traer();
			double recarga = Integer.parseInt(request.getParameter("recarga"));		

			
			PersonaABM pABM = new PersonaABM();
			SubeABM sABM = new SubeABM();
			
			Persona p = pABM.traerPersona(usuario.getIdUsuario());
			double nuevoSaldo = p.getSube().getSaldo() + recarga;
			if (recarga >= 0 && nuevoSaldo <  df.getSaldoMaximo()) {
				p.getSube().setSaldo(nuevoSaldo);
				sABM.actualizar(p.getSube());
				msj = "Recarga correcta!!!";
			}
			else if (recarga <= 0 ) {
				msj = "No se puede cargar saldo negativo!!!";
			}
			else if (nuevoSaldo >  df.getSaldoMaximo() ) {
				msj = "No se puede cargar mas alla del monto maximo!!!";
			}
			request.setAttribute("saldo",p.getSube().getSaldo());
			request.setAttribute("msj",msj);
			request.getRequestDispatcher("/vistaRecarga.jsp").forward(request, response);
			
		}
		catch (Exception e ) {
			response .sendError(500, "El DNI Ingresado no existe en la base de datos." );
		}
	}
}

