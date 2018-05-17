package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.TerminalSubte;

public class TerminalSubteDao {	
	private static Session session ;
	
	private Transaction tx ;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	public int agregar(TerminalSubte objeto) {
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
	
	public void actualizar(TerminalSubte objeto) throws HibernateException {
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
	
	public void eliminar(TerminalSubte objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .delete(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
	}
	public TerminalSubte traerTerminalSubte(long idTerminalSubte) throws HibernateException {
		TerminalSubte objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TerminalSubte) session .get(TerminalSubte.class, idTerminalSubte);
		} finally {
			session .close();
		}
		return objeto;
	}
}
