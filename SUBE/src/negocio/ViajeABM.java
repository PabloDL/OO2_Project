package negocio;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import dao.SubeDao;
import dao.ViajeDao;
import datos.Colectivo;
import datos.DatosFuncionales;
import datos.Sube;
import datos.Transporte;
import datos.Tren;
import datos.Viaje;

public class ViajeABM {
	ViajeDao dao = new ViajeDao();
	boolean INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA = false;

	public Viaje traerViaje(long idViaje) throws Exception {
		Viaje c = dao.traerViaje(idViaje);
		// implementar si c es null lanzar Exception ->!
		if (c == null) {
			throw new Exception("ERROR: NO EXISTE Viaje");
		}
		return c;
	}

	public int agregar(double tarifa, Transporte t, Sube s) throws Exception {

		Viaje c = new Viaje(tarifa, t, s);

		return dao.agregar(c);
	}

	public void eliminar(long idViaje) throws Exception {

		// * en este caso es física en gral. no se se aplicaría este caso de uso, si se
		// hiciera habría que validar que el cliente no tenga dependencias
		//
		Viaje c = dao.traerViaje(idViaje);
		if (c == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
		}
		dao.eliminar(c);
	}

	// ACA VAN METODOS
	public void agregarViaje(Viaje v) throws Exception {
		SubeABM subeABM = new SubeABM();
		Sube s = subeABM.traerSube(v.getSube().getIdSube());
		double precioBoleto = this.calcularPrecio(v); // si el precio es (-) quiere decir que es ua salida de tren
		v.setTarifa(precioBoleto);
		if (!(subeABM.verificarSaldoSuficiente(v.getSube().getIdSube(), precioBoleto))) {
			throw new Exception("ERROR: SALDO INSUFIECIENTE");
		}
		 // Si el precio es (-) era un tren tengo que pisar el ultimo valor, o si es 0, puede que sea tarifa estudiantil
		if (precioBoleto < 0 || INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA == true) {
			List<Viaje> ultimosNviajes = this.traerUltimosNViajes(v.getSube());
			Iterator<Viaje> it = ultimosNviajes.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next();
				double precioAux = ultimoViaje.getTarifa();
				ultimoViaje = this.agregarDestinoAViaje(ultimoViaje, v);
				s.setSaldo(s.getSaldo() - ultimoViaje.getTarifa() + precioAux);
				dao.actualizar(ultimoViaje);
				INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA = false;
			}
		} else {
			s.setSaldo(s.getSaldo() - v.getTarifa());
			dao.agregar(v);
		}

