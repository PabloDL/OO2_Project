package test;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import datos.*;
public class TestTarifas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeccionDao seccionDao = new SeccionDao();
		EstacionDao estacionDao = new EstacionDao();	
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Llavallol"), estacionDao.traerEstacion("Constitucion")));
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Llavallol"), estacionDao.traerEstacion("Lanus")));
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Llavallol"), estacionDao.traerEstacion("Temperley")));
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Lanus"), estacionDao.traerEstacion("Constitucion")));
		
		System.out.println(seccionDao.traerSeccionEntreEstaciones(estacionDao.traerEstacion("Temperley"), estacionDao.traerEstacion("Constitucion")));
		}

}
