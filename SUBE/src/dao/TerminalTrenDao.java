package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.TerminalTren;

public class TerminalTrenDao {	
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
	public int agregar(TerminalTren objeto) {
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
	
	public void actualizar(TerminalTren objeto) throws HibernateException {
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
	
	public void eliminar(TerminalTren objeto) throws HibernateException {
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
	public TerminalTren traerTerminalTren(long idTerminalTren) throws HibernateException {
		TerminalTren objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TerminalTren) session .get(TerminalTren.class, idTerminalTren);
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session .close();
		}
		return objeto;
	}
}
