package dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DatosFuncionales;
import datos.TerminalTren;

public class DatosFuncionalesDao {
	private static Session session;
	private Transaction tx;
	private static DatosFuncionalesDao instancia = null; // Patrón Singleton

	protected DatosFuncionalesDao() {
	}

	public static DatosFuncionalesDao getInstance() {
		if (instancia == null)
			instancia = new DatosFuncionalesDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("EROR en la capa de acceso a datos", he);
	}

	public DatosFuncionales traer() {
		DatosFuncionales objeto = null;
		try {
			iniciaOperacion();
			objeto = (DatosFuncionales)session.get(DatosFuncionales.class, 1);
		} finally {											
			session.close();
		}
		return objeto;
	}
}