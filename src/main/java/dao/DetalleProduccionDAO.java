package dao;

import modelo.DetalleProduccionModelo;
import com.sistemaind.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DetalleProduccionDAO {
    
    public List<DetalleProduccionModelo> buscarPorProduccion(Long idProduccion) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM DetalleProduccionModelo WHERE produccion.idProduccion = :id", 
                DetalleProduccionModelo.class)
                .setParameter("id", idProduccion)
                .list();
        }
    }
}