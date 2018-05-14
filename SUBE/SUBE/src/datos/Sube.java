package datos;

import java.util.List;

public class Sube {
	private int idSube;
	private long numero;
	private Persona persona;
	private List<Viaje> ultimosViajes;
	private float saldo;

	public Sube() {
		
	}
	
	public Sube(int idSube, long numero, Persona persona, List<Viaje> ultimosViajes, float saldo) {
		super();
		this.idSube = idSube;
		this.numero = numero;
		this.persona = persona;
		this.ultimosViajes = ultimosViajes;
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
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
}
