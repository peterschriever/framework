package Framework.Networking.Request;

import Framework.Networking.Connection;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class HelpRequest extends Request {
    private Connection conn;
    private String forCommand = null;

    public HelpRequest(Connection conn) {
        this.conn = conn;
    }

    public HelpRequest(Connection conn, String forCommand) {
        this(conn);
        this.forCommand = forCommand;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        if (forCommand != null) {
            List<String> params = new LinkedList<>();
            params.add(forCommand);
            requestExecuted(this);
            conn.sendRequest("help", params);
        }

        requestExecuted(this);
        conn.sendRequest("help");
    }
}