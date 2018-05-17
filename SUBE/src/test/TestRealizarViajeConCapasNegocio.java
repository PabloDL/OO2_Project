package test;

import negocio.TerminalColectivoABM;
import negocio.TerminalSubteABM;
import negocio.TerminalTrenABM;

public class TestRealizarViajeConCapasNegocio {

	public static void main(String[] args) {
		try {
			TerminalSubteABM tsAbm = new TerminalSubteABM();
			tsAbm.agregarViaje(1,13);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

