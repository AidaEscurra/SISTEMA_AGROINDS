package dao;

import modelo.PersonaModelo;
import com.sistemaind.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PersonaDAO {

    public void guardar(PersonaModelo persona) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<PersonaModelo> listarActivos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PersonaModelo WHERE estado = true", PersonaModelo.class).list();
        }
    }
}