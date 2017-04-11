package Framework.Dialogs;

import javafx.application.Platform;
import javafx.scene.control.*;

/**
 * Class UserNameDialog
 *
 * @author Ruben Buisman
 * @version 0.2 (28-03-2017)
 */
public class UserNameDialog extends AbstractDialog implements DialogInterface {

    private String userName;
    private TextField playerName;

    public UserNameDialog(DialogEvents eventHandler) {
        super(eventHandler);
    }

    public void display() {
        super.createDialog("Create username", "Please enter your username:");
        super.createGrid();
        this.addTextFields();
        this.createButtons("Create", playerName);

        // If closed, set the fields and execute callback.
        super.dialog.showAndWait();
        this.setUserName(playerName.getText());
        this.executeCallback();
    }

    public void addTextFields() {
        this.playerName = new TextField();
        super.grid.add(playerName, 0, 0);
        Platform.runLater(playerName::requestFocus);
    }

    private void executeCallback() {
        // @TODO: implement callback
        eventHandler.attemptLogin(getUserName());
        System.out.println("Callback: " + getUserName());
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


