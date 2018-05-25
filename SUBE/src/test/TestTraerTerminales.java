package test;

import dao.TerminalColectivoDao;
import datos.TerminalColectivo;

public class TestTraerTerminales {
	public static void main(String[] args) {
		TerminalColectivoDao dao = new TerminalColectivoDao();
		long idTerminalColectivo = 1;
		TerminalColectivo c = dao.traerTerminalColectivo(idTerminalColectivo);
		System.out.println("\ntraer terminal\n" + c );
	}

}
