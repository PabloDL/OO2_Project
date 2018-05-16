package datos;

import java.time.LocalDateTime;

import datos.DatosGenerales;

public class Tren extends Transporte {
	private String linea;
	private String ramal;
	private String estacionOrigen;
	private String estacionDestino;
	private LocalDateTime fechaHoraSalida;

	public Tren() {}

	public Tren(String linea, String ramal, String estacionOrigen) {
		super();
		this.linea = linea;
		this.ramal = ramal;
		this.setEstacionOrigen(estacionOrigen);
	}

	public float calcularMonto() {
			DatosGenerales datosGenerales = new DatosGenerales();
			return datosGenerales.getMontoTren1();
	}
	
	public double getMontoMaximo() {
		DatosGenerales datosGenerales = new DatosGenerales();
		return datosGenerales.getMontoTren1();  //ACA VA EL MONTO MAXIMO
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

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

}