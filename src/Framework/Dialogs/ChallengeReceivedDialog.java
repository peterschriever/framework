package Framework.Dialogs;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Class ChallengeReceivedDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (11-04-2017)
 */
public class ChallengeReceivedDialog extends AbstractDialog implements DialogInterface {

    private String challengePlayerName;
    private int challengeNr;


    public ChallengeReceivedDialog(DialogEvents eventHandler, String challengePlayerName, int challengeNr) {
        super(eventHandler);
        this.challengePlayerName = challengePlayerName;
        this.challengeNr = challengeNr;
    }

    public void display(){
        super.createDialog("Challenged by "+ getChallengePlayerName(), "Would you like to play against " + getChallengePlayerName());
        super.createGrid();
        this.createButtons();
        super.dialog.show();

        // Check for OK button pressed
        final Button accept = (Button) dialog.getDialogPane().lookupButton(ButtonType.YES);
        accept.addEventFilter(ActionEvent.ACTION, event ->
                executeCallback()
        );
    }

    private void createButtons() {
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        dialog.getDialogPane().setContent(grid);
    }

    private void executeCallback() {
        eventHandler.challengeReceived(getChallengeNr());
    }

    public String getChallengePlayerName() {
        return challengePlayerName;
    }

    public int getChallengeNr() {
        return challengeNr;
    }
}
