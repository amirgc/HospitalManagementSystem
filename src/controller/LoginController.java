package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import bal.LoginBAL;
import entities.User;
import helper.LoggedInDetails;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	public TextField textUser;

	@FXML
	public TextField textPassword;

	@FXML
	public Label resultLabel;

	@FXML
	public void Login() throws IOException {

		resultLabel.setText("");
		String userID = textUser.getText();
		String password = textPassword.getText();
		LoginBAL l = new LoginBAL();
//		if (userID.isEmpty() && password.isEmpty()) {
//			resultLabel.setText("Please provide User Id And Password");
//			return;
//		}
		//User user = l.IsAuthentiCated(userID, password);
		User user = l.IsAuthentiCated("986677", "test1234");
		if (user == null) {
			resultLabel.setText("User Not Found");
		} else {

			LoggedInDetails.setAuthLevel(user.getAuthLevel());
			LoggedInDetails.setUserName("Welcome Back " + user.getUserName());
			loadMainFormPage();
		}

	}

	public void loadMainFormPage() throws IOException {

		Stage stage = (Stage) textPassword.getScene().getWindow();
		stage.close();

		URL url = new File("src/view/mainFormView.fxml").toURL();
		Parent root = FXMLLoader.load(url);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		URL url1 = new File("src/view/bootstrap3.css").toURL();
		scene.getStylesheets().add(url1.toExternalForm());
		stage.setTitle("Library Management System");
		stage.setMaximized(true);
		stage.show();

	}
}
