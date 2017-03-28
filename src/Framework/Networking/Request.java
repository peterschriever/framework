package Framework.Networking;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public interface Request {
    public Response execute() throws IOException, InterruptedException;
}
