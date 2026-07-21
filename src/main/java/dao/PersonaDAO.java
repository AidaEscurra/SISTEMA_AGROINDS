package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.PersonaModelo;
import util.HibernateUtil;

public class PersonaDAO extends GenericDao<PersonaModelo> {

    public PersonaDAO() {
        super(PersonaModelo.class);
    }

    // Método obligatorio que llama PersonaController para la JTable y la búsqueda
    public List<PersonaModelo> buscarPorFiltro(String filtro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PersonaModelo> lista = new ArrayList<>();
        try {
            String hql = "FROM PersonaModelo p WHERE LOWER(p.nombre) LIKE :filtro " +
                         "OR LOWER(p.apellido) LIKE :filtro OR p.documento LIKE :filtro";
            Query<PersonaModelo> query = session.createQuery(hql, PersonaModelo.class);
            query.setParameter("filtro", "%" + filtro.toLowerCase().trim() + "%");
            lista = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); //Cierre seguro de sesión
        }
        return lista;
    }
}