package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import helper.LoggedInDetails;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DashBoardController implements Initializable {
	@FXML
	private AnchorPane rootLayout;

	@FXML
	private Hyperlink hp1, hp2, hlnkLogout;

	@FXML
	private BorderPane pane;

	@FXML
	private Accordion accord;

	@FXML
	private TitledPane pane1, pane2, pane3;

	@FXML
	private Label lblWelcomeMsg;

	@FXML
	private Button btnLogin;

	public void viewUserManager() throws IOException
	{
		URL url1 = new File("src/view/userManager.fxml").toURL();
		Parent root1 = FXMLLoader.load(url1);
		pane.setCenter(root1);

	}
	public void addNewMember() throws IOException {

		URL url1 = new File("src/view/addNewMember.fxml").toURL();
		Parent root1 = FXMLLoader.load(url1);
		pane.setCenter(root1);

	}

	public void addBook() throws IOException {

		URL url2 = new File("src/view/addABook.fxml").toURL();
		Parent root2 = FXMLLoader.load(url2);
		pane.setCenter(root2);

	}

	public void checkOutBook() throws IOException {

		URL url3 = new File("src/view/addCheckOutForm.fxml").toURL();
		Parent root3 = FXMLLoader.load(url3);
		pane.setCenter(root3);

	}

	public void addCopyOfBook() throws IOException {

		URL url4 = new File("src/view/addACopy.fxml").toURL();
		Parent root4 = FXMLLoader.load(url4);
		pane.setCenter(root4);

	}

	public void logOut() {
		Stage stage = (Stage) lblWelcomeMsg.getScene().getWindow();
		stage.close();
		loadLoginView();
	}

	public void loadLoginView() {
		URL url = null;
		try {
			url = new File("src/view/loginView.fxml").toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parent root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		String authLevel = LoggedInDetails.getAuthLevel();
		//System.out.println(LoggedInDetails.getUserName());
		lblWelcomeMsg.setText(LoggedInDetails.getUserName());

		try {
			if (authLevel.equals("LIBRARIAN")) {
				pane1.setVisible(false);
				accord.setExpandedPane(pane3);
				checkOutBook();
			} else if (authLevel.equals("ADMIN")) {
				pane3.setVisible(false);
				accord.setExpandedPane(pane1);
				addNewMember();
			} else {
				accord.setExpandedPane(pane1);
				addNewMember();
			}

		} catch (Exception e) {

		}
	}
}
