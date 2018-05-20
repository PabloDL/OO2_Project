package test;

import datos.Transporte;
import negocio.TransporteABM;

public class TestTransporte {
	public static void main(String[] args) {
		int idTransporte = 1;
		System.out.println("+ traer(" + idTransporte + ")");
		System.out.println(TransporteABM.getInstance().traer(idTransporte));
		idTransporte = 2;
		System.out.println("\n+ traer(" + idTransporte + ")");
		System.out.println(TransporteABM.getInstance().traer(idTransporte));
		System.out.println("\n+ traer()");
		for (Transporte c : TransporteABM.getInstance().traer()) {
			System.out.println(c);
		}
	}
}