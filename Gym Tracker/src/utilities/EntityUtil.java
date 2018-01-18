package utilities;

import org.hibernate.Session;

public class EntityUtil {
	public static void save(Object obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
	public static void saveAll(Object... obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (Object o : obj) {
			session.save(o);
		}
		session.getTransaction().commit();
	}
}
