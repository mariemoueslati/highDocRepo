package tn.edu.esprit.gl6.highDocEJB.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.domain.User;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.UserServicesLocal;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */

	public UserServices() {

	}

	@Override
	public boolean addUser(User user) {
		boolean b = false;
		try {
			entityManager.persist(user);
			b = true;

		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean b = false;
		try {
			entityManager.remove(findUserById(user.getId()));
			b = true;

		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public boolean updateUser(User user) {
		boolean b = false;
		try {
			entityManager.merge(user);
			b = true;

		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<Patient> findAllPatients() {
		return entityManager.createQuery("select p from Patient p")
				.getResultList();
	}

}
