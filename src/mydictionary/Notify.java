package mydictionary;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 *
 * @author Mohammad Dehghan
 */
public class Notify {

    public static Alert createAlert(String message, AlertType type) {
        Alert alert = new Alert(type, message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);
        return alert;
    }
}
