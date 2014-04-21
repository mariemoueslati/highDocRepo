package tn.edu.esprit.gl6.highDocClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.gl6.highDocEJB.domain.Doctor;
import tn.edu.esprit.gl6.highDocEJB.domain.Nurse;
import tn.edu.esprit.gl6.highDocEJB.domain.Patient;
import tn.edu.esprit.gl6.highDocEJB.domain.User;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.LoginServicesRemote;
import tn.edu.esprit.gl6.highDocEJB.services.interfaces.UserServicesRemote;

public class TestRealPlatform {

	private Context context;
	private LoginServicesRemote loginServicesRemote;
	private UserServicesRemote userServicesRemote;

	@Before
	public void init() {
		try {
			context = new InitialContext();
			String jndiName = "ejb:tn.edu.esprit.gl6.highDoc/tn.edu.esprit.gl6.highDocEJB/LoginServices!"
					+ LoginServicesRemote.class.getCanonicalName();
			loginServicesRemote = (LoginServicesRemote) context
					.lookup(jndiName);
			String jndiName2 = "ejb:tn.edu.esprit.gl6.highDoc/tn.edu.esprit.gl6.highDocEJB/UserServices!"
					+ UserServicesRemote.class.getCanonicalName();
			userServicesRemote = (UserServicesRemote) context.lookup(jndiName2);
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Test
	
	public void testLogin() {
		User userFound = loginServicesRemote.login("a", "a");
		Assert.assertEquals("meriem", userFound.getName());
	}

	@Test
	public void initDB() {
		Doctor doctor = new Doctor();
		doctor.setName("Dr Hakim");
		doctor.setLogin("hakim");
		doctor.setPassword("hakim");
		doctor.setSpeciality("love");

		Nurse nurse = new Nurse();
		nurse.setName("amina");
		nurse.setLogin("amina");
		nurse.setPassword("amina");
		nurse.setLevel("beginner");

		Patient patient = new Patient();
		patient.setName("rami");
		patient.setLogin("rami");
		patient.setPassword("rami");
		patient.setFolderRef("MT-esprit-2014");

		Patient patient2 = new Patient();
		patient2.setName("rania");
		patient2.setLogin("rania");
		patient2.setPassword("rania");
		patient2.setFolderRef("FT-esprit-2014");

		Assert.assertTrue(userServicesRemote.addUser(doctor));
		Assert.assertTrue(userServicesRemote.addUser(nurse));
		Assert.assertTrue(userServicesRemote.addUser(patient));
		Assert.assertTrue(userServicesRemote.addUser(patient2));

	}

	@Test
	public void itShouldFindAllPatients() {
		Assert.assertEquals(2, userServicesRemote.findAllPatients().size());
	}

}
