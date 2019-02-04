package bal;

import java.util.List;

import dao.BillDAO;
import dao.StaffDAO;
import entities.Charge;
import entities.Staff;
import helper.SubjectCreator;

public class BillManagerBAL implements BAL{

	String patientId,serviceType;
	double price;
	
	public List<Charge> getData() {
		BillDAO dao = new BillDAO(new Charge("","",0.0));
		return (List<Charge>) dao.Select();
	}

	public boolean addData(String ...data) {
		patientId = data[0];
		serviceType = data[1];
		price = Double.valueOf(data[2]);	
		BillDAO dao = new BillDAO(SubjectCreator.createCharge(patientId, serviceType, price));
		return dao.Add();
	}
	
}
