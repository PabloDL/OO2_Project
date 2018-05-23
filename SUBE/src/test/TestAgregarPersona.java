package test;

import negocio.PersonaABM;
import negocio.SubeABM;
import negocio.UsuarioABM;

public class TestAgregarPersona {
	public static void main(String[] args) {
		try {
			String apellido = "Goday";
			String nombre = "Nicolas";
			int documento = 33401020;
			PersonaABM abm = new PersonaABM();
			SubeABM subeabm = new SubeABM();
			UsuarioABM usuarioabm = new UsuarioABM();
			
			long ultimoIdCliente = abm.agregar(apellido,
										nombre, documento, true, true, subeabm.traerSube(1234));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}