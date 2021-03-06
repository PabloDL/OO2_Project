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
			
			//PRUEBA PERSONA 1 -> NO TARIFA SOCIAL, NO ESTUDIANTIL
			TerminalSubteABM tsAbm = new TerminalSubteABM();
			tsAbm.agregarViaje(1234,16);
			
			TerminalTrenABM ttAbm = new TerminalTrenABM();
			ttAbm.agregarViaje(1234, 13); //tmperley
			
			ttAbm.agregarViaje(1234, 14); //LLAVALLOL
			
			TerminalColectivoABM tcAbm = new TerminalColectivoABM();
			tcAbm.agregarViaje(1234,22,2);
			
			//PRUEBA PERSONA 2 -> NO TARIFA SOCIAL, SI ESTUDIANTIL
			
			tsAbm.agregarViaje(1235,16);
			
			ttAbm.agregarViaje(1235, 13); 
			
			ttAbm.agregarViaje(1235, 14);
			
			
			tcAbm.agregarViaje(1235,22,2);

			//PRUEBA PERSONA 3 -> SI TARIFA SOCIAL, NO ESTUDIANTIL
			
			tsAbm.agregarViaje(1236,16);
			
			
			ttAbm.agregarViaje(1236, 14);
			
			ttAbm.agregarViaje(1236, 13);
			
			tcAbm.agregarViaje(1236,22,2);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

