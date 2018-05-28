package datos;

import java.util.GregorianCalendar;

import negocio.TransporteABM;

public class Viaje {
	private long idViaje;
	private double tarifa;
	private Transporte transporte;
	private Sube sube;
	private GregorianCalendar fechaHoraInicio;
	
	public Viaje() {}
	
	public Viaje(double tarifa, Transporte transporte, Sube s) {
		super();
		this.tarifa = tarifa;
		this.transporte = transporte;
		this.fechaHoraInicio = new GregorianCalendar();
		this.sube = s;
		//GUARDAR LAS FECHA this.fechaHoraInicio = fechaHoraInicio;
	}
	
	public Transporte getTransporte() {
		return transporte;
	}
	
	protected void setIdTransporte(Transporte idTransporte) {
		this.transporte = idTransporte;
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

	public GregorianCalendar getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(GregorianCalendar fechaHoraInicio) {
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
		GregorianCalendar fechaHoraSalida = ((Tren)this.getTransporte()).getFechaHoraSalida();
		double tarifaFinal  = -viaje.getTarifa();
		//SETEO LOS VALORES EN EL TRANSPORTE
		((Tren)this.getTransporte()).setEstacionDestino(estacionDestino);
		((Tren)this.getTransporte()).setFechaHoraSalida(fechaHoraSalida);
		this.setTarifa(tarifaFinal);
	}
	
	@Override
	public String toString() {
		return "\n Viaje \nidViaje= " + idViaje + ", tarifa= " + tarifa + ", transporte= " + transporte
				+ ", fechaHoraInicio= " + fechaHoraInicio + "\n";
	}

}
