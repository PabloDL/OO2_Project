package negocio;

import java.util.List;

import dao.SubeDao;

//import dao.subeDao

import dao.TerminalSubteDao;
import datos.Sube;
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

	public TerminalSubte traerTerminalSubte(int dni) throws Exception {
		TerminalSubte c = dao.traerTerminalSubte(dni);
		// implementar si c es null lanzar Exception
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
		ts.inicializarListaViajes(); //ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
		SubeDao daoSube = new SubeDao();
		Sube s = daoSube.traerSube(numeroSube);
		
		if (ts == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
		}
		
		Viaje v = ts.cobrar(s, 0); //EL SEGUNDO PARAMETRO SOLO CORRESPONDE CUANDO ES UN COLECTIVO Y TIENE VARIOS TRAMOS
		if (v == null) {
			throw new Exception("ERROR: IMPOSIBLE AGREGAR VIAJE, SALDO INSUFICIENTE?");
		}
		s.agregarViaje(v); // EN REALIDAD LLAMA AL DAO DE LA SUBE Y LA MODIFICA si pudo agregar el viaje lo agrego a la sube
		//daoSube.actualizar(s); ESTA LINEA VA UNA VEZ HECHO EL DER DE SUBE
		
		//ViajeDao daoViaje = new ViajeDao();
		//daoViaje.agregarViaje(v);   //SOLO EN TREN ME INTERESA SI ES VIAJE DE VUELTA; EN TAL CASO TENGO Q HACER UN MODIFICAR VIAJE
		
		System. out .println( s.toString());
		
	}
	
}
