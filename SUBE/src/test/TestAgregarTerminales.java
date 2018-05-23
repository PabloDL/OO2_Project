package test;

import negocio.TerminalColectivoABM;
import negocio.TerminalSubteABM;
import negocio.TerminalTrenABM;

public class TestAgregarTerminales {
	public static void main(String[] args) {
		try {
			TerminalSubteABM abm = new TerminalSubteABM();
			TerminalColectivoABM abmc = new TerminalColectivoABM();
			TerminalTrenABM abmt = new TerminalTrenABM();

			long ultimoIdTerminalSubte = abm.agregar("A");
			ultimoIdTerminalSubte = abm.agregar("B");
			ultimoIdTerminalSubte = abm.agregar("C");

			long TerminalColectivoABM = abmc.agregar("295", "5", 20);
			TerminalColectivoABM = abmc.agregar("299", "C", 10);
			TerminalColectivoABM = abmc.agregar("299", "A", 15);
			TerminalColectivoABM = abmc.agregar("100", "1", 52);

			long TerminalTrenABM = abmt.agregar("Roca", "Ezeiza", "Lanus");
			TerminalTrenABM = abmt.agregar("Roca", "Ezeiza", "Banfield");
			TerminalTrenABM = abmt.agregar("Roca", "Ezeiza", "Escalada");
			TerminalTrenABM = abmt.agregar("Roca", "Glew", "Glew");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
