package Framework.Networking.Request;

import Framework.Networking.ConnectionInterface;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class LoginRequest extends Request {
    private String player;
    private ConnectionInterface conn;

    public LoginRequest(ConnectionInterface conn, String player) {
        this.conn = conn;
        this.player = player;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(player);
        requestExecuted(this);
        conn.sendRequest("login", params);
    }

    public String getPlayer() {
        return player;
    }
}
