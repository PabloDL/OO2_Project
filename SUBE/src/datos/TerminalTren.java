package datos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TerminalTren extends Terminal {
	private String linea;
	private String ramal;
	private String estacion;

	public TerminalTren(String linea, String ramal, String estacion) {
		super();
		this.linea = linea;
		this.ramal = ramal;
		this.estacion = estacion;
		this.viajes = new ArrayList<Viaje>();
	}
	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea, String ramal, String estacion) {
		this.linea = linea;
	}


	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
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
	
	public int calcularMontoEntreEstaciones() {
		return 0;
	}

	public float calcularDescuento(Sube sube) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Viaje cobrar(Sube sube, int tarifaViaje) { // tarifaViaje es el tramo que tiene q cobrar
		// FALTA LEVANTAR DE APPTABLE En este caso el monto es fijo, lo levanto de la
		// tabla de parametros
		// Convierto el tramo que indica el colectivero o el molinete en un valor en
		// pesos
		// DE LA SUBE SACO EL ULTIMO VIAJE Y VEO SI TRANSCURRE EN LAS PRIMERAS DOS
		// HORAS-> EL METODO
		// DEVUELVE EL DESCUENTO QUE TENGO QUE HACER EN EL PRECIO, ACA ANALIZA SI ES
		// BOLETO ESTUDIANTIL, SI TARIFA SOCIAL
		double precioBoleto = this.calcularPrecio(sube, 0);
		Tren tren;
		Viaje nuevoViaje;
		// creo un viaje y cargo los datos necesarios,
		if(this.verificarSaldoSuficiente(sube, precioBoleto)) {
			tren = new Tren(this.linea, this.ramal, this.estacion);
			nuevoViaje = new Viaje(precioBoleto, tren); // GUARDO TARIFA VIAJE O MONTO REAL PAGADO?
		// YA ESTA CALCULADO float monto = nuevoViaje.calcularMonto(descuentoAAplicar);
		// //CALCULA A PARTIR DEL TRANSPORTE EL MONTO -> si fuera otro transporte en el
		// contructor detallo el tramo o estacion
		// UNA VEZ CREADO EL VIAJE LO AGREGO A LOS VIAJES PARA LUEGO PERSISTIRLO LLAMANDO A INFORMAR VIAJES
			this.viajes.add(nuevoViaje); //---> TENGO Q VER COMO VOY A HACER Q EN LA TABLA DE VIAJES INFORMADOS SE GUARDEN LA ACTUALIZACION
			//DEL PRECIO, ES NECESARIO ? SE PUEDEN GUARDAR UN PRECIO NEGATIVO Y LISTO, total la actualizacion de saldo ya se hizo en la
			//SUBE
		}
		else {
			nuevoViaje = null;
		}			
		
		return nuevoViaje; // TENGO Q DEVOLVER EL VIAJE PARA Q LA SUBE PUEDE ACTUALIZAR EL SALDO Y LA LISTA
						// DE VIAJES //AGREGO EL VIAJE A LA LISTA DE SUBE
	}
	

	@Override
	public double calcularPrecio(Sube sube, int tramoACobrar) {
		double descuentoRedSube = 0;
		DatosGenerales datosGenerales = new DatosGenerales();
		double tarifa = datosGenerales.getMontoTren3();// ELIJO EL MONTO MAXIMO DE TREN (SI NO ES SALIDA VA ESE)
		
		if (sube.getUltimosViajes().size() > 0) {
			Viaje ultimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 1);
			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
			
			if ( !(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Tren")) || (ultimoViaje.getTransporte().getClass().getSimpleName().equals("Tren")
					  		&& ((Tren)(ultimoViaje.getTransporte())).getLinea() != this.linea && ((Tren)(ultimoViaje.getTransporte())).getRamal() != this.ramal)) {// SI ES DISTINTO DE TREN, CALCULO LOS DESCUENTOS, SI ES TREN VEO SI ES SALIDA
																					// OJOOO TENGO Q EVALUAR SI ES OTRA LINEA DE TREN
				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
					descuentoRedSube = 0.50;
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (sube.getUltimosViajes().size() > 1) {
						Viaje anteUltimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 2);
						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS
																								// A TIEMPO INICIAL
						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
	
						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
							descuentoRedSube = 0.75;
						}
					}
				}
			}
			else { //SI ESTO ACA, ME ENCUENTRO MARCANDO UNA SALIDA
				//ACA LLAMO A LA CLASE CON LAS TARIFAS DEL TREN Y LE PASO LA ESTACION DE SALIDA
				tarifa = datosGenerales.traerTarifaTren(((Tren)(ultimoViaje.getTransporte())).getEstacionOrigen(), this.estacion);
// SI ES SALIDA NO TENGO Q SUMAR AL BOLETO,SINO RESTAR LO Q CORRESPONDA, QUEDA NGATIVO
//POR EJEMPLO, SI EL BOLETO MAXIMO SALIO 6 Y EN REALIDAD EN LA SALIDA DEBERIA HABER SIDO $3, LO Q HAGO ES RESTAR, EL TEMA ES SI APLICARON DESCUENTOS...
				tarifa = -tarifa; //- datosGenerales.getMontoTren3(); // getMontoTren3() --> iria tarifa maxima tren 
//TENGO QUE RECALCULAR A PARTIR DE LOS ULTIMOS 3 VIAJES, EN LUGAR D LOS ULTIMOS 2, TENGO Q AGARRAR Y VER PARA EL PRIMER VIAJE DE TREN QUE DESCUENTOS
				if (sube.getUltimosViajes().size() > 1) { //POR LO MENOS TIENE Q TENER UN VIAJE ANTES DEL TREN(EL TREN seria en posicion 1, en 0 otro)
					ultimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 2);
					tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
					tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL

					if (ultimoViaje.getTransporte().getClass().getSimpleName() != "Tren" || (ultimoViaje.getTransporte().getClass().getSimpleName() == "Tren"
							  		&& ((Tren)(ultimoViaje.getTransporte())).getLinea() != this.linea && ((Tren)(ultimoViaje.getTransporte())).getRamal() != this.ramal)) {// SI ES DISTINTO DE TREN, CALCULO LOS DESCUENTOS, SI ES TREN VEO SI ES SALIDA
																							// OJOOO TENGO Q EVALUAR SI ES OTRA LINEA DE TREN
						if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
							descuentoRedSube = 0.50;
							// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
							if (sube.getUltimosViajes().size() > 2) {
								Viaje anteUltimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 3);
								LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS
																										// A TIEMPO INICIAL
								LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
	
								if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
									descuentoRedSube = 0.75;
								}
							}
						}
					}
				}
			//SE APLICARON Y APLICAR LOS MISMOS A LO QUE HAY Q DEVOLVER AHORA
				
			}
		}
		
		if (sube.getPersona().isEsTarifaSocial() == true) {
			tarifa = datosGenerales.getTarifaSocialTren();
		}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = datosGenerales.getTarifaEstudiantilTren();
		}
					
		return (tarifa - (tarifa * descuentoRedSube)); // si la tarifa es - quiere decir que es una salida 
	}

	@Override
	public boolean verificarSaldoSuficiente(Sube sube, double precioBoleto) {
		DatosGenerales datosGenerales = new DatosGenerales();
		if (sube.getSaldo() - precioBoleto > datosGenerales.getSaldoMinimo())
			return true;

		return false;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

}
