package utilities;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.cfg.annotations.QueryBinder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import exceptions.NotFoundSQLException;

public class EntityUtil<T> {
	
	private Session session;
	private Class<T> type;
	private String tableName;
	public EntityUtil(Class<T> type) {
		this.type = type;
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.tableName = this.type.getSimpleName();
	}
	
	
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
	
	public List<T> getEntities(PredicateBuilder<T> pre) {
		CriteriaBuilder cb = this.session.getCriteriaBuilder();
		CriteriaQuery<T> qb = cb.createQuery(this.type);
		Root<T> root = qb.from(this.type);
		
		CriteriaQuery<T> query = qb.select(root).where(pre.builder(cb, root));
		TypedQuery<T> tq = this.session.createQuery(query);
		
		return tq.getResultList();
	}
	
	public T getEntity(String columnName, Object val, boolean like) {
		this.session.beginTransaction();
		String query = "FROM " + this.tableName + " WHERE "+ columnName;
		query += (like ? " LIKE :val" : "=:val");
		Query q = this.session.createQuery(query);
		q.setMaxResults(1);
		q.setParameter("val", like ? "%" + val + "%": val);
		List<T> results = q.getResultList();
		return results.size() > 0 ? results.get(0) : null;
	}	
	
	public List<T> getEntities(String columnName, Object val, boolean like) {
		this.session.beginTransaction();
		String query = "FROM " + this.tableName;
		if (columnName != null) {
			query += " WHERE " + columnName + (like ? " LIKE " : "=") +":val";
		}
		Query q = this.session.createQuery(query);
		if (columnName != null) {
			q.setParameter("val", like ? "%" + val + "%" : val);
		}
		List<T> results = q.getResultList();
		return results;
	}	
	
	public T create(T entity) {
		this.session.beginTransaction();
		this.session.save(entity);
		this.session.getTransaction().commit();
		return entity;
	}
	
	public T createMany(T... entities) {
//		public static void saveAll(Object... obj) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		for (Object o : obj) {
//			session.save(o);
//		}
//		session.getTransaction().commit();
//	}
		return null;
	}
	
	public T delete(T entity) throws NotFoundSQLException {
		this.session.beginTransaction();
		this.session.remove(entity);
		this.session.getTransaction().commit();
		TransactionStatus status = this.session.getTransaction().getStatus();
		
		if (status != TransactionStatus.COMMITTED) {
			throw new NotFoundSQLException();
		}
		return entity;
	}
	
	public T update(T entity) {
		this.session.beginTransaction();
		this.session.update(entity);
		this.session.getTransaction().commit();		
		return entity;
	}
	

}
