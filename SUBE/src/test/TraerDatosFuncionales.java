package test;

import dao.DatosFuncionalesDao;
import datos.DatosFuncionales;
import datos.DatosFuncionales;
import negocio.DatosFuncionalesABM;

public class TraerDatosFuncionales {
	public static void main(String[] args) {
	DatosFuncionalesDao dao = DatosFuncionalesDao.getInstance();
	DatosFuncionales df = dao.traer();
	System.out.println("\ntraer Datos Funcionales\n" + df.toString());
	}
}