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
			PersonaABM personaabm = new PersonaABM();
			//abm.agregar("Fiasche", "Nicolas", 9999999, false, false, subeabm.traerSube(3333));

			//AGREGO PERSONA
			long ultimoIdCliente = personaabm.agregar("Sanchez","Pedro",33333, true,false);
			//long ultimoIdUsuario = usuarioabm.agregar(nombreUsuario, password, ultimoIdCliente);
			Persona persona = personaabm.traerPersona((long)ultimoIdCliente);
			System.out.println(persona);			
				
			//AGREGO SUBE A PERSONA
			subeabm.agregar(7777, persona, 500);
			Sube s = subeabm.traerSube(7777);
			System.out.println(s);	
			
			//s.setPersona(persona);
			//subeabm.actualizar(s);
			persona.setSube(s);
			personaabm.modificar(persona);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}