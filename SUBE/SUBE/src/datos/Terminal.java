package datos;

import java.util.List;
import datos.Viaje;

public abstract class Terminal {
	protected List<Viaje> viajes;

	public abstract boolean registrarPago(long idSube);

	public abstract boolean informarViajes();

	public abstract boolean cobrar(int tramoAcobrar, Sube sube) ;
	
	public abstract float calcularPrecio(Sube sube);
	
}
