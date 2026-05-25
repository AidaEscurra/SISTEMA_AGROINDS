package dao;

import modelo.ProduccionModelo;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduccionDAO {

    public void guardar(ProduccionModelo produccion) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            
            // Gracias al CascadeType.ALL, esto guarda la cabecera Y los detalles
            session.persist(produccion); 
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}