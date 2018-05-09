package negocio;

import dao.PersonaDao;
import dao.UsuarioDao;
import java.util.List;
import datos.Persona;
import datos.Usuario;

public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public Usuario traerUsuario(long idUsuario) {
		// Implementar : si el no existe el prestamo lanzar la excepción
		Usuario u = dao.traerUsuario(idUsuario);
		return u;
	}

	public List<Usuario> traerUsuario(Persona p) {
		return dao.traerUsuario(p);
	}
	
	public int agregar(String nombreUsuario, String password, long idPersona) throws Exception{
		PersonaDao personaDao = new PersonaDao();
		Persona buscarPersona = personaDao.traerPersona(idPersona);
		
		if (buscarPersona == null) {
			throw new Exception("ERROR: NO EXISTE PERSONA PARA ASIGNAR USUARIO");
		}
		
		Usuario buscarUsuario = dao.traerUsuario(nombreUsuario);
		if (buscarUsuario != null) {
			throw new Exception("ERROR: YA EXIST EL USUARIO");
		}
		
		Usuario usuario= new Usuario(nombreUsuario, password, buscarPersona);
		
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario c) throws Exception {
		Usuario buscarUsuario = dao.traerUsuario(c.getIdUsuario());

		if (buscarUsuario != null && buscarUsuario.getIdUsuario() != c.getIdUsuario()) {
			throw new Exception("ERROR: EXISTE USUARIO");
		}

		dao.actualizar(c);
	}

	public void eliminar(long idUsuario) throws Exception {
		/*
		 * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		 * hiciera habría que validar que el cliente no tenga dependencias
		 */
		Usuario c = dao.traerUsuario(idUsuario);
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		dao.eliminar(c);
	}
	
}
