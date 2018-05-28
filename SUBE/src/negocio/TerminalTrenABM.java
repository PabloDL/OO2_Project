package negocio;

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
	
	public void agregarViaje(int numeroSube, long idTerminalTren) throws Exception {
		TerminalTren ts = dao.traerTerminalTren(idTerminalTren);
		if (ts == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL Tren");
		}

		//ts.inicializarListaViajes(); // ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
		SubeDao daoSube = new SubeDao();
		Sube sube = daoSube.traerSube(numeroSube);

		ViajeABM viajeAbm = new ViajeABM();
		DatosFuncionales dF = DatosFuncionalesABM.getInstance().traer();
		Tren tren = new datos.Tren(ts.getLinea(),ts.getRamal(),ts.getEstacion());
		Viaje v = new Viaje(dF.getPrecioMaximoTren(), tren, sube);

		viajeAbm.agregarViaje(v);
	}
	
}
