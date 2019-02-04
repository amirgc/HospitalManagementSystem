package bal;

import java.util.List;

import dao.PatientDAO;
import dao.StaffDAO;
import entities.Patient;
import entities.Staff;
import helper.SubjectCreator;

public class StaffManagerBAL {

	public List<Staff> getListOfStaff() {
		StaffDAO dao = new StaffDAO(new Staff("","",0,"","",0));
		return (List<Staff>) dao.Select();
	}

	public boolean AddStaff(String s_name, String s_dob, int s_gender, String s_address, String s_phone, int s_designation ) {
		StaffDAO dao = new StaffDAO(SubjectCreator.createStaff(s_name, s_dob, s_gender, s_address, s_phone, s_designation));
		return dao.Add();
	}
	
}
