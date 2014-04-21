package tn.edu.esprit.gl6.highDocWeb.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.gl6.highDocEJB.domain.Doctor;
import tn.edu.esprit.gl6.highDocEJB.domain.Nurse;
import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.domain.User;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.LoginServicesLocal;

@ManagedBean
@SessionScoped
public class MrBean implements Serializable {
	// the model
	private User user = new User();
	// injection of the proxy
	@EJB
	private LoginServicesLocal loginServicesLocal;

	// methods
	public String doLogin() {
		User userFound = loginServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userFound != null) {
			user = userFound;
			if (userFound instanceof Doctor) {
				return "doc.jsf?faces-redirect=true";
			}
			if (userFound instanceof Nurse) {
				return "pages/patients/patientsManagement?faces-redirect=true";
			}
			if (userFound instanceof Patient) {
				return "patient.jsf";
			}
		} else {
			return "error.jsf";

		}
		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
