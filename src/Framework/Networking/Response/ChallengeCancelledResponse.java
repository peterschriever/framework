package Framework.Networking.Response;

import Framework.Networking.Connection;

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
        Connection.getEventHandler().challengeCancelled(this);
    }
}
