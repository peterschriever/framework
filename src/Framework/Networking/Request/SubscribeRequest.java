package Framework.Networking.Request;

import Framework.Networking.ConnectionInterface;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class SubscribeRequest extends Request {
    private final String gameType;
    private final ConnectionInterface conn;

    public SubscribeRequest(ConnectionInterface conn, String gameType) {
        this.conn = conn;
        this.gameType = gameType;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(gameType);

        requestExecuted(this);
        conn.sendRequest("subscribe", params);
    }
}
