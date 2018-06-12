package test;

import datos.TerminalRecarga;
import negocio.TerminalRecargaABM;

public class TestTerminalRecarga {
	
	public static void main(String[] args) {
		TerminalRecargaABM terminalRecargaAbm = new TerminalRecargaABM();
		
		//RECARGA DE SALDO
		try {
			boolean estadoTransaccion = terminalRecargaAbm.registrarRecarga(1234, 100);
			if (estadoTransaccion) System.out.println("recarga realizada"); 
			else  System.out.println("recarga fallida");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//CONSULTA DE SALDO
		try {
			 System.out.println(terminalRecargaAbm.consultarSaldo(1234));
			 System.out.println(terminalRecargaAbm.consultarSaldo(1235));
			 System.out.println(terminalRecargaAbm.consultarSaldo(2222));
			 System.out.println(terminalRecargaAbm.consultarSaldo(3333));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}

}
