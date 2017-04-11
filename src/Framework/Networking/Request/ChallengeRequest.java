package Framework.Networking.Request;

import Framework.Networking.ConnectionInterface;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class ChallengeRequest extends Request {
    private final ConnectionInterface conn;
    private final String player;

    public String getPlayer() {
        return player;
    }

    public String getGameType() {
        return gameType;
    }

    private final String gameType;

    public ChallengeRequest(ConnectionInterface conn, String player, String gameType) {
        this.conn = conn;
        this.player = player;
        this.gameType = gameType;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add('"' + player + '"');
        params.add('"' + gameType + '"');

        requestExecuted(this);
        conn.sendRequest("challenge", params);
    }
}
