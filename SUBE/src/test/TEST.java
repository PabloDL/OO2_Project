package test;
import datos.*;
import negocio.TerminalTrenABM;
import negocio.ViajeABM;
import dao.*;
public class TEST {

	public static void main(String[] args) {
		
		Subte s = new Subte("A");
		ViajeABM vabm = new ViajeABM();
		try {
			Viaje v = vabm.traerViaje(40);
			
			System.out.println(v.getTransporte().mostrarTranporte());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(((Transporte)s).mostrarTranporte());
		try {
			
		}catch(Exception x) {
			System.out.println(x.getMessage());
		}
	}

}
