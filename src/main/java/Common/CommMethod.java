package Common;

import javafx.scene.control.Alert;

import static Common.CommInstance.alert;

public final class CommMethod {

    static public void messageBox(String message) {
        // set alert type
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(message);
        // show the dialog
        alert.show();
    }

}
