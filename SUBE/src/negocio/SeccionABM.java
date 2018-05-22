package negocio;

import org.hibernate.HibernateException;

import dao.SeccionDao;
import datos.Estacion;
import datos.Seccion;


public class SeccionABM {

	SeccionDao seccionDao = new SeccionDao();
	
	public Seccion traerSeccion(Estacion e1, Estacion e2) throws HibernateException, NullPointerException
	{
		Seccion seccion = null;
				
		if(e2.getIdEstacion() > e1.getIdEstacion())
			seccion = seccionDao.traerSeccion(e1, e2);
		else 
			seccion = seccionDao.traerSeccion(e2, e1);
			
		
		
		return seccion;
	}
	
}
