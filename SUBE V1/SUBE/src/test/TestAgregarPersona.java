package test;

import negocio.PersonaABM;
public class TestAgregarPersona {
public static void main(String[] args) {
	try {
		String apellido= "Goday" ;
		String nombre= "Nicolas" ;
		int documento=33401014;
		PersonaABM abm= new PersonaABM();
		long ultimoIdCliente = abm.agregar(apellido, nombre, documento,true,true);
		}
	catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
}