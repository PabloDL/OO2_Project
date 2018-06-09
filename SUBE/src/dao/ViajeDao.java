package dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Sube;
import datos.Viaje;

public class ViajeDao {	
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
	
	public int agregar(Viaje objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx .commit();
		} catch (HibernateException he) {
	
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
	}
		return id;
	}
	
	public void actualizar(Viaje objeto) throws HibernateException {
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
	
	public void eliminar(Viaje objeto) throws HibernateException {
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
	
	public Viaje traerViaje(long idViaje) throws HibernateException {
		Viaje objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Viaje) session .get(Viaje.class, idViaje);
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he; 
		}finally {
			session .close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Viaje> traerViajes(Sube sube) {
		List<Viaje> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Viaje v inner join fetch v.sube s order by idViaje desc where s.idSube=" + sube.getIdSube();
			lista = session.createQuery(hQL).list();

		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Viaje> traerNUltimosViajes(Sube sube) {
		List<Viaje> lista = null;
		GregorianCalendar diferenciaDosHoras = new GregorianCalendar();
		diferenciaDosHoras.add(GregorianCalendar.HOUR_OF_DAY, -2);  
		try {
			iniciaOperacion();
			//String hQL = "from Viaje v inner join fetch v.sube s order by idViaje desc where s.idSube=" + sube.getIdSube();
			String hQL = "from Viaje v inner join fetch v.sube s  where s.idSube=" + sube.getIdSube() 
								+ " order by v.idViaje desc";
			lista = session.createQuery(hQL).setFirstResult(0).setMaxResults(6).list();
			//AHORA TNDRIA Q PONER
			//String hQL = "from Viaje v inner join fetch v.sube s  where s.idSube=" + sube.getIdSube() 
			//+ "where s.primerViajeRedSube<="+ sube.primerViajeRedSube +
			 // "and v.fechaYHora<"+ diferenciaDosHoras +" order by v.idViaje desc";
			//lista = session.createQuery(hQL).setFirstResult(0).list();
			

		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Viaje> traerViajesRedSube(Sube sube) {
		List<Viaje> lista = null;
 
		try {
			iniciaOperacion();
//solo si la sube nunca se utilizo no tiene primerViaje
			if (sube.getPrimerViajeRedSube() != null) {
				//Traigo los ultimos a partir del primero de la red sube, que esta indicado en la sube
				String hQL = "from Viaje v inner join fetch v.sube s  where s.idSube=" + sube.getIdSube() 
						+ " and v.idViaje >= "+ sube.getPrimerViajeRedSube().getIdViaje() 
						+ " order by v.idViaje desc";
				lista = session.createQuery(hQL).setFirstResult(0).list();
			}
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return lista;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerReporte(String hql) throws HibernateException {
		ArrayList<Viaje> viajes = null ;
		try {
			iniciaOperacion();
			viajes = (ArrayList<Viaje>) session.createQuery(hql).list();
		} catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session .close();
		}
		return viajes;
	}
	
	public void test() throws HibernateException {
		try {
			iniciaOperacion();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

	public List<Viaje> traerViaje(Sube sube) {
		List<Viaje> lista = null;
		try {
			iniciaOperacion();
			//String hQL = "from Viaje v inner join fetch v.sube s order by idViaje desc where s.idSube=" + sube.getIdSube();
			String hQL = "from Viaje v inner join fetch v.sube s  where s.idSube=" + sube.getIdSube() 
								+ " order by v.idViaje desc";
			lista = session.createQuery(hQL).list();

		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return lista;	
	}
	
}
