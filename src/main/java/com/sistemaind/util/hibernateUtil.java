package com.sistemaind.util;
/*esta clase se escarga de configurar y mantener una unica conexion glogal para toda nuestra aplicacion
(session factory)*/

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

 private static SessionFactory buildSessionFactory() {
	try {
		//Crear la SessionFactory a partir del archivo Hibernate.cfg.configure()
		//buscar automaticamente el archivo en src/main/resources
		return new Configuration().configure().buildSessionFactory();
	} catch (Throwable e) {
		//Muestra un error si es que no consigue
		System.err.println("Error al inicializar la SessionFactory" + e);
		throw new ExceptionInInitializerError();
	}
 }

 
 //Metodopara obtener la session en nuestro DAO
 public static SessionFactory getSessionFactory() {
	return SESSION_FACTORY;
 }
 
 //Metodo opcional para cerrar la fabrica salir de la aplicacion
 public static void shutdown() {
	 getSessionFactory().close();
 }
 
}
