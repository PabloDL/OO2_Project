package datos;

public class DatosGenerales {
	private static DatosGenerales instanciaDatosGenerales;

	private float montoSubte = 10;
	private float PrecioMaximoTren  = 5;
	private float montoColectivo1 = 10;
	private float montoColectivo2 = 20;
	private float montoColectivo3 = 30;
	private float montoColectivo4 = 40;
	private float montoColectivo5 = 50;
	// NO TIENE private float tarifaSocialSubte = 7.5;
	private double tarifaEstudiantilSubte = 7.5;
	private double tarifaEstudiantilTren ;//DEFINIR
	private double tarifaEstudiantilColectivo = 0.5;
	private double tarifaSocialColectivo = 0.55;
	private double tarifaSocialTren ;  //DEFINIR 
	public float SaldoMinimo = -20;
		
	protected DatosGenerales(){
		this.inicializar();
	}

	public static DatosGenerales getInstanciaDatosGenerales(){
		if (instanciaDatosGenerales == null) {
			instanciaDatosGenerales =	new DatosGenerales();
		}
			return instanciaDatosGenerales;
	}
		
	public double traerTarifaTren(String estacionOrigen, String estacionDestino) {
		return 4;
	}
	
	public float getMontoSubte() {
		return montoSubte;
	}
	public float getSaldoMinimo() {
		return SaldoMinimo;
	}
	public void setSaldoMinimo(float saldoMinimo) {
		SaldoMinimo = saldoMinimo;
	}
	public void setTarifaEstudiantilSubte(float tarifaEstudiantilSubte) {
		this.tarifaEstudiantilSubte = tarifaEstudiantilSubte;
	}
	public void setMontoSubte(float montoSubte) {
		this.montoSubte = montoSubte;
	}
	public float getMontoColectivo1() {
		return montoColectivo1;
	}
	public void setMontoColectivo1(float montoColectivo1) {
		this.montoColectivo1 = montoColectivo1;
	}
	public float getMontoColectivo2() {
		return montoColectivo2;
	}
	public void setMontoColectivo2(float montoColectivo2) {
		this.montoColectivo2 = montoColectivo2;
	}
	public float getMontoColectivo3() {
		return montoColectivo3;
	}
	public void setMontoColectivo3(float montoColectivo3) {
		this.montoColectivo3 = montoColectivo3;
	}
	public float getMontoColectivo4() {
		return montoColectivo4;
	}
	public void setMontoColectivo4(float montoColectivo4) {
		this.montoColectivo4 = montoColectivo4;
	}
	public float getMontoColectivo5() {
		return montoColectivo5;
	}
	public void setMontoColectivo5(float montoColectivo5) {
		this.montoColectivo5 = montoColectivo5;
	}
//	
//	public void getTarifaSocialSubte() {
//		// TODO subte no tiene tarifa social
//		
//	}
	public double getTarifaEstudiantilSubte() {
		return tarifaEstudiantilSubte;
		
	}
	public double getTarifaSocialColectivo() {
		return tarifaSocialColectivo;
	}
	public double getTarifaEstudiantilTren() {
		return tarifaEstudiantilTren;
	}
	public void setTarifaEstudiantilTren(float tarifaEstudiantilTren) {
		this.tarifaEstudiantilTren = tarifaEstudiantilTren;
	}
	public double getTarifaEstudiantilColectivo() {
		return tarifaEstudiantilColectivo;
	}
	public void setTarifaEstudiantilColectivo(float tarifaEstudiantilColectivo) {
		this.tarifaEstudiantilColectivo = tarifaEstudiantilColectivo;
	}
	public void setTarifaSocialColectivo(float tarifaSocialColectivo) {
		this.tarifaSocialColectivo = tarifaSocialColectivo;
	}
	public double getTarifaSocialTren() {
		return tarifaSocialTren;
	}
	public void setTarifaSocialTren(float tarifaSocialTren) {
		this.tarifaSocialTren = tarifaSocialTren;
	}
	
	private void inicializar(){ //pueden leer la instancia de un archivo xml
		//this​.setNombre("Soft Argentina");
		//this​.setEmail("softargentina@unla.edu.ar");
	}

	public float getPrecioMaximoTren() {
		return PrecioMaximoTren;
	}

	public void setPrecioMaximoTren(float precioMaximoTren) {
		PrecioMaximoTren = precioMaximoTren;
	}

	public double determinarPrecioTramo(int tramo) {
		if (tramo == 1 )
			return this.getMontoColectivo1();
		if (tramo == 2 )
			return this.getMontoColectivo1();
		if (tramo == 3 )
			return this.getMontoColectivo1();
		if (tramo == 4 )
			return this.getMontoColectivo1();
		if (tramo == 5 )
			return this.getMontoColectivo1();
			
		return 0;
	}

}
