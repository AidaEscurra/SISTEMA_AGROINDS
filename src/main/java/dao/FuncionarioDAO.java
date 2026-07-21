package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.FuncionarioModelo;
import util.HibernateUtil;

public class FuncionarioDAO extends GenericDao<FuncionarioModelo> {

    public FuncionarioDAO() {
        super(FuncionarioModelo.class);
    }

    // Búsqueda por filtro integrando la relación de Persona
    public List<FuncionarioModelo> buscarPorFiltro(String filtro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<FuncionarioModelo> lista = new ArrayList<>();
        try {
            String hql = "SELECT f FROM FuncionarioModelo f JOIN FETCH f.persona p " +
                         "WHERE LOWER(p.nombre) LIKE :filtro OR LOWER(p.apellido) LIKE :filtro " +
                         "OR p.documento LIKE :filtro OR LOWER(f.cargo) LIKE :filtro";
            Query<FuncionarioModelo> query = session.createQuery(hql, FuncionarioModelo.class);
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