package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Rules.RuleException;
import Rules.RuleSet;
import bal.PatientManagerBAL;
import bal.UserManagerBAL;
import entities.Patient;
import entities.User;
import helper.RuleSetFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserManagerController implements Initializable {
	@FXML
	public TextField txtName, txtAge, txtWeight, txtAddress, txtPhone;
	
	@FXML TextArea txtProblem, txtTreatment, txtMedicine;

	@FXML ChoiceBox choiceGender, choiceBed, choiceDoctor;

	@FXML
	private TableView<User> tablePatient;
	
	private int selectedGender, selectedBed, selectedDoctor;

	public void btnAddPatient() {
		PatientManagerBAL patientBAL = new PatientManagerBAL();
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(UserManagerController.this);
			rules.applyRules(UserManagerController.this);
			
			if (selectedGender != 0 && selectedBed != 0 && selectedDoctor !=0) {
				patientBAL.AddPatient(txtName.getText().trim().toString(), txtAge.getText().trim().toString(), txtWeight.getText().trim().toString(), String.valueOf(selectedGender), String.valueOf(selectedBed), String.valueOf(selectedDoctor), txtProblem.getText().trim().toString(), txtTreatment.getText().trim().toString(), txtMedicine.getText().trim().toString(), txtAddress.getText().trim().toString(), txtPhone.getText().trim().toString());
				clearFields();
				LoadUsers();
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error Saving User");
				alert.setHeaderText("Cannot add User");
				alert.showAndWait();
			}
			
		
		} catch (RuleException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error Saving User");
			alert.setHeaderText("Cannot add User");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void clearFields() {
		txtName.setText("");
		txtAge.setText("");
		txtWeight.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtProblem.setText("");
		txtTreatment.setText("");
		txtMedicine.setText("");
		selectedGender = 0;
		selectedBed = 0;
		selectedDoctor = 0;
	}

	void LoadUsers() {
		
		String gender[] = {"Male", "Female", "Other"};
		String bedType[] = {"Economy", "Normal", "VIP"};
		String doctorType[]	= {"Lab", "Doctor", "General"};
		
		
		
		ObservableList<String> genderList = FXCollections.observableArrayList(gender);
		System.out.println(genderList);
        ObservableList<String> bedList = FXCollections.observableArrayList(bedType);
		System.out.println(bedList);
		ObservableList<String> doctorList = FXCollections.observableArrayList(doctorType);
		System.out.println(doctorList);

		choiceGender.setItems(genderList);
		
		choiceGender.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Male, 2=Female, 3=Other
        	  selectedGender = new_value.intValue()+1;
        	  
          }
        });
		
		choiceBed.setItems(bedList);
		choiceBed.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Economy, 2= Normal, 3=VIP
        	  selectedBed = new_value.intValue()+1;
          }
        });
		
		choiceDoctor.setItems(doctorList);	
		choiceDoctor.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Lab, 2=Doctor, 3=General
        	  selectedDoctor = new_value.intValue()+1;
          }
        });
		
		PatientManagerBAL patientBal = new PatientManagerBAL();
		tablePatient.getColumns().clear();

		List<Patient> patients = patientBal.getListOfPatient();
		tablePatient.setEditable(true);

		TableColumn patientName = new TableColumn("Name");
		patientName.setMinWidth(203);
		patientName.setCellValueFactory(new PropertyValueFactory<Patient, String>("p_name"));

		TableColumn patientAge = new TableColumn("Age");
		patientAge.setMinWidth(203);
		patientAge.setCellValueFactory(new PropertyValueFactory<Patient, String>("p_age"));

		TableColumn patientWeight = new TableColumn("Weight");
		patientWeight.setMinWidth(203);
		patientWeight.setCellValueFactory(new PropertyValueFactory<Patient, String>("p_weight"));
		
		TableColumn patientPhone = new TableColumn("Phone");
		patientPhone.setMinWidth(203);
		patientPhone.setCellValueFactory(new PropertyValueFactory<Patient, String>("p_phone"));

		ObservableList data = FXCollections.observableList(patients);

		tablePatient.setItems(data);
		tablePatient.autosize();

		tablePatient.getColumns().addAll(patientName, patientAge, patientWeight, patientPhone);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LoadUsers();
	}
}
