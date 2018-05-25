package datos;

import dao.DatosFuncionalesDao;

public class TerminalSubte /*extends Terminal*/ {
	private long idTerminalSubte; 
	private String letra;
	
	public TerminalSubte() {	}
	
	public TerminalSubte(String letra) {
		super();
		this.letra = letra;
		//this.viajes = new ArrayList<Viaje>();
	}
	
	public void inicializarListaViajes() { //BORRAR CUANDO SE LEVANTEN LA LISTA DE VIAJESSSS
		//this.viajes = new ArrayList<Viaje>();
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public long getIdTerminalSubte() {
		return idTerminalSubte;
	}

	protected void setIdTerminalSubte(long idTerminalSubte) {
		this.idTerminalSubte = idTerminalSubte;
	}


//	@Override
//	public boolean registrarPago(long idSube) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean informarViajes() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Viaje cobrar(Sube sube, int tarifaViaje) { // tarifaViaje es el tramo que tiene q cobrar
//		// FALTA LEVANTAR DE APPTABLE En este caso el monto es fijo, lo levanto de la
//		// tabla de parametros
//		// Convierto el tramo que indica el colectivero o el molinete en un valor en
//		// pesos
//		// DE LA SUBE SACO EL ULTIMO VIAJE Y VEO SI TRANSCURRE EN LAS PRIMERAS DOS
//		// HORAS-> EL METODO
//		// DEVUELVE EL DESCUENTO QUE TENGO QUE HACER EN EL PRECIO, ACA ANALIZA SI ES
//		// BOLETO ESTUDIANTIL, SI TARIFA SOCIAL
//		double precioBoleto = this.calcularPrecio(sube, 0);
//		Subte subte;
//		Viaje nuevoViaje;
//		// creo un viaje y cargo los datos necesarios,
//		if(this.verificarSaldoSuficiente(sube, precioBoleto)) {
//			subte = new Subte(this.letra);
//			nuevoViaje = new Viaje(precioBoleto, subte, sube); // GUARDO TARIFA VIAJE O MONTO REAL PAGADO?
//		// YA ESTA CALCULADO float monto = nuevoViaje.calcularMonto(descuentoAAplicar);
//		// //CALCULA A PARTIR DEL TRANSPORTE EL MONTO -> si fuera otro transporte en el
//		// contructor detallo el tramo o estacion
//		// UNA VEZ CREADO EL VIAJE LO AGREGO A LOS VIAJES PARA LUEGO PERSISTIRLO LLAMANDO A INFORMAR VIAJES
//			this.viajes.add(nuevoViaje);
//		}
//		else {
//			nuevoViaje = null;
//		}			
//		
//		return nuevoViaje; // TENGO Q DEVOLVER EL VIAJE PARA Q LA SUBE PUEDE ACTUALIZAR EL SALDO Y LA LISTA
//						// DE VIAJES //AGREGO EL VIAJE A LA LISTA DE SUBE
//	}
//
//	@Override
//	public double calcularPrecio(Sube sube, int tramoACobrar) {
//		double descuentoRedSube = 0;
//		DatosGenerales datosGenerales = new DatosGenerales();
//		double tarifa = datosGenerales.getMontoSubte();
//		/*
//		if (sube.getUltimosViajes().size() > 0) {
//			Viaje ultimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 1);
//			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
//			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
//
//			if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Subte")))  {// EN este caso si es otro subte no
//																					// aplica dt
//				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
//					descuentoRedSube = 0.50;
//					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
//					if (sube.getUltimosViajes().size() > 1) {
//						Viaje anteUltimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 2);
//						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS
//																								// A TIEMPO INICIAL
//						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
//	
//						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
//							descuentoRedSube = 0.75;
//						}
//					}
//				}
//			}
//		}
//		//SUBTE NO TIENE TARIFA SOCIAL
////		if (sube.getPersona().isEsTarifaSocial() == true) {
//	//		datosGenerales.getTarifaSocialSubte();
//		//}
//		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
//			tarifa = datosGenerales.getTarifaEstudiantilSubte();
//		}
//			*/		
//		return (tarifa - (tarifa * descuentoRedSube)); 
//	}
//
//	@Override
//	public boolean verificarSaldoSuficiente(Sube sube, double precioBoleto) {
//		DatosGenerales datosGenerales = new DatosGenerales();
//		if (sube.getSaldo() - precioBoleto  > datosGenerales.getSaldoMinimo() )
//			return true;
//			
//		return false;
//	}

}
