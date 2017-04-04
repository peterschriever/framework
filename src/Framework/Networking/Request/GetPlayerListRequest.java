package Framework.Networking.Request;

import Framework.Networking.Connection;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class GetPlayerListRequest extends Request {
    private Connection conn;

    public GetPlayerListRequest(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        requestExecuted(this);
        conn.sendRequest("get playerlist");
    }
}
