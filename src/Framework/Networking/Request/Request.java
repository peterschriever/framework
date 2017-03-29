package Framework.Networking.Request;

import Framework.Networking.Response;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public interface Request {
    Response execute() throws IOException, InterruptedException;
}
