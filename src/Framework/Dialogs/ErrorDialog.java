package Framework.Dialogs;

import javafx.scene.control.Alert;

/**
 * Class ErrorDialog
 *
 * @author Ruben Buisman
 * @version 0.2 (30-03-2017)
 */
public class ErrorDialog {

    /**
     * @param errorTitle Sets the title for the error dialog.
     * @param errorContent Sets the message of the error.
     */
    public void display(String errorTitle, String errorContent){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorContent);
        alert.showAndWait();
    }
}
