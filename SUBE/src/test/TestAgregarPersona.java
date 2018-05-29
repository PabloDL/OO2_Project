package test;
import dao.*;
import datos.*;
import negocio.PersonaABM;
import negocio.SubeABM;
import negocio.UsuarioABM;

public class TestAgregarPersona {
	public static void main(String[] args) {
		try {
			SubeABM subeabm = new SubeABM();
			PersonaABM abm = new PersonaABM();
			/*String apellido = "Goday";
			String nombre = "Nicolas";
			int documento = 33401020;
			
			
			UsuarioABM usuarioabm = new UsuarioABM();
			
			long ultimoIdCliente = abm.agregar(apellido,nombre, documento, true, true, subeabm.traerSube(1234));*/	
			//abm.agregar("Fiasche", "Nicolas", 39493467, false, false, subeabm.traerSube(1111));
			abm.agregar("Fiasche", "Nicolas", 9999999, false, false, subeabm.traerSube(3333));
			System.out.println(abm.traerPersona(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}