package dao;

import modelo.MateriaPrimaModelo;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MateriaPrimaDAO {

    public void guardar(MateriaPrimaModelo materia) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(materia);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<MateriaPrimaModelo> listarTodo() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM MateriaPrimaModelo", MateriaPrimaModelo.class).list();
        }
    }
}
