package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;
import datos.Sube;
import datos.TerminalSubte;
import datos.Viaje;

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
		} finally {
			session .close();
		}
		return objeto;
	}

	@SuppressWarnings("unused")
	public Sube traerSube(int numeroSube) {
		Persona p1 = new Persona("Perez","juan",33412412, false, false);
		//implementar
		Sube s = new Sube(1, 1234, p1,  50);
		return s;
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

