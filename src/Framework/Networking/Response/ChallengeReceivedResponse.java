package Framework.Networking.Response;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class ChallengeReceivedResponse implements Response {
    private String challenger;
    private String gameType;
    private int challengeNumber;

    public ChallengeReceivedResponse(String challenger, String gameType, int challengeNumber) {
        this.challenger = challenger;
        this.gameType = gameType;
        this.challengeNumber = challengeNumber;
    }

    @Override
    public void executeCallback() {
        System.out.println("[networking] ChallengeReceivedResponse callback not implemented yet");
        System.out.println("\tchallenger: " + challenger + ", gameType: " + gameType
                + ", challengeNumber: " + challengeNumber);
    }
}
