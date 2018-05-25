package datos;

public class DatosFuncionales {
	private static DatosFuncionales instanciaDatosGenerales;

	private int idDatosFuncionales;
	private double precioMinimoColectivo;
	private double precioMinimoTren;
	private double precioMinimoSubte;
	private double precioMaximoColectivo;
	private double precioMaximoTren;
	private double precioTramo1Colectivo;
	private double precioTramo2Colectivo;
	private double precioTramo3Colectivo;
	private double precioTramo4Colectivo;
	private double precioTramo5Colectivo;
	private double saldoMaximo;
	private double saldoMaximoNegativo; 
	private double tiempoRedSube;
	private double precioEstudiantilColectivo;
	private double precioEstudiantilSubte;
	private double precioAsignacionColectivo;
	private double precioAsignacionTren;
	private double precioAsignacionSubte;
	private double precioEstudiantilTren;
	private double porcentajeDescuentoEtapa1;
	private double porcentajeDescuentoEtapa2;
		
	protected DatosFuncionales(){
		this.inicializar();
	}

	public static DatosFuncionales getInstanciaDatosGenerales(){
		if (instanciaDatosGenerales == null) {
			instanciaDatosGenerales =	new DatosFuncionales();
		}
			return instanciaDatosGenerales;
	}
		
	public double traerTarifaTren(String estacionOrigen, String estacionDestino) {
		return 4;
	}
			
	private void inicializar(){ //pueden leer la instancia de un archivo xml
		//this​.setNombre("Soft Argentina");
		//this​.setEmail("softargentina@unla.edu.ar");
	}

	public double determinarPrecioTramo(int tramo) {
		if (tramo == 1 )
			return this.precioTramo1Colectivo;
		if (tramo == 2 )
			return this.precioTramo2Colectivo;
		if (tramo == 3 )
			return this.precioTramo3Colectivo;
		if (tramo == 4 )
			return this.precioTramo4Colectivo;
		if (tramo == 5 )
			return this.precioTramo5Colectivo;
			
		return 0;
	}

	public double getPrecioMinimoColectivo() {
		return precioMinimoColectivo;
	}

	public void setPrecioMinimoColectivo(double precioMinimoColectivo) {
		this.precioMinimoColectivo = precioMinimoColectivo;
	}

	public double getPrecioMinimoTren() {
		return precioMinimoTren;
	}

	public void setPrecioMinimoTren(double precioMinimoTren) {
		this.precioMinimoTren = precioMinimoTren;
	}

	public double getPrecioMinimoSubte() {
		return precioMinimoSubte;
	}

	public void setPrecioMinimoSubte(double precioMinimoSubte) {
		this.precioMinimoSubte = precioMinimoSubte;
	}

	public double getPrecioMaximoColectivo() {
		return precioMaximoColectivo;
	}

	public void setPrecioMaximoColectivo(double precioMaximoColectivo) {
		this.precioMaximoColectivo = precioMaximoColectivo;
	}

	public double getPrecioMaximoTren() {
		return precioMaximoTren;
	}

	public void setPrecioMaximoTren(double precioMaximoTren) {
		this.precioMaximoTren = precioMaximoTren;
	}

	public double getPrecioTramo1Colectivo() {
		return precioTramo1Colectivo;
	}

	public void setPrecioTramo1Colectivo(double precioTramo1Colectivo) {
		this.precioTramo1Colectivo = precioTramo1Colectivo;
	}

	public double getPrecioTramo2Colectivo() {
		return precioTramo2Colectivo;
	}

	public void setPrecioTramo2Colectivo(double precioTramo2Colectivo) {
		this.precioTramo2Colectivo = precioTramo2Colectivo;
	}

	public double getPrecioTramo3Colectivo() {
		return precioTramo3Colectivo;
	}

	public void setPrecioTramo3Colectivo(double precioTramo3Colectivo) {
		this.precioTramo3Colectivo = precioTramo3Colectivo;
	}

	public double getPrecioTramo4Colectivo() {
		return precioTramo4Colectivo;
	}

	public void setPrecioTramo4Colectivo(double precioTramo4Colectivo) {
		this.precioTramo4Colectivo = precioTramo4Colectivo;
	}

	public double getPrecioTramo5Colectivo() {
		return precioTramo5Colectivo;
	}

	public void setPrecioTramo5Colectivo(double precioTramo5Colectivo) {
		this.precioTramo5Colectivo = precioTramo5Colectivo;
	}

