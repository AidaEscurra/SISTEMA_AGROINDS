package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;


public class GenericDao<T> {
	protected Class <T> clase;

	public GenericDao(Class<T> clase) {
		super();
		this.clase = clase;
	}
	
	//usa el contexto para abrir la session
	protected Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
		}
	//metodo guardar que inserta en la base de datos
	
	public void guardar(T entity) {
		Transaction tx = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        tx = session.beginTransaction();
	        session.saveOrUpdate(entity); // saveOrUpdate
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	//metodo elimina los datos en la base de datos
	
	public void eliminar(T entity) throws Exception{
		try(Session session = getSession()){
			Transaction transaction = session.beginTransaction();
			try {
				session.remove(session.contains(entity) ? entity : session.merge(entity));
				transaction.commit();
			} catch (Exception e) {
				if(transaction != null) transaction.rollback();
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public T recuperarPorId(Integer id) {
		try(Session session = getSession()){
			return session.find(clase, id);
		}
	}
	
	public List<T> recuperarTodo(){
		try(Session session = getSession()){
			String hql = "FROM "+clase.getName()+" e ORDER BY id";
			Query<T> query = session.createQuery(hql, clase);
			return query.getResultList();
		}
	}
	
	
		
	
	
	
	

}
