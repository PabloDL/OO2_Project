package datos;

import java.util.Set;

public class Seccion {

	private int idSeccion;
	private float precio;
	private Set<Estacion> estaciones1;
	private Set<Estacion> estaciones2;
	
	public Seccion() {		
	}

	public Seccion(int idSeccion, float precio, Set<Estacion> estaciones1, Set<Estacion> estaciones2) {
		super();
		this.idSeccion = idSeccion;
		this.precio = precio;
		this.estaciones1 = estaciones1;
		this.estaciones2 = estaciones2;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Set<Estacion> getEstaciones1() {
		return estaciones1;
	}

	public void setEstaciones1(Set<Estacion> estaciones1) {
		this.estaciones1 = estaciones1;
	}

	public Set<Estacion> getEstaciones2() {
		return estaciones2;
	}

	public void setEstaciones2(Set<Estacion> estaciones2) {
		this.estaciones2 = estaciones2;
	}

	@Override
	public String toString() {
		return "Seccion [idSeccion=" + idSeccion + ", precio=" + precio + "]";
	}
}
