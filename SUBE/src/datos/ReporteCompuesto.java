package datos;

import java.util.Set;
import java.util.HashSet;

import datos.Reporte;

public class ReporteCompuesto extends Reporte{
	private Set<Reporte> reportes;
	
//CONSTRUCTORES
	public ReporteCompuesto() {
		super();
		this.reportes = new HashSet<Reporte>();
	}

//GETTERS, SETTERS
	public Set<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(HashSet<Reporte> lstReporte) {
		this.reportes = lstReporte;
	}

//METODOS NO GENERICOS
	public String generar() {
		String hql = "FROM Viaje v WHERE";
		
		for (Reporte reporteActual: this.reportes) {
			hql = hql + reporteActual.generar();
		}
		return hql;
	}
		
	/*"FROM Viaje v WHERE";
	 * "v.fecha BETWEEN " + this.inicio + " AND " + this.fin; 
	 * 
	 */
	
	public boolean agregarFiltro(Reporte r) {
		return this.reportes.add(r);
	}
	
	public boolean eliminarFiltro(Reporte r) {
		return this.reportes.remove(r);
	}
	
	
}
