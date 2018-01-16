package utilities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static
	{
	    try
	    {
	    	Configuration configuration = new Configuration().configure();
	    	sessionFactory = configuration.buildSessionFactory();
	    } catch (HibernateException he)
	    {
	    	System.err.println("Error creating Session: " + he);
	    	throw new ExceptionInInitializerError(he);
	    }
    }
	
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    } 
}
