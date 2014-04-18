package tn.edu.esprit.gl6.highDocEJB.services.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.gl6.highDocEJB.domain.User;

@Local
public interface LoginServicesLocal {
	User login(String login, String pwd);
}
