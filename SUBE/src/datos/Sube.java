package datos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sube {
	private long idSube;
	private int numero;
	private Persona persona;
	private Set<Viaje> ultimosViajes; //el ultimo viaje es el primero
	private double saldo;

	public Sube() {}
	
	public Sube(int idSube, int numero, Persona persona, double saldo) {
		super();
		this.idSube = idSube;
		this.numero = numero;
		this.persona = persona;
		this.ultimosViajes = new HashSet<Viaje>();
		this.saldo = saldo;
	}
	
	public long getIdSube() {
		return idSube;
	}
	
	protected void setIdSube(long idSube) {
		this.idSube = idSube;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Set<Viaje> getUltimosViajes() {
		return ultimosViajes;
	}
	
	public void setUltimosViajes(Set<Viaje> ultimosViajes) {
		this.ultimosViajes = ultimosViajes;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double d) {
		this.saldo = d;
	}
	
	public void agregarViaje(Viaje viaje) {
		if(viaje.getTarifa() >= 0) {
			this.ultimosViajes.add(viaje);
			this.saldo = this.saldo - viaje.getTarifa();
		}
		else {
			Iterator<Viaje> it = this.ultimosViajes.iterator();
			Viaje v = it.next();
			double tarifaOriginal =  v.getTarifa(); //si vengo aca el ultimo viaje es el del tren(el primero por orden de tiempo)
			//double tarifaOriginal = ((HashSet<Viaje>) this.ultimosViajes).get(this.ultimosViajes.size()-1).getTarifa();
			//La tarifa de la nueva tarifa la suma porque es negativa entonces queda +x- y se termina restando como se debe.
			//Es decir le devuelvo el precio maximo sacado al ppio y le resto lo que salio el boleto en realidad
			this.saldo = this.saldo + tarifaOriginal + viaje.getTarifa();
			//En este caso no tengo que agregar el viaje a la lista sino modificar el ultimo viaje
			//this.ultimosViajes.get(this.ultimosViajes.size()-1).agregarDestinoAViaje(viaje);
			v.agregarDestinoAViaje(viaje); //??
		}
	}
	
	@Override
	public String toString() {
		return "Sube [idSube=" + idSube + ", numero=" + numero + ", persona=" + persona + ", ultimosViajes="
				+ ultimosViajes + ", saldo=" + saldo + "]";
	}
		
}
