package datos;

public class TerminalColectivo extends Terminal {

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

	public boolean cobrar(Sube sube) {
		// TODO Auto-generated method stub
		return false;
	}

	public float calcularDescuento(Sube sube) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean cobrar(int tramoAcobrar, Sube sube) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float calcularPrecio(Sube sube) {
		// TODO Auto-generated method stub
		return 0;
	}

}
