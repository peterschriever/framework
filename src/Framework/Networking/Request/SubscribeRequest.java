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
public class SubscribeRequest implements Request {
    private final String gameType;
    private final Connection conn;

    public SubscribeRequest(Connection conn, String gameType) {
        this.conn = conn;
        this.gameType = gameType;
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(gameType);

        return conn.sendRequest("subscribe", params);
    }
}
