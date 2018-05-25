package negocio;

import java.util.List;

import dao.SubeDao;
import dao.TerminalTrenDao;
import datos.DatosFuncionales;
import datos.Sube;
import datos.TerminalTren;
import datos.Tren;
import datos.Viaje;

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

	public int agregar(String linea, String ramal, String estacion) throws Exception {

		TerminalTren c = new TerminalTren(linea, ramal, estacion);
		
		return dao.agregar(c);
	}

	public void eliminar(long idTerminalTren) throws Exception {
		TerminalTren c = dao.traerTerminalTren(idTerminalTren);
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		dao.eliminar(c);
	}
	
	public void agregarViaje(int numeroSube, long idTerminalTren /* o id de terminal*/) throws Exception {
		//aca iria algo asi como el test , tengo q traer la terminal y hacer el proceso de cobro
		TerminalTren ts = dao.traerTerminalTren(idTerminalTren);
		if (ts == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL Tren");
		}

		//ts.inicializarListaViajes(); // ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
		SubeDao daoSube = new SubeDao();
		Sube sube = daoSube.traerSube(numeroSube);

		ViajeABM viajeAbm = new ViajeABM();
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		Tren Tren = new datos.Tren(ts.getLinea(),ts.getRamal(),ts.getEstacion());
		Viaje v = new Viaje(dG.getPrecioMaximoTren(), Tren, sube);

		viajeAbm.agregarViaje(v);
	}
}
