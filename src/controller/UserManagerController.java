package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Rules.RuleException;
import Rules.RuleSet;
import bal.BookBAL;
import bal.UserManagerBAL;
import entities.Book;
import entities.User;
import helper.RuleSetFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserManagerController implements Initializable {
	@FXML
	public TextField txtuserID;

	@FXML
	public TextField txtUserName;

	@FXML
	public TextField txtPassword;

	@FXML
	public TextField txtAuthLevel;

	@FXML
	public ComboBox<Integer> cmbBoxMaxCheckOutLength;

	@FXML
	private TableView<Book> table;

	public void addUser() {
		UserManagerBAL userBal = new UserManagerBAL();
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(UserManagerController.this);
			rules.applyRules(UserManagerController.this);
			userBal.AddUser(txtuserID.getText(), txtUserName.getText(), txtPassword.getText(), txtAuthLevel.getText());
			LoadUsers();
		} catch (RuleException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error Saving User");
			alert.setHeaderText("Cannot add User");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	void LoadUsers() {
		UserManagerBAL userBal = new UserManagerBAL();
		table.getColumns().clear();

		List<User> users = userBal.getListOfUser();
		table.setEditable(true);

		TableColumn userIdCol = new TableColumn("Id");
		userIdCol.setMinWidth(350);
		userIdCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserId"));

		TableColumn authorCol = new TableColumn("User Name");
		authorCol.setMinWidth(150);
		authorCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserName"));

		TableColumn passwordCol = new TableColumn("Password");
		passwordCol.setMinWidth(150);
		passwordCol.setCellValueFactory(new PropertyValueFactory<User, String>("passWord"));

		TableColumn roleCol = new TableColumn("Role");
		roleCol.setMinWidth(150);
		roleCol.setCellValueFactory(new PropertyValueFactory<User, String>("AuthLevel"));

		ObservableList data = FXCollections.observableList(users);

		table.setItems(data);
		table.autosize();

		table.getColumns().addAll(userIdCol, authorCol, passwordCol, roleCol);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LoadUsers();
	}
}
