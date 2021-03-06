package Framework.Networking.Request;

import Framework.Networking.Connection;
import Framework.Networking.ConnectionInterface;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class ChallengeAcceptRequest extends Request {
    private final ConnectionInterface conn;
    private final String challengeNr;

    public ChallengeAcceptRequest(ConnectionInterface conn, int challengeNr) {
        this.conn = conn;
        this.challengeNr = challengeNr+"";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(challengeNr);

        requestExecuted(this);
        conn.sendRequest("challenge accept", params);
    }
}
