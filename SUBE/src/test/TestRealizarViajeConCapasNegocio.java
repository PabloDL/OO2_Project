package test;

import datos.DatosFuncionales;
import negocio.DatosFuncionalesABM;
import negocio.TerminalColectivoABM;
import negocio.TerminalSubteABM;
import negocio.TerminalTrenABM;

public class TestRealizarViajeConCapasNegocio {

	public static void main(String[] args) {
		try {
			// LEVANTO LOS DATOS FUNCIONALES
			DatosFuncionalesABM datosFuncionalesABM = DatosFuncionalesABM.getInstance();
			DatosFuncionales df = datosFuncionalesABM.traer();
			
			TerminalSubteABM tsAbm = new TerminalSubteABM();
			tsAbm.agregarViaje(1234,16);
			
			TerminalTrenABM ttAbm = new TerminalTrenABM();
			ttAbm.agregarViaje(1234, 5);
			
			ttAbm.agregarViaje(1234, 6);
			
			TerminalColectivoABM tcAbm = new TerminalColectivoABM();
			tcAbm.agregarViaje(1234,22,1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

