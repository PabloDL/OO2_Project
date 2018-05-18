package datos;

import datos.Reporte;

public class ReporteXTransporte extends Reporte {
	private String tipoTransporte;
	
	public ReporteXTransporte(String tipoTransporte) {
		super();
		this.tipoTransporte = tipoTransporte;
	}
	
	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String generar() {
		return null;
	}

}
