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
		return "";
	}
	
	public String mostrarTranporte() {
		if (this instanceof Tren)
			return ((Tren)this).toString();
		else if (this instanceof Colectivo)
			return ((Colectivo)this).toString();
		else 
			return ((Subte)this).toString();
	}
	
}
