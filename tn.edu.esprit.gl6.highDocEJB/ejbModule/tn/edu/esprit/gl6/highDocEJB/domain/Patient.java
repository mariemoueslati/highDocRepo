package tn.edu.esprit.gl6.highDocEJB.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.edu.esprit.gl6.highDocEJB.domain.User;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity

public class Patient extends User implements Serializable {

	
	private String folderRef;
	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
	}   
	public String getFolderRef() {
		return this.folderRef;
	}

	public void setFolderRef(String folderRef) {
		this.folderRef = folderRef;
	}
   
}
