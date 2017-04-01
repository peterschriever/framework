package Framework.Networking.Response;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class ChallengeCancelledResponse implements Response {
    private final int challengeNumber;

    public ChallengeCancelledResponse(int challengeNumber) {
        this.challengeNumber = challengeNumber;
    }

    @Override
    public void executeCallback() {
        System.out.println("[networking] ChallengeCancelledResponse callback not implemented yet");
        System.out.println("\tchallengeNumber: " + challengeNumber);
    }
}
