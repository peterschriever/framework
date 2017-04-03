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
    private Dialog dialog;
    private GridPane grid;
    private TextField ip;
    private TextField port;

    public void display(){
        createDialog();
        createGrid();
        createButtons();

        // If closed, set the fields and execute callback.
        dialog.showAndWait();
        setFields();
        executeCallback();
    }

    private void createDialog() {
        dialog = new Dialog();
        dialog.setTitle("Create connection");
        dialog.setHeaderText("Please enter your configuration details:");
    }

    private void createGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
        addTextFields();
    }

    private void addTextFields() {
        ip = new TextField();
        port = new TextField();
        grid.add(new Label("IP address:"), 0, 0);
        grid.add(ip, 1, 0);
        grid.add(new Label("Port number:"), 0, 1);
        grid.add(port, 1, 1);
        Platform.runLater(ip::requestFocus);
    }

    private void createButtons() {
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
    }

    public void executeCallback(){
        System.out.println("Send to network: "+ getIpAddress() + ":" + getPortNumber());    }


    /*
     * Getters and setters
     */
    private void setFields() {
        setIpAddress(ip.getText());
        setPortNumber(port.getText());
    }

    private void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    private String getIpAddress() {
        return ipAddress;
    }

    private String getPortNumber() {
        return portNumber;
    }
}
