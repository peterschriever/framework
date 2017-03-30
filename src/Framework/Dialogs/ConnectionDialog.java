package Framework.Dialogs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Class ConnectionDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class ConnectionDialog implements DialogInterface {

    private String ipAddress;
    private String portNumber;

    public void display(){
        // Setup dialog
        setupDialog();

        //Callback
        executeCallback();
    }

    public void setupDialog(){
        // Create the custom dialog.
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Create connection");
        dialog.setHeaderText("Please enter your configuration details:");

        // Create grid with the ip and port labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));

        TextField ip = new TextField();
        TextField port = new TextField();

        grid.add(new Label("IP address:"), 0, 0);
        grid.add(ip, 1, 0);
        grid.add(new Label("Port number:"), 0, 1);
        grid.add(port, 1, 1);

        // Set the button types.
        ButtonType connectButtonType = new ButtonType("Connect", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(connectButtonType, ButtonType.CANCEL);

        // Enable/Disable connect button depending on whether a ip was entered.
        Node connectButton = dialog.getDialogPane().lookupButton(connectButtonType);
        connectButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        ip.textProperty().addListener((observable, oldValue, newValue) -> {
            connectButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        // Automatic focus on the ip field by default.
        Platform.runLater(ip::requestFocus);

        // Start dialog
        dialog.showAndWait();

        // Set ip and port in fields
        setIpAddress(ip.getText());
        setPortNumber(port.getText());
    }

    public void executeCallback(){
        // Confirm connection properties in terminal
        System.out.println("Connection: "+ getIpAddress() + ":" + getPortNumber());    }


    /*
     * Getters and setters:
     */

    // Set IP address
    private void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    // Set port number
    private void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    // Get IP address
    private String getIpAddress() {
        return ipAddress;
    }

    // Get port number
    private String getPortNumber() {
        return portNumber;
    }
}
