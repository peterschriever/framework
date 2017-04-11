package Framework.Dialogs;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 * Created by Ruben on 11-Apr-17.
 */
public class challengeReceivedDialog extends AbstractDialog implements DialogInterface {

    private String challengePlayerName;

    public challengeReceivedDialog(DialogEvents eventHandler, String challengePlayerName) {
        super(eventHandler);
        this.challengePlayerName = challengePlayerName;
    }

    public void display(){
        super.createDialog("Challenge received", "You are challenged by " + getChallengePlayerName() +"!");
        super.createGrid();
        this.createButtons("Accept");
    }

    private void createButtons(String buttonText) {
        ButtonType button = new ButtonType(buttonText, ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(button, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(grid);
    }

    private void executeCallback() {
        // eventHandler.challengeReceived();
    }

    public String getChallengePlayerName() {
        return challengePlayerName;
    }
}
