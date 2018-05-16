package datos;

public class Usuario {
	private long idUsuario;
	private String nombreUsuario;
	private String password;
	private Persona persona;
		
	public Usuario() {}

	public Usuario(String nombreUsuario, String password, Persona persona) {
		super ();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.persona = persona;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String toString() {
		return nombreUsuario + " " + password;
	}
}
