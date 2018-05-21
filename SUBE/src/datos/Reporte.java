package datos;

import java.util.List;
import java.util.ArrayList;

import dao.ViajeDao;

public class Reporte {
	private ReporteCompuesto reporteCompuesto;

	
 	public String generar(){
		return this.reporteCompuesto.generar();
	}
		
		
 	public List<Viaje> retornarReporte(String hql){
 		ViajeDao dao = new ViajeDao (); 	
 		return (ArrayList<Viaje>) dao.traerReporte(hql); 			
 	}
 		
 	
}
