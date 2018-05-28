package negocio;

import dao.SubeDao;
import dao.ViajeDao;
import datos.DatosFuncionales;
import datos.Persona;
import datos.Sube;
import datos.Viaje;

public class SubeABM {
		SubeDao dao = new SubeDao();
				
		public Sube traerSube(long idSube) throws Exception {
			Sube c = dao.traerSube(idSube);
			// implementar si c es null lanzar Exception ->!
			if (c == null) {
				throw new Exception("ERROR: NO EXISTE SUBE");
			}
			return c;
		}

		public Sube traerSube(int numero) throws Exception {
			Sube c = dao.traerSube(numero);
			// implementar si c es null lanzar Exception
			if (c == null) {
				throw new Exception("ERROR: NO EXISTE CLIENTE");
			}
			return c;
		}

		public int agregar(int idSube, int numero, Persona persona, int saldo) throws Exception {

			Sube c = new Sube(idSube, numero, persona,saldo);
			
			return dao.agregar(c);
		}

		public void eliminar(long idSube) throws Exception {
			
			// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
			 // hiciera habría que validar que el cliente no tenga dependencias
			 //
			Sube c = dao.traerSube(idSube);
			if (c == null) {
				throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
			}
			dao.eliminar(c);
		}
		
		//ACA VAN METODOS 
		public void agregarViaje(int numeroSube, Viaje v) throws Exception {
			//// EN TEORIA LO UNICO Q TENGO Q HACER ES ACTUALIZAR EL SALDO; EL VIAJE YA LO GUARDE
			Sube s = dao.traerSube(numeroSube);
			//s.inicializarListaViajes(); //ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA BASE LA LISTA
						
			if (s == null) {
				throw new Exception("ERROR: NO EXISTE Sube ");
			}
			ViajeDao daoViaje = new ViajeDao();
			Viaje existeViaje = daoViaje.traerViaje(v.getIdViaje());
			if (existeViaje == null) { //SI ES NULL LO AGREGO
				s.setSaldo(s.getSaldo() - v.getTarifa());
				daoViaje.agregar(v);
			}
			else {
				s.setSaldo(s.getSaldo() + existeViaje.getTarifa() - v.getTarifa());
				existeViaje.agregarDestinoAViaje(v);
				daoViaje.actualizar(existeViaje);
				
			}
			s.agregarViaje(v); // EN REALIDAD LLAMA AL DAO DE LA SUBE Y LA MODIFICA si pudo agregar el viaje lo agrego a la sube
			//daoSube.actualizar(s); ESTA LINEA VA UNA VEZ HECHO EL DER DE SUBE
			
			//ViajeDao daoViaje = new ViajeDao();
			//daoViaje.agregarViaje(v);   //SOLO EN TREN ME INTERESA SI ES VIAJE DE VUELTA; EN TAL CASO TENGO Q HACER UN MODIFICAR VIAJE
			
			System. out .println( s.toString());
			
		}
		
		public boolean verificarSaldoSuficiente(long idSube, double precioBoleto) {
			DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
			Sube sube = dao.traerSube(idSube);
			if (sube.getSaldo() - precioBoleto  > dG.getSaldoMaximoNegativo())
				return true;
				
			return false;
		}
		
		
	}
