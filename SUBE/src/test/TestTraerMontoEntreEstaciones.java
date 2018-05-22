package test;

import datos.Tren;

public class TestTraerMontoEntreEstaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tren tren = new Tren();
		
//		tren.setEstacionDestino("Temperley");
		tren.setEstacionOrigen("Lanus");
		tren.setEstacionDestino("Constitucion");
		
		System.out.println(tren.getMontoEntreEstaciones());
		
	}

}
