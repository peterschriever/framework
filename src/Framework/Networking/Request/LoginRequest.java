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
public class LoginRequest implements Request {
    private String player;
    private Connection conn;

    public LoginRequest(Connection conn, String player) {
        this.conn = conn;
        this.player = player;
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(player);
        return conn.sendRequest("login", params);
    }
}
