package controller;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL url = new File("src/view/loginView.fxml").toURL();
		Parent root = FXMLLoader.load(url);
		Scene scene = new Scene(root);
		URL url1 = new File("src/view/bootstrap3.css").toURL();
		scene.getStylesheets().add(url1.toExternalForm());
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

}
