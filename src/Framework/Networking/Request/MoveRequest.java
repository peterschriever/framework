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
public class MoveRequest implements Request {
    private final String position;
    private final Connection conn;

    public MoveRequest(Connection conn, int position) {
        this.conn = conn;
        this.position = position+"";
    }

    @Override
    public Response execute() throws IOException, InterruptedException {
        List<String> params = new LinkedList<>();
        params.add(position);

        return conn.sendRequest("move", params);
    }
}
