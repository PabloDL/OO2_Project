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
	public boolean cobrar(int tramo, Sube sube) {
		// TODO Auto-generated method stub
		return false;
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
	public float calcularPrecio(Sube sube) {
		// TODO Auto-generated method stub
		return 0;
	}
}
