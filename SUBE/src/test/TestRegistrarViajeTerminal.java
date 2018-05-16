package test;
import datos.Persona;
import datos.Sube;
import datos.TerminalColectivo;
import datos.TerminalSubte;
import datos.TerminalTren;
import datos.Viaje;

public class TestRegistrarViajeTerminal {
	public static void main(String[] args) {
		Persona p1 = new Persona("Perez","juan",33412412, false, false);
		Persona p2 = new Persona("Gonzales","Pedro",4444444, true, false);
		Persona p3 = new Persona("Fernandez","Jose",5555555, false,true);
		Persona p4 = new Persona("Gomez","Andres",6666666, true,true);
		
		Sube s = new Sube(1, 1234, p1,  50);
		
		TerminalSubte ts1 = new TerminalSubte("A");
		TerminalSubte ts2 = new TerminalSubte("B");
		
		TerminalColectivo tc1 = new TerminalColectivo("295", "A", 24);
		TerminalTren tt1 = new TerminalTren("Roca","Ezeiza","Lanus");
		
		Viaje v = ts1.cobrar( s, 7);
		
		if (v != null) {
			s.agregarViaje(v);
		}
		
		Viaje v2 = tc1.cobrar(s,1);
		
		if (v2 != null) {
			s.agregarViaje(v2);
		}
		
		Viaje v3 = ts2.cobrar(s,1);
		
		if (v3 != null) {
			s.agregarViaje(v3);
		}
		
		Viaje v4 = tt1.cobrar(s,1);
		
		if (v4 != null) {
			s.agregarViaje(v4);
		}
		
		System. out .println( s.toString());
		
		Viaje v5 = tt1.cobrar(s,1);
		
		if (v5 != null) {
			//PARA TREN HAY QUE VERIFICAR QUE NO SEA -.SI LO ES -> ES UNA LLEGADA, TENGO QUE ACTUALIZAR EL PASAJE
			s.agregarViaje(v5);
		}

		//System. out .println( ts1.toString());
		System. out .println( s.toString());
	}
}