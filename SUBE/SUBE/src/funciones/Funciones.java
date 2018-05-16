package funciones;
import java.util.GregorianCalendar;

public class Funciones {

	public static String traerFechaCorta (GregorianCalendar fechaDeNacimiento ) {
		return fechaDeNacimiento.getTime().toString();
	}
}
