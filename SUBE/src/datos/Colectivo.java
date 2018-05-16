package datos;

public class Colectivo extends Transporte {
	private String linea;
	private int numero;
	private String ramal;
	
	public Colectivo() {
		
	}
	
	public Colectivo(String linea, int numero, String ramal) {
		super();
		this.linea = linea;
		this.numero = numero;
		this.ramal = ramal;
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
	public double calcularMonto() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
