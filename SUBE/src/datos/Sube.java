package datos;

import java.util.ArrayList;
import java.util.List;

public class Sube{
	private int idSube;
	private long numero;
	private Persona persona;
	private List<Viaje> ultimosViajes;
	private double saldo;

	public Sube() {
		
	}
	
	public Sube(int idSube, long numero, Persona persona, float saldo) {
		super();
		this.idSube = idSube;
		this.numero = numero;
		this.persona = persona;
		this.ultimosViajes = new ArrayList<Viaje>();
		this.saldo = saldo;
	}
	
	public int getIdSube() {
		return idSube;
	}
	public void setIdSube(int idSube) {
		this.idSube = idSube;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Viaje> getUltimosViajes() {
		return ultimosViajes;
	}
	public void setUltimosViajes(List<Viaje> ultimosViajes) {
		this.ultimosViajes = ultimosViajes;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void agregarViaje(Viaje viaje) {
		if(viaje.getTarifa() >= 0) {
			this.ultimosViajes.add(viaje);
			this.saldo = this.saldo - viaje.getTarifa();
		}
		else {
			double tarifaOriginal = this.ultimosViajes.get(this.ultimosViajes.size()-1).getTarifa();
			//La tarifa de la nueva tarifa la suma porque es negativa entonces queda +x- y se termina restando como se debe.
			//Es decir le devuelvo el precio maximo sacado al ppio y le resto lo que salio el boleto en realidad
			this.saldo = this.saldo + tarifaOriginal + viaje.getTarifa();
			//En este caso no tengo que agregar el viaje a la lista sino modificar el ultimo viaje
			this.ultimosViajes.get(this.ultimosViajes.size()-1).agregarDestinoAViaje(viaje);			
		}
	}
	

	@Override
	public String toString() {
		return "Sube [idSube=" + idSube + ", numero=" + numero + ", persona=" + persona + ", ultimosViajes="
				+ ultimosViajes + ", saldo=" + saldo + "]";
	}
		
}
