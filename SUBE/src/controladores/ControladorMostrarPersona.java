package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Persona;
import negocio.PersonaABM;;


public class ControladorMostrarPersona extends HttpServlet {
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
		response.setContentType("text/html;charset=UTF-8");
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			PersonaABM personaAbm = new PersonaABM();
			Persona persona = personaAbm.traerPersona(dni);
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println("<HEAD>");
			salida.println("<TITLE>TRABAJO PRACTICO - SUBE </TITLE>");
			salida.println("</HEAD>");
			salida.println("<BODY>");
			salida.println("Apellido:" + persona.getApellido() + "<BR>");
			salida.println("Nombre:" + persona.getNombre() + "<BR>");
			salida.println("Tarifa Social" + persona.usaTarifaSocial() + "<BR>");
			salida.println("Tarifa Estudiantial:" + persona.usaBoletoEstudiantil() + "<BR>");
			salida.println("DNI:" + persona.getDni() + "<BR>");
			salida.println("ID:" + persona.getIdPersona() + "<BR>");
			salida.println("<A href=\"/SUBE/persona.html\">Volver...</A>");
			salida.println("</BODY>");
			salida.println("</HTML>");
		} catch (Exception e) {
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
}
