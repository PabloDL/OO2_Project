package datos;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Viaje {
	private long idViaje;
	private float tarifa;
	Transporte transporte;
	private LocalDateTime fechaHoraInicio;
	
	public long getIdViaje() {
		return idViaje;
	}
	
	public Viaje() {
		super();
	}
	
	public Viaje(float tarifa, Transporte transporte) {
		super();
		this.tarifa = tarifa;
		this.transporte = transporte;
		this.fechaHoraInicio = LocalDateTime.now();
		//GUARDAR LAS FECHA this.fechaHoraInicio = fechaHoraInicio;
	}
	
	
	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
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
		return "Viaje [idViaje=" + idViaje + ", tarifa=" + tarifa + ", transporte=" + transporte
				+ ", fechaHoraInicio=" + fechaHoraInicio + "]";
	}
		
	public float calcular() {
		return 0;
	}

	public float calcularMonto(float descuentoAAplicar) {
		// TODO Auto-generated method stub
		return 0;
	}

}
