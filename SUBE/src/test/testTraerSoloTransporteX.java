package test;

import dao.ViajeDao;
import datos.Persona;
import datos.Sube;
import negocio.PersonaABM;
import negocio.SubeABM;

public class testTraerSoloTransporteX {
	public static void main(String[] args) {
		try {
			ViajeDao dao = new ViajeDao();
			String colectivo = "idcolectivo";
			String tren = "idtren";
			String subte = "idsubte";
			/*
			System.out.println("imprimo colectivos");
			System.out.println(dao.traerReporte("from Viaje v inner join fetch v.transporte t where v.transporte=" + colectivo));
			
			System.out.println("imprimo tren");
			System.out.println(dao.traerReporte("from Viaje v inner join fetch v.transporte t where v.transporte=" + tren));
			*/
			System.out.println("imprimo subte linea a");
			String lineaA = "'100'";
			
			System.out.println(dao.traerReporte("from Viaje v inner join "
					+ "fetch v.transporte t where v.transporte=" + colectivo + "having(linea='100')"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
