package Framework.Networking;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class HelpRequest implements Request {
    private Connection conn;

    public HelpRequest(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        return conn.sendRequest("help \n");
    }
}
