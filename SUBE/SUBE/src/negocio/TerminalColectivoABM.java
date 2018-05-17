package negocio;

import java.util.List;
import dao.TerminalColectivoDao;
import datos.TerminalColectivo;

public class TerminalColectivoABM {
	TerminalColectivoDao dao = new TerminalColectivoDao();
	
	public TerminalColectivo traerTerminalColectivo(long idTerminalColectivo) throws Exception {
		TerminalColectivo c = dao.traerTerminalColectivo(idTerminalColectivo);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public TerminalColectivo traerTerminalColectivo(int dni) throws Exception {
		TerminalColectivo c = dao.traerTerminalColectivo(dni);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public int agregar(String linea, String ramal, int numero) throws Exception {

		TerminalColectivo c = new TerminalColectivo(linea, ramal, numero);
		
		return dao.agregar(c);
	}

	public void eliminar(long idTerminalColectivo) throws Exception {
		
		// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		 // hiciera habría que validar que el cliente no tenga dependencias
		 //
		TerminalColectivo c = dao.traerTerminalColectivo(idTerminalColectivo);
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		dao.eliminar(c);
	}
	
}
