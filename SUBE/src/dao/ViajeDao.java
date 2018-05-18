package dao;


import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;


import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;
import negocio.Viaje;
import funciones.Funciones;

public class ViajeDao {
	//tuve que crear un dao porque se usa para poder traer las tablas de viaje para el composite
	
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
	
	public List<Viaje> traerViajeXfecha() throws HibernateException {
		ArrayList<Viaje> lista = null ;
		try {
			iniciaOperacion();
			lista= (ArrayList<Viaje>) session .createQuery( "from Viaje v order by v.fechaYHora asc " ).list();
		}
		catch(HibernateException he){
			manejaExcepcion(he);
			throw (he);			
		}	
		finally {
			session .close();
		}
		return lista;
	}
	
}
