package bal;

import java.util.List;

import dao.PatientDAO;
import dao.StaffDAO;
import entities.Patient;
import entities.Staff;
import helper.SubjectCreator;

public class StaffManagerBAL implements BAL{

	String s_name,  s_dob,  s_address,  s_phone;
	int s_gender, s_designation ;
	public List<Staff> getData() {
		StaffDAO dao = new StaffDAO(new Staff("","",0,"","",0));
		return (List<Staff>) dao.Select();
	}

	public boolean addData(String ...data) {
		s_name = data[0];
		s_dob = data[1];
		s_gender = Integer.valueOf(data[2]);
		s_address = data[3];
		s_phone = data[4];
		s_designation = Integer.valueOf(data[5]);
		StaffDAO dao = new StaffDAO(SubjectCreator.createStaff(s_name, s_dob, s_gender, s_address, s_phone, s_designation));
		return dao.Add();
	}
	
}
