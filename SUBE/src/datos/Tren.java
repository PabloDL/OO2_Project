package datos;

import java.util.GregorianCalendar;

import datos.DatosFuncionales;

public class Tren extends Transporte {
	private long idTren;
	private String linea;
	private String ramal;
	private String estacionOrigen;
	private String estacionDestino;
	private GregorianCalendar fechaHoraSalida;

	public Tren() {}

	public Tren(String linea, String ramal, String estacionOrigen) {
		super();
		this.linea = linea;
		this.ramal = ramal;
		this.setEstacionOrigen(estacionOrigen);
		this.estacionDestino = "-";
	}
	
	public long getIdTren() {
		return idTren;
	}

	protected void setIdTren(long idTren) {
		this.idTren = idTren;
	}


	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEstacionOrigen() {
		return estacionOrigen;
	}

	public void setEstacionOrigen(String estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public String getEstacionDestino() {
		return estacionDestino;
	}

	public void setEstacionDestino(String estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public GregorianCalendar getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(GregorianCalendar fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public double getMontoEntreEstaciones(String estacion) {
	//	Seccion seccion = 
		return 0;
	}
	
	public double calcularMonto() {
		DatosFuncionales df = DatosFuncionales.getInstanciaDatosGenerales();
		return df.getPrecioMaximoTren();
	}


	public double getMontoMaximo() {
		DatosFuncionales datosGenerales = new DatosFuncionales();
		return datosGenerales.getPrecioMaximoTren();
	}


}