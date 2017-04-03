package Framework.Dialogs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Class UserNameDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class UserNameDialog {

    private String userName;
    private Dialog dialog;
    private GridPane grid;
    private TextField playerName;


    public void display(){
        createDialog();
        createGrid();
        createButtons();

        // If closed, set the fields and execute callback.
        dialog.showAndWait();
        setUserName(playerName.getText());
        executeCallback();
    }

    private void addTextFields() {
        playerName = new TextField();
        grid.add(playerName, 0, 0);
        Platform.runLater(playerName::requestFocus);
    }

    private void createButtons() {
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
    }

    private void createGrid() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
        addTextFields();
    }

    private void createDialog() {
        dialog = new Dialog();
        dialog.setTitle("Create username");
        dialog.setHeaderText("Please enter your username:");
    }

    public void executeCallback(){
        // Confirm username in terminal
        System.out.println("Send to network: "+ getUserName());
    }


    /*
     * Getters and setters:
     */
    private String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }
}


