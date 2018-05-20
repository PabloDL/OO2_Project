package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Transporte;

public class TransporteDao {
	private static Session session;
	private Transaction tx;
	private static TransporteDao instancia = null; // Patrón Singleton

	protected TransporteDao() {
	}

	public static TransporteDao getInstance() {
		if (instancia == null)
			instancia = new TransporteDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public Transporte traer(long idTransporte) {
		Transporte objeto = null;
		try {
			iniciaOperacion();
			objeto = (Transporte) session.createQuery("from Transporte c where c.idTransporte =" + idTransporte)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Transporte> traer() throws HibernateException {
		List<Transporte> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Transporte").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public int agregar(Transporte objeto) {
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

	public void eliminar(Transporte objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
}