package negocio;

import org.hibernate.HibernateException;

import dao.EstacionDao;
import datos.Estacion;

public class EstacionABM {

	EstacionDao estacionDao = new EstacionDao();
	
	public int agregar(Estacion objeto) {

		return estacionDao.agregar(objeto);
	}
	
	public Estacion traerEstacion(String nombre) throws HibernateException{
		Estacion objeto = estacionDao.traerEstacion(nombre);
		
		return objeto;		
	}
	
}
