package datos;

import java.util.GregorianCalendar;

import datos.Reporte;

public class ReporteXFecha extends Reporte {
	private GregorianCalendar inicio;
	private GregorianCalendar fin;
	
//CONSTRUCTORES
	public ReporteXFecha (GregorianCalendar inicio, GregorianCalendar fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
//GETTERS, SETTERS
	public GregorianCalendar getInicio() {
		return inicio;
	}

	public void setInicio(GregorianCalendar inicio) {
		this.inicio = inicio;
	}

	public GregorianCalendar getFin() {
		return fin;
	}

	public void setFin(GregorianCalendar fin) {
		this.fin = fin;
	}

//METODOS ESPECIFICOS
	public String generar() {
		return "v.fecha BETWEEN " + this.inicio + " AND " + this.fin; 
	}
}
