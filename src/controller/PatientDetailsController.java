package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import bal.PatientManagerBAL;
import entities.Patient;
import helper.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientDetailsController implements Initializable {

	@FXML private TextField textName;
	
	@FXML private Label labelName, labelAge, labelWeight, labelProblem, labelTreatment, labelMedicine, labelDoctor, labelBed, labelAddress, labelPhone;
	
	
	public void buttonfindPatient() {
		if (textName.getText().trim().toString().isEmpty()) {
			Util.showAlert("Enter patient name.");
		} else {
		PatientManagerBAL patientBal = new PatientManagerBAL();
		List<Patient> patients = patientBal.getListOfPatient();
		
		for (Patient p: patients) {
			if (textName.getText().trim().toLowerCase().toString().equalsIgnoreCase(p.getP_name())) {
				labelName.setText(p.getP_name());
				labelAge.setText(p.getP_age());
				labelWeight.setText(p.getP_weight());
				labelWeight.setText(p.getP_weight());
				labelProblem.setText(p.getP_problem());
				labelTreatment.setText(p.getP_treatment());
				labelMedicine.setText(p.getP_medicine());
				
				if (p.getP_doctor() == 1) {
					labelDoctor.setText("Lab");

				} else if (p.getP_doctor() == 2) {
					labelDoctor.setText("Doctor");
				} else {
					labelDoctor.setText("General");
				}
				
				if (p.getP_bed() == 1) {
					labelBed.setText("Economy");

				} else if (p.getP_doctor() == 2) {
					labelBed.setText("Normal");
				} else {
					labelBed.setText("VIP");
				}
				
				labelAddress.setText(p.getP_address());
				labelPhone.setText(p.getP_phone());
				
			}
		}
		
		}
		
		
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
