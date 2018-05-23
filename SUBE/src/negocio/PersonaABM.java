package negocio;

import java.util.List;
import dao.PersonaDao;
import datos.Persona;
import datos.Sube;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();
	
	public Persona traerPersona( long idPersona) throws Exception{
		Persona c= dao.traerPersona(idPersona);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception ("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}
	
	public Persona traerPersona( int dni) throws Exception{
		Persona c= dao .traerPersona(dni);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception ("ERROR: NO EXISTE CLIENTE");
		}
		return c;
	}

	public int agregar(String apellido, String nombre, int dni,
			boolean esTarifaSocial, boolean esTarifaEstudiantil, Sube s) throws Exception{
		
		Persona c= new Persona(apellido, nombre, dni, esTarifaSocial, esTarifaEstudiantil, s);
		// consultar si existe un cliente con el mismo dni , si existe arrojar la Excepcion		
		Persona buscarPersona = dao.traerPersona(dni);
		if (buscarPersona != null) {
			throw new Exception ("ERROR: CLIENTE EXISTE");
		}
		return dao.agregar(c);
	}
	
	public void modificar(Persona c) throws Exception{
		/* implementar antes de actualizar que no exista un cliente
		con el mismo documento a modificar
		y con el mismo id, lanzar la Exception */
		//TRAIGO POR DNI, SI HAY UNO QUE COINCIDE NO DEBE TENER ID DISTINTO (si es igual puedo
		//queres modificar DNI )
		Persona buscarPersona = dao.traerPersona(c.getDni());
		if (buscarPersona != null && buscarPersona.getIdPersona() != c.getIdPersona()) {
			throw new Exception ("ERROR: CLIENTE EXISTE DNI");
		}
		dao .actualizar(c);
	}
	
	public void eliminar( long idPersona) throws Exception{ 
		/*en este caso es física en gral. no se se
		aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
		dependencias*/
		Persona c = dao.traerPersona(idPersona);
		if (c == null) {
			throw new Exception ("ERROR: NO EXISTE CLIENTE");
		}
		dao .eliminar(c);
	}
	
	public List<Persona> traerPersona(){ 
		return dao .traerPersona();
		}
	}