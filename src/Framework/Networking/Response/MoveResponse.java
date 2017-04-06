package Framework.Networking.Response;

import Framework.Networking.Connection;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class MoveResponse implements Response {
    private final String movingPlayer;
    private final String moveDetails;
    private final int movePosition;

    public MoveResponse(String movingPlayer, String moveDetails, int movePosition) {
        this.movingPlayer = movingPlayer;
        this.moveDetails = moveDetails;
        this.movePosition = movePosition;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().moveReceived(this);
    }
}
