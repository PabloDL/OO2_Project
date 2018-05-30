package datos;

import datos.DatosFuncionales;

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

	public double calcularMonto() {
			DatosFuncionales df = DatosFuncionales.getInstanciaDatosGenerales();
			return df.getPrecioMinimoSubte();
	}

	public long getIdSubte() {
		return idSubte;
	}

	public void setIdSubte(long idSubte) {
		this.idSubte = idSubte;
	}

	@Override
	public String toString() {
		return "Subte: " +"<BR>"+ "\nLinea= " + linea;
	}
}
