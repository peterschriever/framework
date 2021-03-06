package Framework.Dialogs;

import javafx.application.Platform;
import javafx.scene.control.*;

/**
 * Class ConnectionDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class ConnectionDialog extends AbstractDialog implements DialogInterface {

    private String ipAddress;
    private String portNumber;
    private TextField ip;
    private TextField port;

    public ConnectionDialog(DialogEvents eventHandler) {
        super(eventHandler);
    }

    public void display() {
        super.createDialog("Create server connection", "Please enter your configuration details:");
        super.createGrid();
        this.addTextFields();
        super.createButtons();
        super.dialog.show();
        super.buttonClickCheck();
    }

    private void addTextFields() {
        this.ip = new TextField();
        this.port = new TextField();
        super.grid.add(new Label("IP address:"), 0, 0);
        super.grid.add(ip, 1, 0);
        super.grid.add(new Label("Port number:"), 0, 1);
        super.grid.add(port, 1, 1);
        Platform.runLater(ip::requestFocus);
    }

    public void executeCallback() {
        this.setFields();
        eventHandler.setupConnection(getIpAddress(), getPortNumber());
    }

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
