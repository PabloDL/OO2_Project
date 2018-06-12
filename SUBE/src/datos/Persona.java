package datos;

public class Persona {
	long idPersona;
	private Sube sube;
	private String nombre;
	private String apellido;
	private int dni;
	private boolean esTarifaSocial ;
	private boolean esTarifaEstudiantil ;
	private Usuario usuario;

	public Persona(){} //siempre hay que implementar el contructor vacio
	
	public Persona(String apellido, String nombre, int dni,boolean esTarifaSocial, boolean esTarifaEstudiantil, Sube s) { //nunca va el id en el constructor por ser autoincrementable
		super ();
		this . apellido = apellido;
		this . nombre = nombre;
		this . dni = dni;
		this. esTarifaSocial  = esTarifaSocial;
		this.esTarifaEstudiantil  = esTarifaEstudiantil;
		this.sube = s;
	}
	public Persona(String apellido, String nombre, int dni,boolean esTarifaSocial, boolean esTarifaEstudiantil) {
		super ();
		this . apellido = apellido;
		this . nombre = nombre;
		this . dni = dni;
		this. esTarifaSocial  = esTarifaSocial;
		this.esTarifaEstudiantil  = esTarifaEstudiantil;
		
	}

	public long getIdPersona(){
		return idPersona;

	}

	protected void setIdPersona(long idPersona) { // siempre va protected, para que no sea modificado
		this.idPersona = idPersona;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public boolean isEsTarifaSocial() {
		return esTarifaSocial;
	}
	public void setEsTarifaSocial(boolean esTarifaSocial) {
		this.esTarifaSocial = esTarifaSocial;
	}
	public boolean isEsTarifaEstudiantil() {
		return esTarifaEstudiantil;
	}
	public void setEsTarifaEstudiantil(boolean esTarifaEstudiantil) {
		this.esTarifaEstudiantil = esTarifaEstudiantil;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String usaTarifaSocial() {
		if (this.esTarifaSocial == true)
			return "SI";
		else return "NO";
	}
	
	public String usaBoletoEstudiantil() {
		if (this.esTarifaEstudiantil == true)
			return "SI";
		else return "NO";
	}

	public Sube getSube() {
		return sube;
	}

	public void setSube(Sube sube) {
		this.sube = sube;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", esTarifaSocial=" + esTarifaSocial + ", esTarifaEstudiantil=" + esTarifaEstudiantil
				+ ", usuario=" + usuario + "]";
	}
	
}
