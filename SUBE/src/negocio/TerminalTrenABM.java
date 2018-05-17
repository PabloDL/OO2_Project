package negocio;

import java.util.List;
import dao.TerminalTrenDao;
import datos.TerminalTren;

public class TerminalTrenABM {
	TerminalTrenDao dao = new TerminalTrenDao();
	
	public TerminalTren traerTerminalTren(long idTerminalTren) throws Exception {
		TerminalTren c = dao.traerTerminalTren(idTerminalTren);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public TerminalTren traerTerminalTren(int dni) throws Exception {
		TerminalTren c = dao.traerTerminalTren(dni);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public int agregar(String linea, String ramal, String estacion) throws Exception {

		TerminalTren c = new TerminalTren(linea, ramal, estacion);
		
		return dao.agregar(c);
	}

	public void eliminar(long idTerminalTren) throws Exception {
		
		// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		 // hiciera habría que validar que el cliente no tenga dependencias
		 //
		TerminalTren c = dao.traerTerminalTren(idTerminalTren);
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		dao.eliminar(c);
	}
	
}
