package Framework.Networking;

import Framework.Networking.Response.Response;

/**
 * Created by peterzen on 2017-04-06.
 * Part of the framework project.
 */
public interface NetworkEventsController {

    void challengeCancelled(Response response);

    void challengeReceived(Response response);

    void ErrorReceived(Response response);

    void gameEnded(Response response);

    void gameListReceived(Response response);

    void matchReceived(Response response);

    void moveReceived(Response response);

    void ourTurn(Response response);

    void playerListReceived(Response response);

}
