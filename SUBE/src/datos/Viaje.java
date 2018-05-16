package datos;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Viaje {
	private long idViaje;
	private double tarifa;
	Transporte transporte;
	private LocalDateTime fechaHoraInicio;
	
	public long getIdViaje() {
		return idViaje;
	}
	
	public Viaje() {
		super();
	}
	
	public Viaje(double tarifa, Transporte transporte) {
		super();
		this.tarifa = tarifa;
		this.transporte = transporte;
		this.fechaHoraInicio = LocalDateTime.now();
		//GUARDAR LAS FECHA this.fechaHoraInicio = fechaHoraInicio;
	}
	
	
	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setIdTransporte(Transporte idTransporte) {
		this.transporte = idTransporte;
	}
	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	
	@Override
	public String toString() {
		return "\n Viaje [idViaje=" + idViaje + ", tarifa=" + tarifa + ", transporte=" + transporte
				+ ", fechaHoraInicio=" + fechaHoraInicio + "] \n";
	}
		
	public float calcular() {
		return 0;
	}

	public float calcularMonto(float descuentoAAplicar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void agregarDestinoAViaje(Viaje viaje) {
		// SOLO tren admite setear salida, si quiero agregar los otros deberia definirlo
		String estacionDestino  = ((Tren)this.getTransporte()).getEstacionOrigen();
		LocalDateTime fechaHoraSalida = ((Tren)this.getTransporte()).getFechaHoraSalida();
		double tarifaFinal  = -viaje.getTarifa();
		//SETEO LOS VALORES EN EL TRANSPORTE
		((Tren)this.getTransporte()).setEstacionDestino(estacionDestino);
		((Tren)this.getTransporte()).setFechaHoraSalida(fechaHoraSalida);
		this.setTarifa(tarifaFinal);
	}

}
