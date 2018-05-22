package datos;

import javax.persistence.GeneratedValue;

public class Transporte {
	@GeneratedValue
	private long idTransporte;
	
	public Transporte(){}

	public long getIdTransporte() {
		return idTransporte;
	}

	protected void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idTransporte + "]";
	}		
}
