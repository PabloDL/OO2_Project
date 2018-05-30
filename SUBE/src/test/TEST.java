package test;
import datos.*;
import negocio.TerminalTrenABM;
import dao.*;
public class TEST {

	public static void main(String[] args) {
		
		/*SubeDao subeDao = new SubeDao();
		Sube sube = subeDao.traerSube(1234);
		System.out.println(sube.getNumero());*/
		
		TerminalTrenABM ttAbm = new TerminalTrenABM();
		try {
			
		ttAbm.agregarViaje(1234, 13); //tmperley
		
		ttAbm.agregarViaje(1234, 14); //LLAVALLOL
		
		}catch(Exception x) {
			System.out.println(x.getMessage());
		}
	}

}