		SubeDao subeDao = new SubeDao();
		subeDao.actualizar(s);
	}

	private List<Viaje> traerUltimosNViajes(Sube sube) {
		return dao.traerNUltimosViajes(sube);
	}
	
	private double calcularPrecio(Viaje viaje) throws Exception {
		if (viaje.getTransporte().getClass().getSimpleName().equals("Subte")) {
			return calcularPrecioSubte(viaje);
		}
		else if (viaje.getTransporte().getClass().getSimpleName().equals("Tren")) {
			return calcularPrecioTren(viaje);
		} 
		else if (viaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) {
			return calcularPrecioColectivo(viaje);
		} 
			
		return 0;
	}

	private double calcularPrecioColectivo(Viaje v) throws Exception {
		double descuentoRedSube = 0;
		double tarifa = v.getTarifa();
		SubeABM subeABM = new SubeABM();
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		
		Sube sube = subeABM.traerSube(v.getSube().getIdSube());

		if (sube == null) {
			throw new Exception("ERROR: NO EXISTE SUBE");
		}
		// Traigo ultimos 5 viajes de la sube para verificar redSube --> VER COMO HACER
		// Q CADA 6 DEJE DE APLICAR RED SUBE
		List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube);

		Iterator<Viaje> it = ultimosNviajes.iterator();
		if (it.hasNext()) {
			Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje
			GregorianCalendar tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			GregorianCalendar tiempoFinal = ultimoViaje.getFechaHoraInicio(); //TIEMPO FINAL ES TIEMPO INICIAL + 2 HS
			tiempoFinal.add((GregorianCalendar.HOUR_OF_DAY),2); //
			
			if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) || 
					((ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) && 
							((Colectivo)ultimoViaje.getTransporte()).getLinea() != ((Colectivo)v.getTransporte()).getLinea() ||
								((Colectivo)ultimoViaje.getTransporte()).getRamal() != ((Colectivo)v.getTransporte()).getRamal()) ){
				
				if ((new GregorianCalendar()).getTimeInMillis() < tiempoFinal.getTimeInMillis()){
					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						GregorianCalendar tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						GregorianCalendar tiempoFinalAnteUltimoViaje = tiempoAnteUltimo;
						tiempoFinalAnteUltimoViaje.add((GregorianCalendar.HOUR_OF_DAY), 2);
						long hora1 = tiempoFinalAnteUltimoViaje.getTimeInMillis();
						long hora2 = tiempoInicial.getTimeInMillis();
						
						if (tiempoFinalAnteUltimoViaje.getTimeInMillis() >= tiempoInicial.getTimeInMillis()) {							
							descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
						}
					}
				}
			}

		}
		if (sube.getPersona().isEsTarifaSocial() == true) {
			tarifa = tarifa - (tarifa * dG.getPrecioAsignacionColectivo());
		}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = tarifa - (tarifa * dG.getPrecioEstudiantilColectivo());
		}
		return (tarifa - (tarifa * descuentoRedSube));
	}

	private double calcularPrecioTren(Viaje v) throws Exception {
		double descuentoRedSube = 0;
		double tarifa = v.getTarifa();
		SubeABM subeABM = new SubeABM();
		TransporteABM transporteABM = new TransporteABM();
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		
		Sube sube = subeABM.traerSube(v.getSube().getIdSube());

		if (sube == null) {
			throw new Exception("ERROR: NO EXISTE SUBE");
		}
		
		// Traigo ultimos 5 viajes de la sube para verificar redSube --> VER COMO HACER
		// Q CADA 6 DEJE DE APLICAR RED SUBE
		List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube);

		Iterator<Viaje> it = ultimosNviajes.iterator();
		if (it.hasNext()) {
			Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje
			GregorianCalendar tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			GregorianCalendar tiempoFinal = ultimoViaje.getFechaHoraInicio(); //TIEMPO FINAL ES TIEMPO INICIAL + 2 HS
			tiempoFinal.add((GregorianCalendar.HOUR_OF_DAY),2);			
			
			Transporte ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());
			if (ultimoTransporte == null) {
				throw new Exception("ERROR: NO EXISTE TRANSPORTE");
			}

			if ( (!(ultimoTransporte.getClass().getSimpleName().equals("Tren"))) || 
					(ultimoTransporte.getClass().getSimpleName().equals("Tren")) && 
							((Tren)ultimoTransporte).getLinea().compareTo(((Tren)v.getTransporte()).getLinea()) != 0 || ( 
									((ultimoTransporte.getClass().getSimpleName().equals("Tren")) && 
											((Tren)ultimoTransporte).getLinea().compareTo(((Tren)v.getTransporte()).getLinea()) == 0
											&& ((Tren)ultimoTransporte).getEstacionDestino().compareTo("-") != 0))){ // VEO Q NO SEA UNA NUEVA ENTRADA
				
				if ((new GregorianCalendar()).getTimeInMillis() <= tiempoFinal.getTimeInMillis()){
					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						GregorianCalendar tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						GregorianCalendar tiempoFinalAnteUltimoViaje = tiempoAnteUltimo;
						tiempoFinalAnteUltimoViaje.add((GregorianCalendar.HOUR_OF_DAY), 2);
					
						if (tiempoFinalAnteUltimoViaje.getTimeInMillis() >= tiempoInicial.getTimeInMillis()  ){							
							descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
						}
					}
				}
			}
			else { //SI ES UN TREN Y LA MISMA LINEA, entonces es una salida
				//tarifa = dG.traerTarifaTren(((Tren)ultimoTransporte).getEstacionOrigen(), ((Tren)(v.getTransporte())).getEstacionOrigen());
				SeccionABM secABM = new SeccionABM();
				tarifa = secABM.getMontoEntreEstaciones(((Tren)(v.getTransporte())).getEstacionOrigen(), ((Tren)ultimoTransporte).getEstacionOrigen());
				INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA = true;
				//tarifa = (((Tren)(ultimoViaje.getTransporte())).getMontoEntreEstaciones(this.estacion);
// SI ES SALIDA NO TENGO Q SUMAR AL BOLETO,SINO RESTAR LO Q CORRESPONDA, QUEDA NGATIVO
//POR EJEMPLO, SI EL BOLETO MAXIMO SALIO 6 Y EN REALIDAD EN LA SALIDA DEBERIA HABER SIDO $3, LO Q HAGO ES RESTAR, EL TEMA ES SI APLICARON DESCUENTOS...
				tarifa = -tarifa; //- datosGenerales.getMontoTren3(); // getMontoTren3() --> iria tarifa maxima tren 
//TENGO QUE RECALCULAR A PARTIR DE LOS ULTIMOS 3 VIAJES, EN LUGAR D LOS ULTIMOS 2, TENGO Q AGARRAR Y VER PARA EL PRIMER VIAJE DE TREN QUE DESCUENTOS
				if (it.hasNext()) { //POR LO MENOS TIENE Q TENER UN VIAJE ANTES DEL TREN(EL TREN seria en posicion 1, en 0 otro)
					ultimoViaje = it.next();
					tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
					tiempoFinal = ultimoViaje.getFechaHoraInicio(); //TIEMPO FINAL ES TIEMPO INICIAL + 2 HS
					tiempoFinal.add((GregorianCalendar.HOUR_OF_DAY),2); //
					
					ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());
					if (ultimoTransporte == null) {
						throw new Exception("ERROR: NO EXISTE TRANSPORTE");
					}


					if (ultimoTransporte.getClass().getSimpleName() != "Tren" || 
							(ultimoTransporte.getClass().getSimpleName() == "Tren" && 
								((Tren)(ultimoTransporte)).getLinea() != ((Tren)v.getTransporte()).getLinea() )) {// SI ES DISTINTO DE TREN, CALCULO LOS DESCUENTOS, SI ES TREN VEO SI ES SALIDA
																							// OJOOO TENGO Q EVALUAR SI ES OTRA LINEA DE TREN
						if ((new GregorianCalendar()).getTimeInMillis() <= tiempoFinal.getTimeInMillis()){
							descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
							// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
							if (it.hasNext()) {
								Viaje anteUltimoViaje = it.next();
								GregorianCalendar tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS
																										// A TIEMPO INICIAL
								GregorianCalendar tiempoFinalAnteUltimoViaje = tiempoAnteUltimo;
								tiempoFinalAnteUltimoViaje.add((GregorianCalendar.HOUR_OF_DAY), 2);
	
								if (tiempoFinalAnteUltimoViaje.getTimeInMillis() >= tiempoInicial.getTimeInMillis()) {
									descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
								}
							}
						}				
					}
				}
			}
		}
		if (sube.getPersona().isEsTarifaSocial() == true) {
				tarifa = tarifa - (tarifa * dG.getPrecioAsignacionTren());
		}
				
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = tarifa - (tarifa *dG.getPrecioEstudiantilTren());
		}
		return (tarifa - (tarifa * descuentoRedSube));
		
	}

	private double calcularPrecioSubte(Viaje v) throws Exception {
		double descuentoRedSube = 0;
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		double tarifa = v.getTarifa();
		SubeABM subeABM = new SubeABM();
		TransporteABM transporteABM = new TransporteABM();
		Sube sube = subeABM.traerSube(v.getSube().getIdSube());

		if (sube == null) {
			throw new Exception("ERROR: NO EXISTE SUBE");
		}
		// Traigo ultimos 5 viajes de la sube para verificar redSube --> VER COMO HACER
		// Q CADA 6 DEJE DE APLICAR RED SUBE
		List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube); 

		Iterator<Viaje> it = ultimosNviajes.iterator();
		if (it.hasNext()) {
			Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje
			GregorianCalendar tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			GregorianCalendar tiempoFinal = ultimoViaje.getFechaHoraInicio(); //TIEMPO FINAL ES TIEMPO INICIAL + 2 HS
			tiempoFinal.add((GregorianCalendar.HOUR_OF_DAY),2); //
			
			Transporte ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());
			if (ultimoTransporte == null) {
				throw new Exception("ERROR: NO EXISTE TRANSPORTE");
			}
			
			if (!(ultimoTransporte.getClass().getSimpleName().equals("Subte"))) {// EN este caso si es
																							// otrosubte no aplica dt
				if ((new GregorianCalendar()).getTimeInMillis() <= tiempoFinal.getTimeInMillis()){
										 
					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						GregorianCalendar tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						GregorianCalendar tiempoFinalAnteUltimoViaje = tiempoAnteUltimo;
						tiempoFinalAnteUltimoViaje.add((GregorianCalendar.HOUR_OF_DAY), 2);
						if (tiempoFinalAnteUltimoViaje.getTimeInMillis() >= tiempoInicial.getTimeInMillis()) {							
							descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
						}
					}
				}
			}

		}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = tarifa - (tarifa * dG.getPrecioEstudiantilSubte());
		}
		return (tarifa - (tarifa * descuentoRedSube));
	}
	
	public Viaje agregarDestinoAViaje(Viaje viajeOrigen, Viaje viaje) throws Exception {
		// SOLO tren admite setear salida, si quiero agregar los otros deberia definirlo
		TransporteABM transporteABM = new TransporteABM();
		Transporte transporte = transporteABM.traer(viajeOrigen.getTransporte().getIdTransporte());
		if (transporte == null) {
			throw new Exception("ERROR: NO EXISTE TRANSPORTE");
		}
		String estacionDestino  = ((Tren)viaje.getTransporte()).getEstacionOrigen();
		GregorianCalendar fechaHoraSalida = new GregorianCalendar();
		double tarifaFinal = -viaje.getTarifa();
		//SETEO LOS VALORES EN EL TRANSPORTE
		((Tren)transporte).setEstacionDestino(estacionDestino);
		((Tren)transporte).setFechaHoraSalida(fechaHoraSalida);
		
		viajeOrigen.setTransporte(transporte);
		viajeOrigen.setTarifa(tarifaFinal);
		
		return viajeOrigen;
	}

	public List<Viaje> traerViaje(Sube s) {
		return dao.traerViaje(s);
	}
}
