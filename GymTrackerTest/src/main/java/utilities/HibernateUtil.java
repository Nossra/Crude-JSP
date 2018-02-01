package utilities;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	
    public static SessionFactory getSessionFactory()
    {
    	if(sessionFactory == null) {
    	    try
    	    {
    	    	Configuration configuration = new Configuration().configure();
    	    	System.out.println("configuration has been created ..");
    	    	sessionFactory = configuration.buildSessionFactory();
    	    	System.out.println("session factory has been created ..");
    	    } catch (HibernateException he)
    	    {
    	    	System.err.println("Error creating Session: " + he.getMessage());
    	    	throw new ExceptionInInitializerError(he);
    	    }
    	}
        return sessionFactory;
    } 
}
