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
	boolean REINICIAR_RED_SUBE = false;

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
		List<Viaje> ultimosNviajes = this.traerViajesRedSube(v.getSube());
		if (!(subeABM.verificarSaldoSuficiente(v.getSube().getIdSube(), precioBoleto))) {
			throw new Exception("ERROR: SALDO INSUFICIENTE");
		}
		 // Si el precio es (-) era un tren tengo que pisar el ultimo valor, o si es 0, puede que sea tarifa estudiantil
		if (precioBoleto < 0 || INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA == true) {
			
			Iterator<Viaje> it = ultimosNviajes.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next();
				double precioAux = ultimoViaje.getTarifa();
				ultimoViaje = this.agregarDestinoAViaje(ultimoViaje, v);
				s.setSaldo(s.getSaldo() - ultimoViaje.getTarifa() + precioAux);
				dao.actualizar(ultimoViaje);
				INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA = false;
				if (this.REINICIAR_RED_SUBE == true) {
					s.setPrimerViajeRedSube(ultimoViaje);
					this.REINICIAR_RED_SUBE = false;
				}
			}
		} else {
			s.setSaldo(s.getSaldo() - v.getTarifa());
			dao.agregar(v);
			if (this.REINICIAR_RED_SUBE == true) {
				s.setPrimerViajeRedSube(v);
				this.REINICIAR_RED_SUBE = false;
			}
		}
					
		SubeDao subeDao = new SubeDao();
		subeDao.actualizar(s);
	}

	private List<Viaje> traerUltimosNViajes(Sube sube) {
		return dao.traerNUltimosViajes(sube);
	}
	//DEVUELVE LA LISTA DE LOS VIAJES EN LA RED SUBE.
	//SI NO HAY VIAJES, EL PRIMER VIAJE TRANSCURRIO HACE MAS DE DOS HORAS O
	//SI LA LISTA DE VIAJES EN LA RED SUBE ES MAYOR A 6 DEVUELVE NULL
	private List<Viaje> traerViajesRedSube(Sube sube) {
		List<Viaje> listaViajesRedSube = null;
		Viaje primerViajeRedSube = null;
		listaViajesRedSube =  dao.traerViajesRedSube(sube);
		if (listaViajesRedSube != null) {
			if (listaViajesRedSube.size() >= 6) //SI LA LISTA TIENE 6 VIAJES TENGO QUE REINICIAR LA RED 
				listaViajesRedSube = null;
			else {  //si la lista tiene menos de 6 elementos, me paro en el ultimo y veo si transcurrio hace
				//mas de dos horas
				Iterator<Viaje> itViajes = listaViajesRedSube.iterator();
				while (itViajes.hasNext()) {
					primerViajeRedSube = itViajes.next();
				} // ME PARO EN EL ULTIMO ELEMENTO
				GregorianCalendar tiempoPrimerViajeRedSubeMasDosHoras = (GregorianCalendar) primerViajeRedSube.getFechaHoraInicio().clone();
				tiempoPrimerViajeRedSubeMasDosHoras.add(GregorianCalendar.HOUR_OF_DAY,2);
				//SI EL TIEMPO DEL PRIMER VIAJE + DOS HORAS ES MAYOR QUE EL NUEVO VIAJE, TENGO Q REINICIAR LA RED
				if (tiempoPrimerViajeRedSubeMasDosHoras.getTimeInMillis() < (new GregorianCalendar()).getTimeInMillis()) {
					listaViajesRedSube = null;
				}			
			}
		}
		return listaViajesRedSube;
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
		TransporteABM transporteABM = new TransporteABM();
		DatosFuncionales dG = DatosFuncionalesABM.getInstance().traer();
		
		Sube sube = subeABM.traerSube(v.getSube().getIdSube());

		if (sube == null) {
			throw new Exception("ERROR: NO EXISTE SUBE");
		}
		List<Viaje> viajesRedSube = this.traerViajesRedSube(sube);
		//List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube);
		if (viajesRedSube != null) { // -> evaluar transporte,
			// hace falta evaluar horas x esta dentro de las dos horas cuando traigo la
			// lista
			Iterator<Viaje> it = viajesRedSube.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje
				Transporte ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());

				if (ultimoTransporte == null) {
					throw new Exception("ERROR: NO EXISTE TRANSPORTE");
				}
				// Solo aplica descuentos si el anterior no era un subte
				if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) || 
						((ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) && 
								((Colectivo)ultimoViaje.getTransporte()).getLinea() != ((Colectivo)v.getTransporte()).getLinea() ||
									((Colectivo)ultimoViaje.getTransporte()).getRamal() != ((Colectivo)v.getTransporte()).getRamal()) ){

					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					// si la cola de red sube tiene otro viaje aplico segundo descuento
					if (it.hasNext()) {
						descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
					}
				} else { // SI ERA SUBTE EL ANTERIOR SE ROMPE LA RED SUBE
					REINICIAR_RED_SUBE = true;
				}
			}
		}
		else { //Si la lista era null no aplica descuento porque es mayor a 2 hs o mayor a 6 viajes
			//o no existia ningun viaje anterior, tengo que indicar que la red debe reiniciarse para setear el viaje en la sube
			REINICIAR_RED_SUBE = true;
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
		
		//List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube);
		List<Viaje> viajesRedSube = this.traerViajesRedSube(sube);

		if (viajesRedSube != null) { // -> evaluar transporte,

			Iterator<Viaje> it = viajesRedSube.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje

				Transporte ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());
				if (ultimoTransporte == null) {
					throw new Exception("ERROR: NO EXISTE TRANSPORTE");
				}

				if ((!(ultimoTransporte.getClass().getSimpleName().equals("Tren")))
						|| (ultimoTransporte.getClass().getSimpleName().equals("Tren")) && ((Tren) ultimoTransporte)
								.getLinea().compareTo(((Tren) v.getTransporte()).getLinea()) != 0
						|| (((ultimoTransporte.getClass().getSimpleName().equals("Tren"))
								&& ((Tren) ultimoTransporte).getLinea()
										.compareTo(((Tren) v.getTransporte()).getLinea()) == 0
								&& ((Tren) ultimoTransporte).getEstacionDestino().compareTo("-") != 0))) { 
					// VEO Q NO SEA UNA NUEVA ENTRADA
					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					if (it.hasNext()) {
						descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
					}
				} else { // SI ES UN TREN Y LA MISMA LINEA, entonces es una salida
					SeccionABM secABM = new SeccionABM();
					tarifa = secABM.getMontoEntreEstaciones(((Tren) (v.getTransporte())).getEstacionOrigen(),
							((Tren) ultimoTransporte).getEstacionOrigen());
					INDICADOR_VIAJE_TREN_TARIFA_ESTUDIANTIL_MARCAR_VUELTA = true;
					tarifa = -tarifa; 
					// TENGO QUE RECALCULAR A PARTIR DE LOS ULTIMOS 3 VIAJES, EN LUGAR D LOS ULTIMOS
					// 2, VER PARA EL PRIMER VIAJE DE TREN QUE DESCUENTOS SE HICIERON
					if (it.hasNext()) { // POR LO MENOS TIENE Q TENER UN VIAJE ANTES DEL TREN(EL TREN seria en posicion
										// 1, en 0 otro)
						ultimoViaje = it.next();
						ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());
						if (ultimoTransporte == null) {
							throw new Exception("ERROR: NO EXISTE TRANSPORTE");
						}

						if (ultimoTransporte.getClass().getSimpleName() != "Tren"
								|| (ultimoTransporte.getClass().getSimpleName() == "Tren" && ((Tren) (ultimoTransporte))
										.getLinea() != ((Tren) v.getTransporte()).getLinea())) {
							descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
							if (it.hasNext()) {
								descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
							}
						}
					}
				}
			}
		}
		else { //Si la lista era null no aplica descuento porque es mayor a 2 hs o mayor a 6 viajes
			//o no existia ningun viaje anterior, tengo que indicar que la red debe reiniciarse para setear el viaje en la sube
			REINICIAR_RED_SUBE = true;
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
		List<Viaje> viajesRedSube = this.traerViajesRedSube(sube);
		// List<Viaje> ultimosNviajes = this.traerUltimosNViajes(sube);
		if (viajesRedSube != null) { // -> evaluar transporte,
			// hace falta evaluar horas x esta dentro de las dos horas cuando traigo la
			// lista
			Iterator<Viaje> it = viajesRedSube.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next(); // obtengo el primer valor que por orden es el ultimo viaje
				Transporte ultimoTransporte = transporteABM.traer(ultimoViaje.getTransporte().getIdTransporte());

				if (ultimoTransporte == null) {
					throw new Exception("ERROR: NO EXISTE TRANSPORTE");
				}
				// Solo aplica descuentos si el anterior no era un subte
				if (!(ultimoTransporte.getClass().getSimpleName().equals("Subte"))) {
					descuentoRedSube = dG.getPorcentajeDescuentoEtapa1();
					// si la cola de red sube tiene otro viaje aplico segundo descuento
					if (it.hasNext()) {
						descuentoRedSube = dG.getPorcentajeDescuentoEtapa2();
					}
				} else { // SI ERA SUBTE EL ANTERIOR SE ROMPE LA RED SUBE
					REINICIAR_RED_SUBE = true;
				}
			}
		}
		else { //Si la lista era null no aplica descuento porque es mayor a 2 hs o mayor a 6 viajes
			//o no existia ningun viaje anterior, tengo que indicar que la red debe reiniciarse para setear el viaje en la sube
			REINICIAR_RED_SUBE = true;
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
