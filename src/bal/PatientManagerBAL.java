package bal;

import java.util.List;

import ORM.EntityFactory;
import dao.PatientDAO;
import dao.UserDAO;
import entities.Patient;
import entities.User;
import helper.SubjectCreator;

public class PatientManagerBAL {
	@SuppressWarnings("unchecked")
	public List<Patient> getListOfPatient() {
		PatientDAO dao = new PatientDAO(new Patient("","","","0","0","0","","","","",""));
		return (List<Patient>) dao.Select();
	}

	public boolean AddPatient(String patientName, 
			String patientAge, 
			String patientWeight,
			String patientGender, 
			String bedType, 
			String doctorType, 
			String patientProblem,
			String patientTreatment,
			String patientMedicine,
			String patientAddress,
			String patientPhone) {
		PatientDAO dao = new PatientDAO(SubjectCreator.createPatient(patientName, patientAge, patientWeight, patientGender, bedType, doctorType, patientProblem, patientTreatment, patientMedicine, patientAddress, patientPhone));
		return dao.Add();
	}
}
