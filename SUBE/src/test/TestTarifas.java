package test;
import dao.*;
import negocio.SeccionABM;
public class TestTarifas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeccionABM seccionABM = new SeccionABM();
		EstacionDao estacionDao = new EstacionDao();
		
		System.out.println(seccionABM.traerSeccion(estacionDao.traerEstacion("Constitucion"),
				estacionDao.traerEstacion("Llavallol")));
		}

}
