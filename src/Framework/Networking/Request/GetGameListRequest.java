package Framework.Networking.Request;

import Framework.Networking.ConnectionInterface;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class GetGameListRequest extends Request {
    private ConnectionInterface conn;

    public GetGameListRequest(ConnectionInterface conn) {
        this.conn = conn;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        requestExecuted(this);
        conn.sendRequest("get gamelist");
    }
}
