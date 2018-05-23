package test;
import datos.*;
import dao.*;
public class TestTarifas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeccionDao seccionDao = new SeccionDao();
		EstacionDao estacionDao = new EstacionDao();
		
		System.out.println(seccionDao.traerPrecioEntreEstaciones(estacionDao.traerEstacion("Llavallol"), estacionDao.traerEstacion("Temperley")));
		}

}
