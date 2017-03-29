package Framework.Networking.Request;

import Framework.Networking.Connection;
import Framework.Networking.Response;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class GetPlayerListRequest implements Request {
    private Connection conn;

    public GetPlayerListRequest(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        return conn.sendRequest("get playerlist");
    }
}
