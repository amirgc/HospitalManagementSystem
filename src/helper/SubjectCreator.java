package helper;

import entities.Charge;
import entities.Patient;
import entities.Staff;
import entities.User;

public class SubjectCreator {
	
	public static User createUser(String userId, String userName, String passWord, String authLevel) {
		return new User(userId, userName, passWord, authLevel);
	}
	
	public static Patient createPatient(String patientName, 
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
		return new Patient(patientName, patientAge, patientWeight, patientGender, bedType, doctorType, patientProblem, patientTreatment, patientMedicine, patientAddress, patientPhone);
	}
	
	public static Staff createStaff(String s_name, String s_dob, int s_gender, String s_address, String s_phone, int s_designation) {
		return new Staff(s_name, s_dob, s_gender, s_address, s_phone, s_designation);
	}
	
	public static Charge createCharge(String patientId, String serviceType, double price) {
		return new Charge(patientId, serviceType, price);
	}
	
}
