package negocio;

import java.util.List;

import dao.SubeDao;

//import dao.subeDao

import dao.TerminalSubteDao;
import dao.ViajeDao;
import datos.DatosGenerales;
import datos.Sube;
import datos.Subte;
//import dao.TerminalSubteDao
import datos.TerminalSubte;
import datos.Viaje;

public class TerminalSubteABM {
	TerminalSubteDao dao = new TerminalSubteDao();
			
	public TerminalSubte traerTerminalSubte(long idTerminalSubte) throws Exception {
		TerminalSubte c = dao.traerTerminalSubte(idTerminalSubte);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public int agregar(String letra) throws Exception {

		TerminalSubte c = new TerminalSubte(letra);
		
		return dao.agregar(c);
	}

	public void eliminar(long idTerminalSubte) throws Exception {
		
		// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		 // hiciera habría que validar que el cliente no tenga dependencias
		 //
		TerminalSubte c = dao.traerTerminalSubte(idTerminalSubte);
		if (c == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
		}
		dao.eliminar(c);
	}
	
	//ACA VAN METODOS 
	public void agregarViaje(int numeroSube, long idTerminalSubte /* o id de terminal*/) throws Exception {
		//aca iria algo asi como el test , tengo q traer la terminal y hacer el proceso de cobro
		TerminalSubte ts = dao.traerTerminalSubte(idTerminalSubte);
		if (ts == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
		}

		ts.inicializarListaViajes(); // ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
		SubeDao daoSube = new SubeDao();
		Sube sube = daoSube.traerSube(numeroSube);

		ViajeABM viajeAbm = new ViajeABM();
		DatosGenerales dG = DatosGenerales.getInstanciaDatosGenerales();
		Subte subte = new Subte(ts.getLetra());
		Viaje v = new Viaje(dG.getMontoSubte(), subte, sube);

		viajeAbm.agregarViaje(v);
	}
	
}
