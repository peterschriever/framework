package Framework.Networking.Request;

import Framework.Networking.Connection;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class LogoutRequest extends Request {
    private Connection conn;

    public LogoutRequest(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        requestExecuted(this);
        conn.sendRequest("logout");
    }
}