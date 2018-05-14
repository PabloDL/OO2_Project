package datos;

public class TerminalTren extends Terminal {

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
	
	public int calcularMontoEntreEstaciones() {
		return 0;
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
