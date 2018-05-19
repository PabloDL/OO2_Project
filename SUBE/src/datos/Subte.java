package datos;

import datos.DatosGenerales;

public class Subte extends Transporte{
	private long idSubte;
	private String letra;
	
	public Subte() {}

	public Subte(String letra) {
		super();
		this.letra = letra;
	}
	
	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public float calcularMonto() {
			DatosGenerales datosGenerales = new DatosGenerales();
			return datosGenerales.getMontoSubte();
	}

}
