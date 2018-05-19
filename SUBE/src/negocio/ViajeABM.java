package negocio;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import dao.SubeDao;
import dao.ViajeDao;
import datos.Colectivo;
import datos.DatosGenerales;
import datos.Sube;
import datos.Transporte;
import datos.Tren;
import datos.Viaje;

public class ViajeABM {
	ViajeDao dao = new ViajeDao();

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

		// * en este caso es f�sica en gral. no se se aplicar�a este caso de uso, si se
		// hiciera habr�a que validar que el cliente no tenga dependencias
		//
		Viaje c = dao.traerViaje(idViaje);
		if (c == null) {
			throw new Exception("ERROR: NO EXITE TERMINAL SUBTE");
		}
		dao.eliminar(c);
	}

	// ACA VAN METODOS
	public void agregarViaje(Viaje v) throws Exception {
		//// EN TEORIA LO UNICO Q TENGO Q HACER ES ACTUALIZAR EL SALDO; EL VIAJE YA LO
		//// GUARDE
		// Viaje s = dao.traerViaje(v.getIdViaje());
		// s.inicializarListaViajes(); //ESTO HAY Q BORRARLO CUANDO SE LEVANTE DE LA
		//// BASE LA LISTA
		SubeABM subeABM = new SubeABM();
		Sube s = subeABM.traerSube(v.getSube().getIdSube());
		double precioBoleto = this.calcularPrecio(v); // si el precio es (-) quiere decir que es ua salida de tren

		if (!(subeABM.verificarSaldoSuficiente(v.getSube().getIdSube(), precioBoleto))) {
			throw new Exception("ERROR: SALDO INSUFIECIENTE");
		}

		if (precioBoleto < 0) { // Si el precio es (-) era un tren tengo que pisar el ultimo valor
			List<Viaje> ultimosNviajes = this.traerUltimosNViajes(v.getSube());
			Iterator<Viaje> it = ultimosNviajes.iterator();
			if (it.hasNext()) {
				Viaje ultimoViaje = it.next();
				ultimoViaje.agregarDestinoAViaje(v);
				s.setSaldo(s.getSaldo() + ultimoViaje.getTarifa() - v.getTarifa());
				dao.actualizar(ultimoViaje);
			}
		} else {
			s.setSaldo(s.getSaldo() - v.getTarifa());
			dao.agregar(v);
		}

		SubeDao subeDao = new SubeDao();
		subeDao.actualizar(s);

		System.out.println(s.toString());

	}

	private List<Viaje> traerUltimosNViajes(Sube sube) {
		return dao.traerViajes(sube);
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
		DatosGenerales dG = DatosGenerales.getInstanciaDatosGenerales();
		
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
			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
			if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) || 
					((ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) && 
							((Colectivo)ultimoViaje.getTransporte()).getLinea() != ((Colectivo)v.getTransporte()).getLinea() ||
								((Colectivo)ultimoViaje.getTransporte()).getRamal() != ((Colectivo)v.getTransporte()).getRamal()) ){
				
				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
					descuentoRedSube = 0.50;
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2);
						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
							descuentoRedSube = 0.75;
						}
					}
				}
			}

		}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = dG.getTarifaEstudiantilSubte();
		}
		return (tarifa - (tarifa * descuentoRedSube));
	}

	private double calcularPrecioTren(Viaje v) throws Exception {
		double descuentoRedSube = 0;
		double tarifa = v.getTarifa();
		SubeABM subeABM = new SubeABM();
		DatosGenerales dG = DatosGenerales.getInstanciaDatosGenerales();
		
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
			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
			if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Tren")) || 
					((ultimoViaje.getTransporte().getClass().getSimpleName().equals("Tren")) && 
							((Tren)ultimoViaje.getTransporte()).getLinea() != ((Tren)v.getTransporte()).getLinea() 
							|| ((Tren)ultimoViaje.getTransporte()).getEstacionDestino() != "")){ // VEO Q NO SEA UNA NUEVA ENTRADA
				
				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
					descuentoRedSube = 0.50;
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2);
						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
							descuentoRedSube = 0.75;
						}
					}
				}
			}
			else { //SI ES UN TREN Y LA MISMA LINEA, entonces es una salida
				tarifa = dG.traerTarifaTren(((Tren)(ultimoViaje.getTransporte())).getEstacionOrigen(), ((Tren)(v.getTransporte())).getEstacionOrigen());
				//tarifa = (((Tren)(ultimoViaje.getTransporte())).getMontoEntreEstaciones(this.estacion);
// SI ES SALIDA NO TENGO Q SUMAR AL BOLETO,SINO RESTAR LO Q CORRESPONDA, QUEDA NGATIVO
//POR EJEMPLO, SI EL BOLETO MAXIMO SALIO 6 Y EN REALIDAD EN LA SALIDA DEBERIA HABER SIDO $3, LO Q HAGO ES RESTAR, EL TEMA ES SI APLICARON DESCUENTOS...
				tarifa = -tarifa; //- datosGenerales.getMontoTren3(); // getMontoTren3() --> iria tarifa maxima tren 
//TENGO QUE RECALCULAR A PARTIR DE LOS ULTIMOS 3 VIAJES, EN LUGAR D LOS ULTIMOS 2, TENGO Q AGARRAR Y VER PARA EL PRIMER VIAJE DE TREN QUE DESCUENTOS
				if (it.hasNext()) { //POR LO MENOS TIENE Q TENER UN VIAJE ANTES DEL TREN(EL TREN seria en posicion 1, en 0 otro)
					ultimoViaje = it.next();
					tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
					tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL

					if (ultimoViaje.getTransporte().getClass().getSimpleName() != "Tren" || 
							(ultimoViaje.getTransporte().getClass().getSimpleName() == "Tren" && 
								((Tren)(ultimoViaje.getTransporte())).getLinea() != ((Tren)v.getTransporte()).getLinea() )) {// SI ES DISTINTO DE TREN, CALCULO LOS DESCUENTOS, SI ES TREN VEO SI ES SALIDA
																							// OJOOO TENGO Q EVALUAR SI ES OTRA LINEA DE TREN
						if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
							descuentoRedSube = 0.50;
							// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
							if (it.hasNext()) {
								Viaje anteUltimoViaje = it.next();
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
			}
		}
		if (sube.getPersona().isEsTarifaSocial() == true) {
				tarifa = tarifa - (tarifa * dG.getTarifaEstudiantilSubte());
		}
				
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = tarifa - (tarifa *dG.getTarifaEstudiantilSubte());
		}
		return (tarifa - (tarifa * descuentoRedSube));
		
	}

	private double calcularPrecioSubte(Viaje v) throws Exception {
		double descuentoRedSube = 0;
		DatosGenerales datosGenerales = DatosGenerales.getInstanciaDatosGenerales();
		double tarifa = v.getTarifa();
		SubeABM subeABM = new SubeABM();
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
			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL
			if (!(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Subte"))) {// EN este caso si es
																							// otrosubte no aplica dt
				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {
					descuentoRedSube = 0.50;
					// VEO SI ENTRe EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (it.hasNext()) {
						Viaje anteUltimoViaje = it.next();
						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio();
						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2);
						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {
							descuentoRedSube = 0.75;
						}
					}
				}
			}

		}
		if (sube.getPersona().isEsTarifaEstudiantil() == true) {
			tarifa = tarifa - (tarifa * datosGenerales.getTarifaEstudiantilSubte());
		}
		return (tarifa - (tarifa * descuentoRedSube));
	}

}
