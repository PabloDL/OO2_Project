package datos;

import datos.Reporte;

public class ReporteXTramo extends Reporte{
	private int tramo;
	
	public ReporteXTramo(int tramo) {
		super();
		this.tramo = tramo;
	}

	public int getTramo() {
		return tramo;
	}

	public void setTramo(int tramo) {
		this.tramo = tramo;
	}



	public String generar() {
		return null;
	}

}
