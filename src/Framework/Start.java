package Framework;

import Framework.Networking.Connection;
import Framework.Networking.HelpRequest;
import Framework.Networking.Request;
import Framework.Networking.Response;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start {

    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println("Hello World from Framework.Start");
//        System.out.println(Config.get("game", "turnTimeout"));

        String host = Config.get("network", "host");
        int port = Integer.parseInt(Config.get("network", "port"));

        // setup receiver
        Connection conn = new Connection(host, port);

        // concrete command
        Request helpRequest = new HelpRequest(conn);

        // invoke command
        Response serverResponse = helpRequest.execute();

        System.out.println(serverResponse.toString());
    }

}
