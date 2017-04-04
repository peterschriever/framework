package Framework.Networking.Response;

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
        System.out.println("[networking] MatchReceivedResponse callback not implemented yet");
        System.out.println("\t gameType:" + gameType + ", startingPlayer: " + startingPlayer
                + ", opponentPlayer: " + opponentPlayer);
    }
}
