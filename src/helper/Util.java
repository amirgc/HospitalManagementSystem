package helper;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Util {
	public static boolean isInRangeAtoZ(char c) {
		return (int)'A' <= (int)c && (int)c <= (int)'Z';
	}
	public static boolean isInRangeatoz(char c) {
		return (int)'a' <= (int)c && (int)c <= (int)'z';
	}
	
	public static void showAlert(String message) {
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Message");
        alert.setHeaderText(message);

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
           
        }
	}
}
