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

    /**
     * @param errorTitle   Sets the title for the error dialog.
     * @param errorContent Sets the message of the error.
     */
    public void display() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorContent);
        alert.showAndWait();
        this.executeCallback();
    }

    private void executeCallback() {
        // @TODO: implement callback
        System.out.println("todo: implement errDialogCallback");
    }
}
