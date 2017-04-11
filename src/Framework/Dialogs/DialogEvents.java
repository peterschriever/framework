package Framework.Dialogs;

/**
 * Created by peterzen on 2017-04-11.
 * Part of the framework project.
 */
public interface DialogEvents {

    void attemptLogin(String userName);

    void challengeReceived(int challengeNr);

}