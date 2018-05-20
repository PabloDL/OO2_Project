package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import dao.TransporteDao;
import datos.Transporte;

public class TransporteABM {
	private static TransporteABM instancia = null; // Patr�n Singleton

	protected TransporteABM() {
	}

	public static TransporteABM getInstance() {
		if (instancia == null)
			instancia = new TransporteABM();
		return instancia;
	}

	public Transporte traer(int idTransporte) {
		return TransporteDao.getInstance().traer(idTransporte);
	}

	public int agregar(Transporte t) throws Exception{
			return TransporteDao.getInstance().agregar(t);
		}
		
	public void eliminar( long idTransporte) throws Exception{ 
		/*en este caso es f�sica en gral. no se se
		aplicar�a este caso de uso, si se hiciera habr�a que validar que el cliente no tenga
		dependencias*/
		Transporte c = TransporteDao.getInstance().traer(idTransporte);
		if (c == null) {
			throw new Exception ("ERROR: NO EXISTE Transporte");
		}
		TransporteDao.getInstance().eliminar(c);
	}

	
	public List<Transporte> traer() {
		return TransporteDao.getInstance().traer();
	}
}