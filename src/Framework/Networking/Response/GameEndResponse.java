package Framework.Networking.Response;

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
        System.out.println("[networking] GameEndResponse callback not implemented yet");
        System.out.println("\tplayerOneScore: " + playerOneScore + ", playerTwoScore: " + playerTwoScore
                + ", comment: " + comment + ", result: " + result);
    }
}
