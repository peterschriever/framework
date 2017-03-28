package Framework.Dialogs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

/**
 * Created by Ruben on 28-3-2017.
 */

public class ConnectionDialog {

    private String ipAddress;
    private Integer portNumber;

    //TODO: refactor display method to smaller tasks/methods, maybe inheritance?

    public void diplay(){
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Create connection");
        dialog.setHeaderText("Please enter your configuration details:");

        // Set the button types.
        ButtonType connectButtonType = new ButtonType("Connect", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(connectButtonType, ButtonType.CANCEL);

        // Create grid with the ip and port labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField ip = new TextField();
        TextField port = new TextField();

        grid.add(new Label("IP address:"), 0, 0);
        grid.add(ip, 1, 0);
        grid.add(new Label("Port number:"), 0, 1);
        grid.add(port, 1, 1);

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

        System.out.println(ip.getText());
        System.out.println(port.getText());
    }

    /*
     * Getters and setters:
     */

    // Set IP address
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    // Set port number
    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    // Get IP address
    public String getIpAddress() {
        return ipAddress;
    }

    // Get port number
    public Integer getPortNumber() {
        return portNumber;
    }
}
