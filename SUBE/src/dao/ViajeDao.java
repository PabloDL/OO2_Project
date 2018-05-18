package dao;


import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Viaje;

public class ViajeDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos");
	}
		
	public List<Viaje> traerReporte(String hql) throws HibernateException{
		ArrayList<Viaje> resultadoReporte = null;
		try {
			iniciaOperacion();
			resultadoReporte = (ArrayList) session.createQuery(hql).list();			
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw (he);
		}
		finally {
			session.close();
		}
		return resultadoReporte;		
	}
}
