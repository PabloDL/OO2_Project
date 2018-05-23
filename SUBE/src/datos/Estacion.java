package datos;

public class Estacion {

	private int IdEstacion;
	private String nombre;	
	
	public Estacion() {		
	}

	public Estacion(String nombre) {
		super();
		
		this.nombre = nombre;
	}

	public int getIdEstacion() {
		return this.IdEstacion;
	}

	public void setIdEstacion(int idEstacion) {
		this.IdEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Estacion [IdEstacion=" + IdEstacion + ", nombre=" + nombre + "]";
	}

	
	
	
}
