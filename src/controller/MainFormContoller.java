package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainFormContoller implements Initializable {

	@FXML
	private AnchorPane rootLayout;

	@FXML
	private BorderPane pane;

	public void loadDashBoard() {
		URL url1 = null;
		try {
			url1 = new File("src/view/dashBoardView.fxml").toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Parent root1 = null;
		try {
			root1 = FXMLLoader.load(url1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pane.setTop(root1);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		loadDashBoard();
	}

}
