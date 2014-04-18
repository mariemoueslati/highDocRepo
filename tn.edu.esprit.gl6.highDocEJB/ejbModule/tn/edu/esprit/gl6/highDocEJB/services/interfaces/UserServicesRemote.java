package tn.edu.esprit.gl6.highDocEJB.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.domain.User;

@Remote
public interface UserServicesRemote {

	boolean addUser(User user);

	boolean deleteUser(User user);

	boolean updateUser(User user);

	User findUserById(int id);

	List<Patient> findAllPatients();

}
