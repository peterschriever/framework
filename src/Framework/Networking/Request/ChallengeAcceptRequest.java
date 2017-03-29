package Framework.Networking.Request;

import Framework.Networking.Connection;
import Framework.Networking.Response;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class ChallengeAcceptRequest implements Request {
    private final Connection conn;
    private final String challengeNr;

    public ChallengeAcceptRequest(Connection conn, int challengeNr) {
        this.conn = conn;
        this.challengeNr = challengeNr+"";
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(challengeNr);

        return conn.sendRequest("move", params);
    }
}
