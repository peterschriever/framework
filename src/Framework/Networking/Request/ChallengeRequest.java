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
public class ChallengeRequest implements Request {
    private final Connection conn;
    private final String player;
    private final String gameType;

    public ChallengeRequest(Connection conn, String player, String gameType) {
        this.conn = conn;
        this.player = player;
        this.gameType = gameType;
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(player);
        params.add(gameType);

        return conn.sendRequest("move", params);
    }
}
