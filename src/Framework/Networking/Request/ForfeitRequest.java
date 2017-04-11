package Framework.Networking.Request;

import Framework.Networking.ConnectionInterface;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class ForfeitRequest extends Request {
    private final ConnectionInterface conn;

    public ForfeitRequest(ConnectionInterface conn) {
        this.conn = conn;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        requestExecuted(this);
        conn.sendRequest("forfeit");
    }
}
