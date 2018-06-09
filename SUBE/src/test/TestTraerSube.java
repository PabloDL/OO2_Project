package test;

import dao.SubeDao;
import datos.Sube;

public class TestTraerSube {
	public static void main(String[] args) {
		SubeDao sDao= new SubeDao();
		long idSube = 1;
		Sube s = sDao.traerSube(idSube);
		System.out.println("\ntraer Sube\n" + s);
	}
}
