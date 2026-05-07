package dao;

import modelo.FuncionarioModelo;
import com.sistemaind.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class FuncionarioDAO {

    public void guardar(FuncionarioModelo funcionario) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(funcionario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<FuncionarioModelo> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Hibernate traerá automáticamente los datos de la Persona asociada
            return session.createQuery("FROM FuncionarioModelo", FuncionarioModelo.class).list();
        }
    }
}