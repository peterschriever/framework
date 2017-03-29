package Framework.Dialogs;

import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import java.util.Optional;

/**
 * Created by Ruben on 28-Mar-17.
 */
public class UserNameDialog {

    private String userName;

    public void diplay(){

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

        // Confirm username in terminal
        result.ifPresent(name -> System.out.println("Your username is: " + name));
    }

    /*
     * Getters and setters:
     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


