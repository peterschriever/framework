package Framework.Dialogs;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by Ruben on 28-Mar-17.
 */
public class UserNameDialog {

    public void diplay(){

        TextInputDialog dialog = new TextInputDialog("Anonymous");
        dialog.setTitle("Username creation");
        dialog.setHeaderText("Create an username:");
        dialog.setContentText("Please enter your username:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> System.out.println("Your name: " + name));


    }
}
