package negocio;

import java.util.List;

import dao.SubeDao;
import dao.TerminalColectivoDao;
import datos.Colectivo;
import datos.DatosGenerales;
import datos.Sube;
import datos.Subte;
import datos.TerminalColectivo;
import datos.TerminalSubte;
import datos.Viaje;

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
	
	public void agregarViaje(int numeroSube, long idTerminalColectivo, int tramo) throws Exception {
		//aca iria algo asi como el test , tengo q traer la terminal y hacer el proceso de cobro
		TerminalColectivo ts = dao.traerTerminalColectivo(idTerminalColectivo);
		if (ts == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL Colectivo");
		}

		//ts.inicializarListaViajes(); // ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
		SubeDao daoSube = new SubeDao();
		Sube sube = daoSube.traerSube(numeroSube);

		ViajeABM viajeAbm = new ViajeABM();
		DatosGenerales dG = DatosGenerales.getInstanciaDatosGenerales();
		Colectivo Colectivo = new Colectivo(ts.getLinea(),ts.getNumero(), ts.getRamal());
		Viaje v = new Viaje(dG.determinarPrecioTramo(tramo), Colectivo, sube);

		viajeAbm.agregarViaje(v);
	}
	
}
