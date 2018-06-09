package test;

import java.util.List;

import dao.SubeDao;
import dao.ViajeDao;
import datos.Sube;
import datos.Viaje;

public class TraerViajesDeRedSube {
	public static void main(String[] args) {
		SubeDao sDao= new SubeDao();
		long idSube = 1;
		Sube s = sDao.traerSube(idSube);
		ViajeDao vDao = new ViajeDao();
		List<Viaje> lViajesRedSube = vDao.traerViajesRedSube(s);	
		System.out.println("\ntraer Sube\n" + s);
		System.out.println("\ntraer Lista Viajes RED sube\n" + lViajesRedSube);
	}
}
