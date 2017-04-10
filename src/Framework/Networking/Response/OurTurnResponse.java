package Framework.Networking.Response;

import Framework.Networking.Connection;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class OurTurnResponse implements Response {
    private final String turnMessage;

    public OurTurnResponse(String turnMessage) {
        this.turnMessage = turnMessage;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().ourTurn(this);
    }

    public String getTurnMessage() {
        return this.turnMessage;
    }
}
