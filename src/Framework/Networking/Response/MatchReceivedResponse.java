package Framework.Networking.Response;

import Framework.Networking.Connection;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class MatchReceivedResponse implements Response {
    private final String gameType;
    private final String startingPlayer;
    private final String opponentPlayer;

    public MatchReceivedResponse(String gameType, String startingPlayer, String opponentPlayer) {
        this.gameType = gameType;
        this.startingPlayer = startingPlayer;
        this.opponentPlayer = opponentPlayer;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().matchReceived(this);
    }

    public String getGameType() {
        return this.startingPlayer;
    }

    public String getStartingPlayer() {
        return this.startingPlayer;
    }

    public String getOpponentPlayer() {
        return this.opponentPlayer;
    }
}
