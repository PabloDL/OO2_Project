package negocio;

import java.util.List;
//import dao.TerminalSubteDao
import datos.TerminalSubte;

public class TerminalSubteABM {
	// TerminalSubteDao dao = new TerminalSubteDao

	
	
	/*
	public TerminalSubte traerTerminalSubte(long idTerminalSubte) throws Exception {
		TerminalSubte c = dao.traerTerminalSubte(idTerminalSubte);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public TerminalSubte traerTerminalSubte(int dni) throws Exception {
		TerminalSubte c = dao.traerTerminalSubte(dni);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public int agregar(String letra)
			throws Exception {

		TerminalSubte c = new TerminalSubte(letra);
		// consultar si existe un cliente con el mismo dni , si existe arrojar la
		// Excepcion
		TerminalSubte buscarTerminalSubte = dao.traerTerminalSubte(dni);
		if (buscarTerminalSubte != null) {
			throw new Exception("ERROR: CLIENTE EXISTE");
		}
		return dao.agregar(c);
	}

	public void modificar(TerminalSubte c) throws Exception {
		// implementar antes de actualizar que no exista un cliente con el mismo
		 documento a modificar y con el mismo id, lanzar la Exception
		// TRAIGO POR DNI, SI HAY UNO QUE COINCIDE NO DEBE TENER ID DISTINTO (si es
		// igual puedo
		// queres modificar DNI )
		TerminalSubte buscarTerminalSubte = dao.traerTerminalSubte(c.getDni());
		if (buscarTerminalSubte != null && buscarTerminalSubte.getIdTerminalSubte() != c.getIdTerminalSubte()) {
			throw new Exception("ERROR: CLIENTE EXISTE DNI");
		}
		dao.actualizar(c);
	}

	public void eliminar(long idTerminalSubte) throws Exception {
		
		// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		 // hiciera habría que validar que el cliente no tenga dependencias
		 //
		TerminalSubte c = dao.traerTerminalSubte(idTerminalSubte);
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		dao.eliminar(c);
	}

	public List<TerminalSubte> traerTerminalSubte() {
		return dao.traerTerminalSubte();
	}
	*/
	
}
