package util;


public class PruebaConexion {
    public static void main(String[] args) {
        try {
            // 1. Intentamos obtener la Factoría de Sesiones
            System.out.println("Iniciando conexión con PostgreSQL...");
            HibernateUtil.getSessionFactory();
            
            System.out.println("-------------------------------------------");
            System.out.println("¡CONEXIÓN EXITOSA!");
            System.out.println("Hibernate ha leído el archivo cfg.xml correctamente.");
            System.out.println("-------------------------------------------");
            
            // 2. Verificación en pgAdmin
            System.out.println("Revisa tu pgAdmin: Las tablas deben haberse creado o actualizado.");
            
        } catch (Exception e) {
            System.err.println("Error detectado:");
            e.printStackTrace();
        } finally {
            // Cerramos la factoría al terminar la prueba
            HibernateUtil.shutdown();
        }
    }
}