package controller;

import java.awt.Component;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import bal.MemberBAL;
import entities.Book;
import entities.Member;
import helper.RuleException;
import helper.RuleSet;
import helper.RuleSetFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddNewMemberController implements Initializable {

	@FXML
	public TextField txtMemId, txtFirstName, txtLastName, txtStreet, txtCity, txtState, txtZip, txtPhone;

	@FXML
	private TableView<Book> table;

	public void addMember() {
		MemberBAL mem = new MemberBAL();
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(AddNewMemberController.this);
			rules.applyRules(AddNewMemberController.this);
			mem.addNewMember(txtFirstName.getText(), txtLastName.getText(), txtStreet.getText(), txtCity.getText(),
					txtState.getText(), txtZip.getText(), txtPhone.getText());
			loadMembers();
			clearFields();
		} catch (RuleException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error Saving member");
			alert.setHeaderText("Cannot add member");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void clearFields() {

	}

	public void loadMembers() {
		MemberBAL mem = new MemberBAL();
		List<Member> lstMember = mem.loadMembers();
		ObservableList data = FXCollections.observableList(lstMember);

		table.getColumns().clear();
		table.setEditable(true);

		TableColumn titleCol = new TableColumn<Member, String>("Member ID");
		titleCol.setMinWidth(50);
		titleCol.setCellValueFactory(new PropertyValueFactory<Member, String>("memberID"));

		TableColumn fristNameCol = new TableColumn<>("First Name");
		fristNameCol.setMinWidth(150);
		fristNameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));

		TableColumn lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setMinWidth(150);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));

		TableColumn phoneNumberCol = new TableColumn<>("Phone Number");
		phoneNumberCol.setMinWidth(150);
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Member, String>("phone"));

		table.setItems(data);
		table.autosize();

		table.getColumns().addAll(titleCol, fristNameCol, lastNameCol, phoneNumberCol);
		// TableColumn<Person, String> lastNameCol1 = new TableColumn<>("Last Name"); ,
		// fristNameCol, lastNameCol, phoneNumberCol
		// lastNameCol.setMinWidth(100);
		// lastNameCol.setCellValueFactory(
		// new PropertyValueFactory<>("lastName"));

		// TableColumn<MemberDTO, String> unfriendCol = new TableColumn<>("");
		// unfriendCol.setMinWidth(40);
		// unfriendCol.setCellValueFactory(param -> new
		// ReadOnlyObjectWrapper<>(param.getValue()));
		//
		// unfriendCol.setCellFactory(param -> new TableCell<MemberDTO, String>() {
		// private final Button deleteButton = new Button("Unfriend");
		//
		// @Override
		// protected void updateItem(MemberDTO person, boolean empty) {
		//
		// super.updateItem(person, empty);
		//
		// if (person == null) {
		// setGraphic(null);
		// return;
		// }
		//
		// setGraphic(deleteButton);
		// deleteButton.setOnAction(event -> data.remove(person));
		// }
		//
		// });

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadMembers();

	}
}
