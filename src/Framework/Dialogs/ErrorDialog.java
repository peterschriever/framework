package Framework.Dialogs;

import javafx.scene.control.Alert;

/**
 * Class ErrorDialog
 *
 * @author Ruben Buisman
 * @version 0.2 (30-03-2017)
 */
public class ErrorDialog implements DialogInterface {
    private String errorTitle;
    private String errorContent;

    public ErrorDialog(String errorTitle, String errorContent) {
        this.errorContent = errorContent;
        this.errorTitle = errorTitle;
    }

    public void display() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorContent);
        alert.showAndWait();
    }
}
