package bal;

import java.util.List;

import ORM.EntityFactory;
import dao.PatientDAO;
import dao.UserDAO;
import entities.Patient;
import entities.User;
import helper.SubjectCreator;

public class PatientManagerBAL implements BAL {
	String patientName, 
	 patientAge, 
	 patientWeight,
	 patientGender, 
	 bedType, 
	 doctorType, 
	 patientProblem,
	 patientTreatment,
	 patientMedicine,
	 patientAddress,
	 patientPhone;
	@Override
	public List<Patient> getData() {
		PatientDAO dao = new PatientDAO(new Patient("","","","0","0","0","","","","",""));
		return (List<Patient>) dao.Select();
	}
	
	public boolean addData(String ...data) {
		patientName = data[0];
		 patientAge = data[1];
		 patientWeight= data[2];
		 patientGender = data[3];
		 bedType = data[4];
		 doctorType = data[5];
		 patientProblem = data[6];
		 patientTreatment = data[7];
		 patientMedicine = data[8];
		 patientAddress= data[9];
		 patientPhone = data[10];
		PatientDAO dao = new PatientDAO(SubjectCreator.createPatient(patientName, patientAge, patientWeight, patientGender, bedType, doctorType, patientProblem, patientTreatment, patientMedicine, patientAddress, patientPhone));
		return dao.Add();
	}
}
