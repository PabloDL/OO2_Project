package negocio;

import dao.UsuarioDao;
import java.util.List;
import datos.Persona;
import datos.Usuario;

public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public Usuario traerUSuario(long idUsuario) {
		// Implementar : si el no existe el prestamo lanzar la excepción
		Usuario p = dao.traerUsuario(idUsuario);
		return p;
	}

	public List<Usuario> traerPrestamo(Persona p) {
		return dao.traerUsuario(p);
	}

	/*
	 * Pendiente implementar Alta , Modificar
	 */
}
