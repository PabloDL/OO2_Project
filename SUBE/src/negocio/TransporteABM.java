package negocio;

import java.util.List;
import dao.TransporteDao;
import datos.Transporte;

public class TransporteABM {
	private static TransporteABM instancia = null; // Patrón Singleton

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

	public List<Transporte> traer() {
		return TransporteDao.getInstance().traer();
	}
}