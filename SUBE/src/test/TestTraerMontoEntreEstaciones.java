package test;

import negocio.SeccionABM;

public class TestTraerMontoEntreEstaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SeccionABM sec = new SeccionABM();
//		SeccionDao secDao = new SeccionDao();
//		EstacionDao estDao = new EstacionDao();
		double precio=0;
		
//		precio = sec.getMontoEntreEstaciones("Lanus", "Llavallol");
		//precio = sec.getMontoEntreEstaciones("Constitucion", "Lanus");
		
		precio = sec.getMontoEntreEstaciones("Temperley", "Llavallol");
//		precio = sec.getMontoEntreEstaciones("Lavallol", "Temperley");
		
//		precio = secDao.traerPrecioEntreEstaciones(estDao.traerEstacion("Lavallol"), estDao.traerEstacion("Temperley")).getPrecio();
		
//		System.out.println(secDao.traerPrecioEntreEstaciones(estDao.traerEstacion("Lavallol"), estDao.traerEstacion("Temperley")));
		
		System.out.println(precio);
		
//		System.out.println(secDao.traerPrecioEntreEstaciones(estDao.traerEstacion("Lavallol"), estDao.traerEstacion("Temperley")));
		
	}

}
