package negocio;

import dao.DatosFuncionalesDao;
import datos.DatosFuncionales;

public class DatosFuncionalesABM {
	private static DatosFuncionalesABM instancia = null;

	protected DatosFuncionalesABM() {}

	public static DatosFuncionalesABM getInstance() {
		if (instancia == null)
			instancia = new DatosFuncionalesABM();
		return instancia;
	}

	public DatosFuncionales traer() {
		return DatosFuncionalesDao.getInstance().traer();
	}

}