	public double getSaldoMaximo() {
		return saldoMaximo;
	}

	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}

	public double getSaldoMaximoNegativo() {
		return saldoMaximoNegativo;
	}

	public void setSaldoMaximoNegativo(double saldoMaximoNegativo) {
		this.saldoMaximoNegativo = saldoMaximoNegativo;
	}

	public double getTiempoRedSube() {
		return tiempoRedSube;
	}

	public void setTiempoRedSube(double tiempoRedSube) {
		this.tiempoRedSube = tiempoRedSube;
	}

	public double getPrecioEstudiantilColectivo() {
		return precioEstudiantilColectivo;
	}

	public void setPrecioEstudiantilColectivo(double precioEstudiantilColectivo) {
		this.precioEstudiantilColectivo = precioEstudiantilColectivo;
	}

	public double getPrecioEstudiantilSubte() {
		return precioEstudiantilSubte;
	}

	public void setPrecioEstudiantilSubte(double precioEstudiantilSubte) {
		this.precioEstudiantilSubte = precioEstudiantilSubte;
	}

	public double getPrecioAsignacionColectivo() {
		return precioAsignacionColectivo;
	}

	public void setPrecioAsignacionColectivo(double precioAsignacionColectivo) {
		this.precioAsignacionColectivo = precioAsignacionColectivo;
	}

	public double getPrecioEstudiantilTren() {
		return precioEstudiantilTren;
	}

	public void setPrecioEstudiantilTren(double precioEstudiantilTren) {
		this.precioEstudiantilTren = precioEstudiantilTren;
	}

	public double getPorcentajeDescuentoEtapa1() {
		return porcentajeDescuentoEtapa1;
	}

	public void setPorcentajeDescuentoEtapa1(double porcentajeDescuentoEtapa1) {
		this.porcentajeDescuentoEtapa1 = porcentajeDescuentoEtapa1;
	}

	public double getPorcentajeDescuentoEtapa2() {
		return porcentajeDescuentoEtapa2;
	}

	public void setPorcentajeDescuentoEtapa2(double porcentajeDescuentoEtapa2) {
		this.porcentajeDescuentoEtapa2 = porcentajeDescuentoEtapa2;
	}

	public static void setInstanciaDatosGenerales(DatosFuncionales instanciaDatosGenerales) {
		DatosFuncionales.instanciaDatosGenerales = instanciaDatosGenerales;
	}

	@Override
	public String toString() {
		return "PrecioMinimoColectivo" + precioMinimoColectivo + "precioMinimoTren" + precioMinimoTren +
				"precioMinimoSubte" + precioMinimoSubte + "precioMaximoColectivo " + precioMaximoColectivo +
				"precioMaximoTren" + precioMaximoTren + "precioTramo1Colectivo" + precioTramo1Colectivo  +
				"precioTramo2Colectivo" + precioTramo2Colectivo + "precioTramo3Colectivo" + precioTramo3Colectivo + 
				"precioTramo4Colectivo" + precioTramo4Colectivo + "precioTramo5Colectivo" + precioTramo5Colectivo +
				"saldoMaximo" + saldoMaximo + "saldoMaximoNegativo" + saldoMaximoNegativo + "tiempoRedSube" +
				tiempoRedSube + "precioEstudiantilColectivo" + precioEstudiantilColectivo + "precioEstudiantilSubte" +
				"precioAsignacionColectivo" + precioAsignacionColectivo + "precioEstudiantilTren" + precioEstudiantilTren +
				"porcentajeDescuentoEtapa1" + porcentajeDescuentoEtapa1 + "porcentajeDescuentoEtapa2" + porcentajeDescuentoEtapa2;

	}

	public int getIdDatosFuncionales() {
		return idDatosFuncionales;
	}

	protected void setIdDatosFuncionales(int idDatosFuncionales) {
		this.idDatosFuncionales = idDatosFuncionales;
	}

	public double getPrecioAsignacionTren() {
		return precioAsignacionTren;
	}

	public void setPrecioAsignacionTren(double precioAsignacionTren) {
		this.precioAsignacionTren = precioAsignacionTren;
	}

	public double getPrecioAsignacionSubte() {
		return precioAsignacionSubte;
	}

	public void setPrecioAsignacionSubte(double precioAsignacionSubte) {
		this.precioAsignacionSubte = precioAsignacionSubte;
	}

}
