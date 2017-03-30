package Framework.Dialogs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
        // Create the custom dialog.
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Create username");
        dialog.setHeaderText("Please enter your username:");

        // Create grid with the ip and port labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));

        TextField playerName = new TextField();
        grid.add(playerName, 0, 0);

        // Set the button types.
        ButtonType connectButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(connectButtonType, ButtonType.CANCEL);

        // Enable/Disable connect button depending on whether a ip was entered.
        Node connectButton = dialog.getDialogPane().lookupButton(connectButtonType);
        connectButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        playerName.textProperty().addListener((observable, oldValue, newValue) -> {
            connectButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        // Automatic focus on the ip field by default.
        Platform.runLater(playerName::requestFocus);

        // Start dialog
        dialog.showAndWait();

        // Set ip and port in fields
        setUserName(playerName.getText());
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


