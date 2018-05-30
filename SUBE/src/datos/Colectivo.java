package datos;

public class Colectivo extends Transporte {
	
	private long idColectivo;
	private String linea;
	private int numero;
	private String ramal;
	
	public Colectivo() {}
	
	public Colectivo(String linea, int numero, String ramal) {
		super();
		this.linea = linea;
		this.numero = numero;
		this.ramal = ramal;
	}
	
	public long getIdColectivo() {
		return idColectivo;
	}

	protected void setIdColectivo(long idColectivo) {
		this.idColectivo = idColectivo;
	}
	
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
	@Override
	public String toString() {
		return "Colectivo: " +"<BR>"+ "\nLinea= " + linea +"<BR>"+ "\nNumero= " + numero + ", Ramal= " + ramal;
	}
}
