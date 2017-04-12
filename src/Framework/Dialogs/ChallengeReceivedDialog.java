package Framework.Dialogs;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;


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
        super.buttonType = ButtonType.YES;
        super.buttonType2 = ButtonType.NO;
        this.challengePlayerName = challengePlayerName;
        this.challengeNr = challengeNr;
    }

    public void display(){
        super.createDialog("Challenged by "+ getChallengePlayerName(), "Would you like to play against " + getChallengePlayerName());
        super.createGrid();
        this.createButtons();
        super.dialog.show();
        buttonClickCheck();
    }

    public void executeCallback() {
        eventHandler.challengeReceived(getChallengeNr());
    }

    public String getChallengePlayerName() {
        return challengePlayerName;
    }

    public int getChallengeNr() {
        return challengeNr;
    }
}
