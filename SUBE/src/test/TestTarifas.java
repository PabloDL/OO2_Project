package test;
import dao.*;
public class TestTarifas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeccionDao seccionDao = new SeccionDao();
		EstacionDao estacionDao = new EstacionDao();
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Llavallol"), estacionDao.traerEstacion("Constitucion")));
		}

}
