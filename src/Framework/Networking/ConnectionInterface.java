package Framework.Networking;

import java.io.IOException;
import java.util.List;

/**
 * Created by peterzen on 2017-04-11.
 * Part of the framework project.
 */
public interface ConnectionInterface {

    void sendRequest(String request) throws IOException, InterruptedException;

    void sendRequest(String request, final List<String> params) throws IOException, InterruptedException;

    void setupInputObserver();

}
