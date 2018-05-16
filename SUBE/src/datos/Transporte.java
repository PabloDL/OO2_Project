package datos;

public abstract class Transporte {
	
	private long idTransporte;

	
	
	public Transporte() {}



	public long getIdTransporte() {
		return idTransporte;
	}



	protected void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}

	
	abstract public double calcularMonto();
			
}
