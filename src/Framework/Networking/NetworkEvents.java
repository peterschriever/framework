package Framework.Networking;

import Framework.Networking.Response.ErrorResponse;
import Framework.Networking.Response.Response;

/**
 * Created by peterzen on 2017-04-06.
 * Part of the framework project.
 */
public interface NetworkEvents {

    void challengeCancelled(Response response);

    void challengeReceived(Response response);

    void ErrorReceived(Response response);

    void gameEnded(Response response);

    void gameListReceived(Response response);

    void matchReceived(Response response);

    void moveReceived(Response response);

    void ourTurn(Response response);

    void playerListReceived(Response response);

    void errorReceived(Response response);
}
