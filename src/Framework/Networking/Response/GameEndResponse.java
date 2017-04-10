package Framework.Networking.Response;

import Framework.Networking.Connection;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class GameEndResponse implements Response {
    private final int playerOneScore;
    private final int playerTwoScore;
    private final String comment;
    private final String result;

    public GameEndResponse(int playerOneScore, int playerTwoScore, String comment, String result) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.comment = comment;
        this.result = result;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().gameEnded(this);
    }

    public int getPlayerOneScore() {
        return this.playerOneScore;
    }

    public int getPlayerTwoScore() {
        return this.playerTwoScore;
    }

    public String getComment() {
        return this.comment;
    }

    public String getResult() {
        return this.result;
    }
}
