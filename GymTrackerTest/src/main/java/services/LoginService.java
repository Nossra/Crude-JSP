package services;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entities.User;
import utilities.HibernateUtil;
import viewmodel.LoginViewModel;

public class LoginService {
	public boolean login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> users = cq.from(User.class);
		cq.select(users);
		
		TypedQuery<User> q = session.createQuery(cq);
		List<User> userList = q.getResultList();
		
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public LoginViewModel getDetails(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> users = cq.from(User.class);
		cq.select(users);
		
		TypedQuery<User> q = session.createQuery(cq);
		List<User> userList = q.getResultList();
		
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(username)) {
				LoginViewModel user = new LoginViewModel();
				user.setName(userList.get(i).getName());
				user.setUsername(userList.get(i).getUsername());
				user.setId(userList.get(i).getId());
				return user;
			}
		}
		return null;
	}
}
