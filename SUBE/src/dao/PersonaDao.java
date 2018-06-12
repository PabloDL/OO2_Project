package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Persona;
import datos.Sube;

public class PersonaDao {
	
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
	
	public int agregar(Persona objeto) {
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
	
	public void actualizar(Persona objeto) throws HibernateException {
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
	
	public void eliminar(Persona objeto) throws HibernateException {
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
	
	public Persona traerPersona(long idPersona) throws HibernateException {
		Persona objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Persona) session .get(Persona.class, idPersona);
		} catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traerPersona( int dni) throws HibernateException {
		Persona objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Persona) session .createQuery( "from Persona c where c.dni=" +dni).uniqueResult();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Persona> traerPersona() throws HibernateException {
		List<Persona> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Persona p order by p.apellido asc p.nombre asc" ).list();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw (he);
		}finally {
			session .close();
		}
		return lista;
	}
	
	public Persona traerPersonaYUsuario( long idPersona) throws HibernateException {
		Persona objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Persona c where c.idCliente =" +idPersona;
			objeto=(Persona) session .createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getUsuario());
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session .close();
		}
		return objeto;
		}

	public Persona traerPersona(Sube sube) throws HibernateException{
		
		Persona persona=null;
		try {
			iniciaOperacion();
			String hql= "from Persona p inner join fetch p.sube s where s.idSube =" +sube.getIdSube();
			persona=(Persona) session .createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session .close();
		}
		return persona;	
		
	}
}
