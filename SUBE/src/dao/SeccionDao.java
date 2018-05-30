package dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estacion;
import datos.Seccion;

public class SeccionDao {

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

/*	public Seccion traerSeccionEntreEstaciones(Estacion e1, Estacion e2) throws HibernateException {
		Seccion seccion = null;
		try {
			iniciaOperacion();
			//String hql = "from Seccion s where estacionseccion.idEstacion1 =" + idEstacion1
					//+ " and estacionseccion.idEstacion2 =" + idEstacion2;
			String hql = "from Seccion s "
					+ "inner join fetch s.estaciones1 e1 "
					+ "inner join fetch s.estaciones2 e2 "
					+ "where (e1.idEstacion=" + e1.getIdEstacion()
					+ " and e2.idEstacion=" + e2.getIdEstacion() + ")";
			seccion = (Seccion)session.createQuery(hql).uniqueResult();

		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return seccion;
	}
	*/
	
	public Seccion traerSeccionEntreEstaciones(Estacion e1, Estacion e2) throws HibernateException {
		List<Seccion> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Seccion s " + "inner join fetch s.estaciones1 e1 "
					+ "inner join fetch s.estaciones2 e2 "
					+ "where e1.idEstacion=" + e1.getIdEstacion()
					+ " and e2.idEstacion=" + e2.getIdEstacion() + "order by s.precio desc").setMaxResults(1).list();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw (he);
		}finally {
			session .close();
		}
		return lista.get(0);
	}

}
