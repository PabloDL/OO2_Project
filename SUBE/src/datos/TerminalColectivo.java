package datos;

import java.util.ArrayList;

public class TerminalColectivo extends Terminal {
	private long idTerminalColectivo;
	private String linea;
	private String ramal;
	private int numero;
		
	public TerminalColectivo() {}

	public TerminalColectivo(String linea, String ramal, int numero) {
		super();
		this.linea = linea;
		this.ramal = ramal;
		this.numero = numero;
		this.viajes = new ArrayList<Viaje>();		
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

	public Viaje cobrar(Sube sube, int tramoAcobrar) {
		// FALTA LEVANTAR DE APPTABLE En este caso el monto es fijo, lo levanto de la
		// tabla de parametros
		// Convierto el tramo que indica el colectivero o el molinete en un valor en
		// pesos
		// DE LA SUBE SACO EL ULTIMO VIAJE Y VEO SI TRANSCURRE EN LAS PRIMERAS DOS
		// HORAS-> EL METODO
		// DEVUELVE EL DESCUENTO QUE TENGO QUE HACER EN EL PRECIO, ACA ANALIZA SI ES
		// BOLETO ESTUDIANTIL, SI TARIFA SOCIAL
		double precioBoleto = this.calcularPrecio(sube, tramoAcobrar);
		Colectivo colectivo;
		Viaje nuevoViaje;
		// creo un viaje y cargo los datos necesarios,
		if(this.verificarSaldoSuficiente(sube, precioBoleto)) {
			colectivo = new Colectivo(this.linea, this.numero, this.ramal);
			nuevoViaje = new Viaje(precioBoleto, colectivo, sube); // GUARDO TARIFA VIAJE O MONTO REAL PAGADO?
		// YA ESTA CALCULADO float monto = nuevoViaje.calcularMonto(descuentoAAplicar);
		// //CALCULA A PARTIR DEL TRANSPORTE EL MONTO -> si fuera otro transporte en el
		// contructor detallo el tramo o estacion
		// UNA VEZ CREADO EL VIAJE LO AGREGO A LOS VIAJES PARA LUEGO PERSISTIRLO LLAMANDO A INFORMAR VIAJES
			this.viajes.add(nuevoViaje);
		}
		else {
			nuevoViaje = null;
		}			
		
		return nuevoViaje; // TENGO Q DEVOLVER EL VIAJE PARA Q LA SUBE PUEDE ACTUALIZAR EL SALDO Y LA LISTA
						// DE VIAJES //AGREGO EL VIAJE A LA LISTA DE SUBE

	}

	public float calcularDescuento(Sube sube) {
		return 0;
	}

	public double determinarPrecioTramo(int tramoACobrar) {
		double precioTramo = 0;
		DatosFuncionales df = DatosFuncionales.getInstanciaDatosGenerales();
		if (tramoACobrar==1) {
			precioTramo = df.getPrecioTramo1Colectivo();
		}
		else if (tramoACobrar==2) {
			precioTramo = df.getPrecioTramo2Colectivo();
		}
		else if (tramoACobrar==3) {
			precioTramo = df.getPrecioTramo3Colectivo();
		}
		else if (tramoACobrar==4) {
			precioTramo = df.getPrecioTramo4Colectivo();
		}
		else if (tramoACobrar==5) {
			precioTramo = df.getPrecioTramo5Colectivo();
		}
		
		return precioTramo;
	}

	public double calcularPrecio(Sube sube, int tramoACobrar) {
		double descuentoRedSube = 0;
		DatosFuncionales datosGenerales = new DatosFuncionales();
		
		double tarifa = this.determinarPrecioTramo(tramoACobrar);
		//POR ACA
		/*
		if (sube.getUltimosViajes().size() > 0) {
			Viaje ultimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 1);
			LocalDateTime tiempoInicial = ultimoViaje.getFechaHoraInicio(); // RECUPERA HORA INICIO VIAJE
			LocalDateTime tiempoFinal = tiempoInicial.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL

			if ( !(ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo"))  ||
					((ultimoViaje.getTransporte().getClass().getSimpleName().equals("Colectivo")) && 
					((Colectivo)ultimoViaje.getTransporte()).getLinea() != this.linea ||
						((Colectivo)ultimoViaje.getTransporte()).getRamal() != this.ramal) ){// EN este caso si es otro subte no
																					// aplica dt
				if (tiempoFinal.compareTo(LocalDateTime.now()) >= 0) {  //SI EL TIEMPO DEL ULTIMO VIAJE + 2HS ES MAYOR A NOW -> NO USO REDSUBE
					descuentoRedSube = 0.50;
					// VEO SI ENTRE EL ULTIMO Y EL ANTERIOR HAY MENOS DE 2 HS
					if (sube.getUltimosViajes().size() > 1) {
						Viaje anteUltimoViaje = sube.getUltimosViajes().get(sube.getUltimosViajes().size() - 2);
						LocalDateTime tiempoAnteUltimo = anteUltimoViaje.getFechaHoraInicio(); // SE SUPONE Q SUMA DOS HORAS
																								// A TIEMPO INICIAL
						LocalDateTime tiempoFinalAnteUltimoViaje = tiempoAnteUltimo.plusHours(2); // SE SUPONE Q SUMA DOS HORAS A TIEMPO INICIAL 
	
						if (tiempoFinalAnteUltimoViaje.compareTo(tiempoInicial) >= 0) {  //TiempoInicial es cuando se tomo el ultimo viaje
							descuentoRedSube = 0.75;
						}
					}
				}
			}
		}
		
		if (sube.getPersona().isEsTarifaSocial() == true) {
			tarifa = tarifa - (tarifa * datosGenerales.getTarifaSocialColectivo());
		}
		else if (sube.getPersona().isEsTarifaEstudiantil() == true) { //SI APLICA TARIFA SOCIAL NO APLICA TARIFA ESTUDIANTIL
			tarifa = tarifa - (tarifa * datosGenerales.getTarifaEstudiantilColectivo());
		}
			*/		
		return (tarifa - (tarifa * descuentoRedSube));

	}

	@Override
	public boolean verificarSaldoSuficiente(Sube sube, double precioBoleto) {
		DatosFuncionales datosGenerales = DatosFuncionales.getInstanciaDatosGenerales();
		if (sube.getSaldo() - precioBoleto > datosGenerales.getSaldoMaximoNegativo())
			return true;

		return false;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	protected long getIdTerminalColectivo() {
		return idTerminalColectivo;
	}

	protected void setIdTerminalColectivo(long idTerminalColectivo) {
		this.idTerminalColectivo = idTerminalColectivo;
	}

}
