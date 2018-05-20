package datos;

import java.time.LocalDateTime;

public class Viaje {
	private long idViaje;
	private double tarifa;
	private Transporte transporte;
	private Sube sube;
	private LocalDateTime fechaHoraInicio;
	
	public Viaje() {}
	
	public Viaje(double tarifa, Transporte transporte, Sube s) {
		super();
		this.tarifa = tarifa;
		this.transporte = transporte;
		this.fechaHoraInicio = LocalDateTime.now();
		this.sube = s;
		//GUARDAR LAS FECHA this.fechaHoraInicio = fechaHoraInicio;
	}

	public Sube getSube() {
		return sube;
	}

	public void setSube(Sube sube) {
		this.sube = sube;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public long getIdViaje() {
		return idViaje;
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
	
	@Override
	public String toString() {
		return "\n Viaje [idViaje=" + idViaje + ", tarifa=" + tarifa + ", transporte=" + transporte
				+ ", fechaHoraInicio=" + fechaHoraInicio + "] \n";
	}

}
