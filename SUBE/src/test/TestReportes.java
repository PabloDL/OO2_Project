package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dao.ViajeDao;
import datos.Reporte;
import datos.ReporteCompuesto;
import datos.ReporteXFecha;
import datos.Viaje;

public class TestReportes {
	public static void main(String[] args) {
		try {//prueba traer reporte por fecha
			//se asume que hay viajes realizados en la bd
			
			GregorianCalendar fechaInicio = new GregorianCalendar(2018,5+1,28);
			GregorianCalendar fechaFin = new GregorianCalendar(2018,6+1,10);
			
			Reporte reporteActual = new ReporteCompuesto();
			reporteActual.getReporteCompuesto().agregarFiltro(new ReporteXFecha(fechaInicio, fechaFin));
			reporteActual.retornarReporte(reporteActual.generar());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//prueba traer reporte por transporte
			ViajeDao dao = new ViajeDao (); 	
	 		System.out.println((ArrayList<Viaje>) dao.traerReporte("FROM Viaje v WHERE")); 

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//prueba traer reporte por tramo
		

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
