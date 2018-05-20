package datos;

import datos.DatosGenerales;

public class Subte extends Transporte{
	private long idSubte;
	private String linea;
	
	public Subte() {}

	public Subte(String linea) {
		super();
		this.linea = linea;
	}
	
	public String getlinea() {
		return linea;
	}

	public void setlinea(String linea) {
		this.linea = linea;
	}

	public float calcularMonto() {
			DatosGenerales datosGenerales = new DatosGenerales();
			return datosGenerales.getMontoSubte();
	}

	public long getIdSubte() {
		return idSubte;
	}

	public void setIdSubte(long idSubte) {
		this.idSubte = idSubte;
	}

}
