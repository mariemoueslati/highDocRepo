package tn.edu.esprit.gl6.highDocEJB.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.edu.esprit.gl6.highDocEJB.domain.User;

/**
 * Entity implementation class for Entity: Nurse
 *
 */
@Entity

public class Nurse extends User implements Serializable {

	
	private String level;
	private static final long serialVersionUID = 1L;

	public Nurse() {
		super();
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
   
}
