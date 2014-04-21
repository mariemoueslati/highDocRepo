package tn.edu.esprit.gl6.highDocWeb.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.UserServicesLocal;

@ManagedBean
@RequestScoped
public class UserManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// models
	private Patient patient = new Patient();
	private List<Patient> patients;
	private boolean listeOfPatientsVisibility = false;

	// Injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// Methode

	public String doAddPatient() {
		userServicesLocal.addUser(patient);
		patient=new Patient();
		return "";
	}

	public String enableVisibility() {
		listeOfPatientsVisibility = true;
		return "";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		patients = userServicesLocal.findAllPatients();
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public boolean isListeOfPatientsVisibility() {
		return listeOfPatientsVisibility;
	}

	public void setListeOfPatientsVisibility(boolean listeOfPatientsVisibility) {
		this.listeOfPatientsVisibility = listeOfPatientsVisibility;
	}

}
