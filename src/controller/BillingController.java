package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Billing.BillingItem;
import bal.BAL;
import bal.FacadeBAL;
import bal.PatientManagerBAL;
import entities.Charge;
import entities.Patient;
import helper.SubjectCreator;
import hospitalbilling.GeneralServiceCharge;
import hospitalbilling.HospitalBillPriceVistor;
import hospitalbilling.IServiceCharge;
import hospitalbilling.Miscellaneous;
import hospitalbilling.Service;
import hospitalbilling.StaffServiceCharge;
import hospitalbilling.Tax;
import hospitalbilling.VipServiceCharge;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BillingController implements Initializable {

	@FXML private TextField textName, textToken, textPrice;
	
	@FXML private Label labelName, labelAge, labelWeight, labelPhone, labelPatientAvailability, labelTotalPrice;
	
	@FXML private ChoiceBox choiceServiceType;
	
	@FXML private TableView tablePatientBill;
	
	@FXML private Button buttonAddBill;
	
	private String selectedServiceType;
	
	List<IServiceCharge> sc = new ArrayList<IServiceCharge>();
	
	public void buttonFindPatient() {
		
		BAL patientBal = new PatientManagerBAL();
		List<Patient> patients = (List<Patient>) patientBal.getData();
		boolean found = false;
		for (Patient p: patients) {
			if (textName.getText().trim().toLowerCase().toString().equalsIgnoreCase(p.getP_name())) {
				found = true;
				labelName.setText(p.getP_name());
				labelAge.setText(p.getP_age());
				labelWeight.setText(p.getP_weight());
				labelPhone.setText(p.getP_phone());
				
				labelPatientAvailability.setText("");
				buttonAddBill.setDisable(false);
				textPrice.setDisable(false);
				textToken.setText(labelName.getText().toString());
			}
		}
		
		if (!found) {
			
			labelName.setText("N/A");
			labelAge.setText("N/A");
			labelWeight.setText("N/A");
			labelPhone.setText("N/A");
			textPrice.setDisable(true);
			labelPatientAvailability.setText("Patient not found.");
			buttonAddBill.setDisable(true);

		}
		
		
	}
	List<Charge> chargeList ;
	private void addChargeToList()
	{sc= new ArrayList<IServiceCharge>(); 
		for(Charge charge:chargeList)
		{
		if(charge.getServiceType().equals("Lab"))
			sc.add(new GeneralServiceCharge(charge));
		else if(charge.getServiceType().equals("VIP Bed"))
			sc.add(new StaffServiceCharge(charge));
		else
			sc.add(new VipServiceCharge(charge));
		}
	}
	
	public void buttonAddBill() {
		
		tablePatientBill.getColumns().clear();

		
		tablePatientBill.setEditable(true);
		
		
		
		FacadeBAL bal = new FacadeBAL();
		bal.addChargeData(textName.getText().trim().toString(), selectedServiceType, textPrice.getText().trim().toString());
		chargeList = bal.getChargeData();
		//Charge charge =SubjectCreator.createCharge(textName.getText().trim().toString(), selectedServiceType, Double.valueOf(textPrice.getText().trim().toString()));
		addChargeToList();
		
		ObservableList data = FXCollections.observableList(chargeList);

		TableColumn patientName = new TableColumn("Name");
		patientName.setMinWidth(219);
		patientName.setCellValueFactory(new PropertyValueFactory<Charge, String>("patientId"));

		TableColumn serviceType = new TableColumn("ServiceType");
		serviceType.setMinWidth(219);
		serviceType.setCellValueFactory(new PropertyValueFactory<Charge, String>("serviceType"));

		TableColumn price = new TableColumn("Price");
		price.setMinWidth(219);
		price.setCellValueFactory(new PropertyValueFactory<Charge, String>("price"));
		
		
		tablePatientBill.setItems(data);
		tablePatientBill.autosize();

		tablePatientBill.getColumns().addAll(patientName, serviceType, price);

		labelTotalPrice.setText(String.valueOf(calculateTotalPrice()));
		
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeView();
	}

	private void initializeView() {
		
		String services[] = {"Lab", "Economy Bed", "VIP Bed", "Amnbulance", "Medicine"};
		ObservableList<String> serviceList = FXCollections.observableArrayList(services);
		choiceServiceType.setItems(serviceList);
		
		choiceServiceType.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  //1=Male, 2=Female, 3=Other
        	  
        	  selectedServiceType = String.valueOf(services[new_value.intValue()]);
//        	  
          }
        });
		
	}

	private double calculateTotalPrice() {
		List<BillingItem> billItems = new ArrayList<>();
		
		Miscellaneous misc = new Miscellaneous();
		billItems.add(misc);
		
		double tot=getTotalServiceCharge();
		Tax tax = new Tax(tot);
		
		billItems.add(misc);
		billItems.add(new Service(tot));
		
		HospitalBillPriceVistor visitor = new HospitalBillPriceVistor();
		for(BillingItem item: billItems)
		{
			item.accept(visitor);
		}
		
		double totalPrice =visitor.getTotalPrice();
		return totalPrice;
	}
	
	private double getTotalServiceCharge() {
		double totalServiceCharge = 0.0;
		
		for(IServiceCharge c: sc) {
			totalServiceCharge+=c.getServiceCharge();
		}
		
		return totalServiceCharge;
	}
	
}
