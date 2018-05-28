package test;

import dao.DatosFuncionalesDao;
import datos.DatosFuncionales;

public class TraerDatosFuncionales {
	public static void main(String[] args) {
	DatosFuncionalesDao dao = DatosFuncionalesDao.getInstance();
	DatosFuncionales df = dao.traer();
	System.out.println("\nTraer Datos Funcionales\n\n" + df.toString());
	}
}