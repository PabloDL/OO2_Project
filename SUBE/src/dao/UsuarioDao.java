package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Persona;
import datos.Usuario;

public class UsuarioDao {
	private static Session session ;
	private Transaction tx ;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public Usuario traerUsuario( long idUsuario) throws HibernateException {
			Usuario obj = null ;
		try {
			iniciaOperacion();
			String hQL= "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" +idUsuario;
			obj = (Usuario) session .createQuery(hQL).uniqueResult();
		} finally {
			session .close();
		}
		return obj;
		}
	
	@SuppressWarnings ( "unchecked" )
	public List<Usuario> traerUsuario(Persona c) throws HibernateException {
		List<Usuario> lista= null ;
		try {
			iniciaOperacion();
			String hQL= "from Usuario p inner join fetch p.persona c where c.idPersona=" +c.getIdPersona();
			lista = session .createQuery(hQL).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
