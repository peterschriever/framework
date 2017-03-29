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
//        System.out.println("Hello World from Framework.Start");
//        System.out.println(Config.get("game", "turnTimeout"));

        String host = Config.get("network", "host");
        int port = Integer.parseInt(Config.get("network", "port"));

        // @TODO: idea: make response class so it is always listening and reading the inputStream
        // @TODO: and than parse results to concrete responses (like with the requests)
        // setup Response observer

        // setup receiver
        Connection conn = new Connection(host, port);

        // concrete command
        Request helpRequest = new HelpRequest(conn);

        // invoke command
        // @TODO: fix never-ending loop in execute
//        System.out.println(helpRequest.execute());

        // test help command with param
//        Request loginHelp = new HelpRequest(conn, "login");
//        System.out.println(loginHelp.execute());

        // test login command
//        Request loginRequest = new LoginRequest(conn, "");
//        System.out.println(loginRequest.execute());

        // test logout command (destroys connection)
//        Request logoutRequest = new LogoutRequest(conn);
//        System.out.println(logoutRequest.execute());

        // test get gamelist command
//        Request getGameListRequest = new GetGameListRequest(conn);
//        System.out.println(getGameListRequest.execute());

        // test get playerlist command
//        Request getPlayerListRequest = new GetPlayerListRequest(conn);
//        System.out.println(getPlayerListRequest.execute());

        // test subscribe command
        // @TODO: test when logged-in
//        Request subscribeRequest = new SubscribeRequest(conn, "Tic-Tac-Toe");
//        System.out.println(subscribeRequest.execute());

        // test move command
        // @TODO: test when logged-in
//        Request moveRequest = new MoveRequest(conn, 2);
//        System.out.println(moveRequest.execute());

        // test forfeit command
        // @TODO: test when logged-in and in-game
//        Request forfeitRequest = new ForfeitRequest(conn);
//        System.out.println(forfeitRequest.execute());

        // test challenge command
        // @TODO: test when logged-in and with 2 clients
//        Request challengeRequest = new ChallengeRequest(conn, "player", "gameType");
//        System.out.println(challengeRequest.execute());

        // test challenge accept command
        // @TODO: test when logged-in and with 2 clients
//        Request challengeAcceptRequest = new ChallengeAcceptRequest(conn, 1);
//        System.out.println(challengeAcceptRequest.execute());
    }

}
