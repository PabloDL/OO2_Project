package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;
import datos.Sube;

public class SubeDao {
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
	
	public Sube traerSube(long idSube) throws HibernateException {
		Sube objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Sube) session .get(Sube.class, idSube);
		} 
		catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session .close();
		}
		return objeto;
	}

	@SuppressWarnings("unused")
	public Sube traerSube(int numeroSube) {
		Sube objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Sube) session .createQuery( "from Sube s where s.numero=" +numeroSube).uniqueResult();
		} 
		catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session .close();
		}
		return objeto;
	}
	

	
	public void actualizar(Sube objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .update(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
	}

	public int agregar(Sube objeto) {
			int id = 0;
			try {
				iniciaOperacion();
				id = Integer. parseInt ( session .save(objeto).toString());
				tx .commit();
			} catch (HibernateException he) {
				manejaExcepcion(he);
				throw he;
			} finally {
				session .close();
		}
			return id;
		
	}

	public void eliminar(Sube c) {
		// TODO Auto-generated method stub
		
	}
}

