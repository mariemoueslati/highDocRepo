package tn.edu.esprit.gl6.highDocEJB.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.gl6.highDocEJB.domain.User;

@Remote
public interface LoginServicesRemote {
	User login(String login, String pwd);

}
