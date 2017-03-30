package Framework.Dialogs;

import javafx.scene.control.Alert;

/**
 * Class ErrorDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (30-03-2017)
 */
public class ErrorDialog {

    public void display(String errorTitle, String errorContent){

        setupDialog(errorTitle, errorContent);

        executeCallback();
    }

    public void setupDialog(String errorTitle, String errorContent){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorContent);
        alert.showAndWait();
    }

    public void executeCallback(){
        System.out.println("Error: Something went wrong!");
    }
}
