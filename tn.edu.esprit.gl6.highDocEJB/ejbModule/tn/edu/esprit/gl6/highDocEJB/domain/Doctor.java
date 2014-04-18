package tn.edu.esprit.gl6.highDocEJB.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.edu.esprit.gl6.highDocEJB.domain.User;

/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity

public class Doctor extends User implements Serializable {

	
	private String speciality;
	private static final long serialVersionUID = 1L;

	public Doctor() {
		super();
	}   
	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
   
}
