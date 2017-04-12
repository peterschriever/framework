package Framework.Dialogs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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
        super.createButtons();
        this.addTextFields();
        super.dialog.show();
        this.setUserName(playerName.getText());
        super.buttonClickCheck();
    }

    private void addTextFields() {
        this.playerName = new TextField();
        super.grid.add(playerName, 0, 0);
        Platform.runLater(playerName::requestFocus);
    }

    public void buttonClickCheck() {
        super.buttonClickCheck();
    }

    public void executeCallback() {
        this.setUserName(playerName.getText());
        eventHandler.attemptLogin(getUserName());
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


