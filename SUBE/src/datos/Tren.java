package datos;

import java.util.GregorianCalendar;

import datos.DatosGenerales;
import negocio.EstacionABM;
import negocio.SeccionABM;

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

	public float getMontoEntreEstaciones() {	
		//Traigo las estaciones por nombre y traigo 
		//el monto de la seccion por las estaciones.
		SeccionABM sec = new SeccionABM();
		EstacionABM est = new EstacionABM();
		Estacion origen = est.traerEstacion(this.estacionOrigen);
		Estacion destino = est.traerEstacion(this.estacionOrigen);
		
		return(sec.traerSeccion(origen, destino).getPrecio());
	}
	
	public float calcularMonto() {
		DatosGenerales datosGenerales = new DatosGenerales();
		return datosGenerales.getPrecioMaximoTren();
	}

	public double getMontoMaximo() {
		DatosGenerales datosGenerales = new DatosGenerales();
		return datosGenerales.getPrecioMaximoTren();
	}

}