package Framework.Networking.Response;

import Framework.Networking.Connection;

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
        Connection.getEventHandler().challengeReceived(this);
    }

    public String getChallenger() {
        return this.challenger;
    }

    public String getGameType() {
        return this.gameType;
    }

    public int getChallengeNumber() {
        return this.challengeNumber;
    }
}
