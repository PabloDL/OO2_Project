package datos;

public class TerminalRecarga extends Terminal {

	@Override
	public boolean registrarPago(long idSube) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean informarViajes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Viaje cobrar(Sube sube, int tramo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean registrarRecarga(long idSube) {
		return false;
	}

	public float consultarSaldo(long idSube) {
		return 0;
	}

	public boolean aplicarBoletoEstudiantil(long idSube) {
		return false;
	}

	public boolean aplicarTarifaSocial(long idSube) {
		return false;
	}

	public float calcularDescuento(Sube sube) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPrecio(Sube sube, int tramo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean verificarSaldoSuficiente(Sube sube, double precioBoleto) {
		// TODO Auto-generated method stub
		return false;
	}
}
