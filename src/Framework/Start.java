package Framework;

import Framework.Networking.Connection;
import Framework.Networking.Request.*;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start {

    public static void main(String[] args) throws IOException, InterruptedException {
        String host = Config.get("network", "host");
        int port = Integer.parseInt(Config.get("network", "port"));

        // setup receiver
        Connection conn = new Connection(host, port);

        // setup Response observer
        conn.setupInputObserver();

        // concrete command(s) and their invocation(s):

        // test login command
        Request loginRequest = new LoginRequest(conn, "player");
        loginRequest.execute();

        // test logout command (destroys connection)
//        Request logoutRequest = new LogoutRequest(conn);
//        logoutRequest.execute();

        // test get gamelist command
        Request getGameListRequest = new GetGameListRequest(conn);
        getGameListRequest.execute();

        // test get playerlist command
        Request getPlayerListRequest = new GetPlayerListRequest(conn);
        getPlayerListRequest.execute();

        // test subscribe command
//        Request subscribeRequest = new SubscribeRequest(conn, "Tic-tac-toe");
//        subscribeRequest.execute();

        // test move command
//        Request moveRequest = new MoveRequest(conn, 2);
//        moveRequest.execute();

        // test forfeit command
//        Request forfeitRequest = new ForfeitRequest(conn);
//        forfeitRequest.execute();

        // test challenge command
//        Request challengeRequest = new ChallengeRequest(conn, "telnet", "Tic-tac-toe");
//        challengeRequest.execute();

        // test challenge accept command
//        Request challengeAcceptRequest = new ChallengeAcceptRequest(conn, 1);
//        challengeAcceptRequest.execute();
    }

}
