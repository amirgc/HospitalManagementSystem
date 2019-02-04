package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import bal.BAL;
import bal.PatientManagerBAL;
import bal.StaffManagerBAL;
import entities.Patient;
import entities.Staff;
import helper.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StaffDetailController implements Initializable {
	
	@FXML private TextField textName;
	
	@FXML private Label labelName, labelDOB, labelGender, labelDesignation, labelAddress, labelPhone;
	
	
	public void buttonFindStaff() {
		if (textName.getText().trim().toString().isEmpty()) {
			Util.showAlert("Enter name of staff to view his/her information.");
		} else {
			BAL staffBal = new StaffManagerBAL();
			List<Staff> staffList = (List<Staff>) staffBal.getData();
			
			for (Staff staff: staffList) {
				
				if (textName.getText().equalsIgnoreCase(staff.getS_name())) {
					labelName.setText(staff.getS_name());
					labelDOB.setText(staff.getS_dob());
					
					if (staff.getS_gender() == 1) {
						labelGender.setText("Male");

					} else if (staff.getS_gender() == 2) {
						labelGender.setText("Female");
					} else if (staff.getS_gender() == 3) {
						labelGender.setText("Other");
					}
					
					if (staff.getS_designation() == 1) {
						labelDesignation.setText("Lab");
					} else if (staff.getS_designation() == 2) {
						labelDesignation.setText("Doctor");
					} else {
						labelDesignation.setText("General");
					}
					
					labelAddress.setText(staff.getS_address());
					labelPhone.setText(staff.getS_phone());
					
				} 
				
				
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
