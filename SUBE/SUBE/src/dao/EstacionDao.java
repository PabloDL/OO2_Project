package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Estacion;
import datos.Seccion;

public class EstacionDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {

		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}

	public int agregar(Estacion objeto) {

		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public Estacion traerEstacion(String nombre) throws HibernateException{
		Estacion objeto = null;
		try{			
			iniciaOperacion();
			String hql = "from Estacion e where e.nombre= :nombre";
			objeto = (Estacion) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
			
		}finally{			
			session.close();			
		}
		return objeto;		
	}
}
