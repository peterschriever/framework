package Framework.Dialogs;

import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import java.util.Optional;

/**
 * Class UserNameDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class UserNameDialog implements DialogInterface {

    private String userName;

    public void display(){
        // Setup dialog
        setupDialog();

        // Callback
        executeCallback();
    }

    public void setupDialog(){
        // Create dialog
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Create username");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your username:");

        // Change image
        ImageView image = new ImageView(this.getClass().getResource("username_img.png").toString());
        image.setFitHeight(40);
        image.setFitWidth(40);
        dialog.setGraphic(image);

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

        // Set username field with lambda
        result.ifPresent(this::setUserName);
    }

    // Method to ... something.
    public void executeCallback(){
        // Confirm username in terminal
        System.out.println("Your username: "+ getUserName());
    }


    /*
     * Getters and setters:
     */

    // Get username
    private String getUserName() {
        return userName;
    }

    // Set username
    private void setUserName(String userName) {
        this.userName = userName;
    }
}


