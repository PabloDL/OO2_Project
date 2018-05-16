package datos;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;

public class TerminalSubte extends Terminal {
	String letra;
	List<Viaje> viajesInformar;

	public TerminalSubte(String letra) {
		super();
		this.letra = letra;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public boolean registrarPago(long idSube) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean informarViajes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cobrar(int tarifaViaje, Sube sube) { // tarifaViaje es el tramo que tiene q cobrar
		// FALTA LEVANTAR DE APPTABLE En este caso el monto es fijo, lo levanto de la
		// tabla de parametros
		// Convierto el tramo que indica el colectivero o el molinete en un valor en
		// pesos

		// DE LA SUBE SACO EL ULTIMO VIAJE Y VEO SI TRANSCURRE EN LAS PRIMERAS DOS
		// HORAS-> EL METODO
		// DEVUELVE EL DESCUENTO QUE TENGO QUE HACER EN EL PRECIO, ACA ANALIZA SI ES
		// BOLETO ESTUDIANTIL, SI TARIFA SOCIAL
		float precioBoleto = this.calcularPrecio(sube);
		// creo un viaje y cargo los datos necesarios,
		Subte subte = new Subte(this.letra);
		Viaje nuevoViaje = new Viaje(precioBoleto, subte); // GUARDO TARIFA VIAJE O MONTO REAL PAGADO?
		// YA ESTA CALCULADO float monto = nuevoViaje.calcularMonto(descuentoAAplicar);
		// //CALCULA A PARTIR DEL TRANSPORTE EL MONTO -> si fuera otro transporte en el
		// contructor detallo el tramo o estacion

		// UNA VEZ CREADO EL VIAJE LO AGREGO A LOS VIAJES PARA PERSISTIRLO
		this.viajes.add(nuevoViaje);
		this.informarViajes();
		return true; // TENGO Q DEVOLVER EL VIAJE PARA Q LA SUBE PUEDE ACTUALIZAR EL SALDO Y LA LISTA
						// DE VIAJES //AGREGO EL VIAJE A LA LISTA DE SUBE
	}

	@Override
	public float calcularPrecio(Sube sube) {
		int descuentoRedSube = 0;
		DatosGenerales datosGenerales = new DatosGenerales();
		float tarifa = datosGenerales.getMontoSubte();
		
		Viaje ultimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 1);
		LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
		LocalDateTime tiempoFinal = tiempoInicial.plusHours(2);  //SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
				
		if (ultimoViaje.getTransporte().getClass().getSimpleName() == "Subte") {// EN este caso si es otro subte no
																				// aplica dt
			if (tiempoInicial.compareTo(tiempoFinal) >= 0) {
				descuentoRedSube = 50;
				// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
				Viaje anteUltimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 2); 
				LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL											
				LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL

				if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
					descuentoRedSube = 75;
				}
			}
		}
		
		//SUBTE NO TIENE TARIFA SOCIAL
//		if (sube.getPersona().isEsTarifaSocial() == true) {
	//		datosGenerales.getTarifaSocialSubte();
		//}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = datosGenerales.getTarifaEstudiantilSubte();
		}
			
		
		return tarifa - (tarifa * (float)descuentoRedSube / 100); 
	}

}
