package negocio;

import datos.DatosFuncionales;
import datos.Sube;

public class TerminalRecargaABM {

	public boolean registrarRecarga(int nroSube, double recarga) throws Exception {
		boolean resultadoOperacion = false;
		SubeABM subeAbm = new SubeABM();
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		Sube sube = subeAbm.traerSube(nroSube);
		double nuevoSaldo = sube.getSaldo() + recarga;
		if (nuevoSaldo < dG.getSaldoMaximo() && recarga >= 0) {
			sube.setSaldo(sube.getSaldo() + recarga);
			subeAbm.actualizar(sube);
			resultadoOperacion = true;
		}
		return resultadoOperacion;
	}
	
	public double consultarSaldo(int nroSube) throws Exception {
		double saldo = 0; 
		SubeABM subeAbm = new SubeABM();
		Sube sube;
		try {
			sube = subeAbm.traerSube(nroSube);
			saldo = sube.getSaldo();
		} catch (Exception e) {
			throw new Exception("ERROR: NUMERO SUBE INEXISTENTE");
		}
		return saldo;
	}

}
