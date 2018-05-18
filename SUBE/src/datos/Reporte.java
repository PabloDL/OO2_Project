package datos;

import java.util.List;
import java.util.ArrayList;

import dao.ViajeDao;

public class Reporte {
	private ReporteCompuesto reporteCompuesto;

	
 	public String generar(){
 		ViajeDao dao = new ViajeDao ();
 		String hql = this.reporteCompuesto.generar();
 		ArrayList<Viaje> viajes = null;
 	
 		viajes = (ArrayList<Viaje>) dao.traerReporte(hql);
 		
 		return viajes;
		//TODO completar juntar todos los reportes en un query y devolverlo
 		
// 		"FROM Customer AS c WHERE c.dateAdded BETWEEN :stDate AND :edDate "
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String frmDate = format.parse(startDate);
//		String enDate = format.parse(endDate);
//		sessionfactory.getCurrentSession()
//		.createQuery()
//		.setParameter("stDate", frmDate)
//		.setParameter("edDate", enDate)
//		.list();
 	
 	}
 		
 	
}
