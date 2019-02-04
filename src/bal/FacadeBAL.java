package bal;

import java.util.List;

import entities.Charge;
import entities.Patient;
import entities.User;

public class FacadeBAL {

	public List<User> getUserData(){
		BAL users = new UserManagerBAL();
		return (List<User>) users.getData();
	}

	public List<Patient> getPatientData(){
		BAL patients = new PatientManagerBAL();
		return (List<Patient>) patients.getData();
	}

	public boolean addUserData(String ...data){
		BAL user = new UserManagerBAL();
		return user.addData(data);
	}

	public boolean addPatientData(String ...data){
		BAL patient = new PatientManagerBAL();
		return patient.addData(data);
	}

	public boolean addStaffData(String ...data){
		BAL staff = new StaffManagerBAL();
		return staff.addData(data);
	}
	
	public List<Patient> getStaffData(){
		BAL staff = new StaffManagerBAL();
		return (List<Patient>) staff.getData();
	}

	
	public boolean addChargeData(String ...data){
		BAL charge = new BillManagerBAL();
		return charge.addData(data);
	}
	
	public List<Charge> getChargeData(){
		BAL charge = new BillManagerBAL();
		return (List<Charge>) charge.getData();
	}

//	public static void main(String[] args) {
//		FacadeBAL p = new FacadeBAL();
//		for (Object patient : p.getPatientData()) {
//			System.out.println((Patient)patient);
//		}
//		p.addPatientData("Rame dai", "something","44","1","1","1");
//	}
}
