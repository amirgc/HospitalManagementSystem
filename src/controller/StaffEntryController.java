package controller;

import java.net.URL;
import java.util.ResourceBundle;

import bal.PatientManagerBAL;
import bal.StaffManagerBAL;
import helper.Util;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class StaffEntryController implements Initializable {

	@FXML private TextField textName, textDOB, textAddress, textPhone;
	
	@FXML private ChoiceBox choiceGender, choiceDesignation;
	
	private String dob_pattern = "/^\\d{2}\\/\\d{2}\\/\\d{4}$/";

	private int selectedGender, selectedDesignation;
	public void buttonAddStaff() {
		
		boolean cancel = false;
		
		if (textName.getText().trim().toString().isEmpty()) {
			cancel = true;
			Util.showAlert("Cannot leave name field empty.");
		} else if (!textDOB.getText().trim().toString().matches(dob_pattern) && textDOB.getText().trim().toString().isEmpty()) {
			cancel = true;
			Util.showAlert("Please enter date in MM/DD/YYYY format.");
		} else if (textAddress.getText().trim().toString().isEmpty()) {
			cancel = true;
			Util.showAlert("Cannot leave address field empty.");
		} else if (textPhone.getText().trim().toString().isEmpty()) {
			cancel = true;
			Util.showAlert("Please enter phone number.");
		}
		
		if (!cancel) {
			
			addStaff(
					textName.getText().trim().toString(),
					textDOB.getText().trim().toString(),
					selectedGender,
					textAddress.getText().trim().toString(),
					textPhone.getText().trim().toString(),
					selectedDesignation				
					);
			
		}
		
		
	}
	
	
	private void addStaff(String name, String dob, int gender, String address, String phone, int designation) {
		
		StaffManagerBAL staffBAL = new StaffManagerBAL();
		if(staffBAL.AddStaff(name, dob, gender, address, phone, designation)) {
			Util.showAlert("Staff successfully added.");
			clearFields();
		} else {
			Util.showAlert("Couldn't add Staff.");
		}
	}


	private void clearFields() {
		
		textName.setText("");
		textDOB.setText("");
		textAddress.setText("");
		textPhone.setText("");
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		intializeView();
	}


	private void intializeView() {
		
		String gender[] = {"Male", "Female", "Other"};
		String designation[] = {"Lab", "Doctor", "General"};
		
		ObservableList<String> genderList = FXCollections.observableArrayList(gender);
        
		ObservableList<String> designationList = FXCollections.observableArrayList(designation);
		
		choiceGender.setItems(genderList);
		choiceDesignation.setItems(designationList);
		
		choiceGender.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Male, 2=Female, 3=Other
        	  selectedGender = new_value.intValue()+1;
        	  
          }
        });
		
		
		choiceDesignation.setItems(designationList);	
		choiceDesignation.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Lab, 2=Doctor, 3=General
        	  selectedDesignation = new_value.intValue()+1;
          }
        });
		
	}

}
