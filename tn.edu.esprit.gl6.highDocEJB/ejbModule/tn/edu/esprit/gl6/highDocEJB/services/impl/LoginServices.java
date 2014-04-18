package tn.edu.esprit.gl6.highDocEJB.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl6.highDocEJB.domain.User;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.LoginServicesLocal;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.LoginServicesRemote;

/**
 * Session Bean implementation class LoginServices
 */
@Stateless
public class LoginServices implements LoginServicesRemote, LoginServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public LoginServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String login, String pwd) {
		User user = null;
		String jpql = "select u from User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", pwd);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("error");
		}
		return user;
	}

}
