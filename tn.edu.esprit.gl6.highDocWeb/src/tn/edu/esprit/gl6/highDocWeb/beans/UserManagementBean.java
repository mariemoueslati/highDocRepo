package tn.edu.esprit.gl6.highDocWeb.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.UserServicesLocal;

@ManagedBean
@ViewScoped
public class UserManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// models
	private Patient patient = new Patient();
	private List<Patient> patients;
	private boolean listeOfPatientsVisibility = false;
	private DataModel<Patient> dataModel = new ListDataModel<>();

	// Injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// Methode

	public String doAddPatient() {
		userServicesLocal.addUser(patient);
		patient = new Patient();
		return "";
	}
	
	public String doUpdatePatient() {
		userServicesLocal.updateUser(patient);
		patient = new Patient();
		disableVisibility();
		return "";
	}
	public String doDeletePatient(){
		userServicesLocal.deleteUser(patient);
		patient = new Patient();
		disableVisibility();
		return "";
	}


	public String enableVisibility() {
		listeOfPatientsVisibility = true;
		return "";
	}
	
	public String disableVisibility() {
		listeOfPatientsVisibility = false;
		return "";
	}


	public String selectPatient() {
		patient = dataModel.getRowData();
		enableVisibility();
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

	public DataModel<Patient> getDataModel() {
		dataModel.setWrappedData(userServicesLocal.findAllPatients());
		return dataModel;
	}

	public void setDataModel(DataModel<Patient> dataModel) {
		this.dataModel = dataModel;
	}

}
