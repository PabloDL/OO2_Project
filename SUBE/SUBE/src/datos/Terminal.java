package datos;

import java.util.List;
import datos.Viaje;

public abstract class Terminal {
	protected List<Viaje> viajes;

	public abstract boolean registrarPago(long idSube);

	public abstract boolean informarViajes();

	public abstract Viaje cobrar(Sube sube, int tramoAcobrar) ;
	
	public abstract double calcularPrecio(Sube sube, int tramoACobrar);
	
	public abstract boolean verificarSaldoSuficiente(Sube sube, double precioBoleto);
	
}
