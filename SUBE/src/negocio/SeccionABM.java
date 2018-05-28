package negocio;

import org.hibernate.HibernateException;

import dao.EstacionDao;
import dao.SeccionDao;
import datos.Estacion;
import datos.Seccion;


public class SeccionABM {
	
	SeccionDao secDao = new SeccionDao();
	EstacionABM estABM = new EstacionABM();
	
	public Seccion traerSeccionEntreEstaciones(Estacion e1, Estacion e2) throws HibernateException {
		
		return secDao.traerSeccionEntreEstaciones(e1, e2);
	}
	
	
	public double getMontoEntreEstaciones(String e1, String e2)
	{		
		Estacion est1 = estABM.traerEstacion(e1);
		Estacion est2 = estABM.traerEstacion(e2);
		Seccion sec = null;
		
		if(est1.getIdEstacion() < est2.getIdEstacion())
			sec = secDao.traerSeccionEntreEstaciones(est1, est2);
		else
			sec = secDao.traerSeccionEntreEstaciones(est2, est1);
		
		return sec.getPrecio();	
	}
}
