package Framework;

import Framework.GUI.Base;
import Framework.Networking.Connection;
import Framework.Networking.NetworkEvents;
import Framework.Networking.Request.GetPlayerListRequest;
import Framework.Networking.Request.Request;
import Framework.Networking.Response.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start extends Application {
    private static final Start frameworkStart = new Start();
    private Stage stage = null;
    private Scene scene = null;
    private String[] args;

    public Start() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        frameworkStart.stage = stage;
        frameworkStart.initFrameworkStartScreen(stage, null);
    }

    public static void main(String[] args) throws Exception {
//        String host = Config.get("network", "host");
//        int port = Integer.parseInt(Config.get("network", "port"));
//
//        // setup receiver
//        Connection conn = new Connection(host, port, new NetworkEvents() {
//            @Override
//            public void challengeCancelled(ChallengeCancelledResponse response) {
//
//            }
//
//            @Override
//            public void challengeReceived(ChallengeReceivedResponse response) {
//
//            }
//
//            @Override
//            public void gameEnded(GameEndResponse response) {
//
//            }
//
//            @Override
//            public void gameListReceived(GameListResponse response) {
//
//            }
//
//            @Override
//            public void matchReceived(MatchReceivedResponse response) {
//
//            }
//
//            @Override
//            public void moveReceived(MoveResponse response) {
//
//            }
//
//            @Override
//            public void ourTurn(OurTurnResponse response) {
//
//            }
//
//            @Override
//            public void playerListReceived(PlayerListResponse response) {
//                response.getPlayerList().forEach(System.out::println);
//                System.out.println("players received");
//            }
//
//            @Override
//            public void errorReceived(ErrorResponse response) {
//
//            }
//        });

        // setup Response observer
//        conn.setupInputObserver();

        // concrete command(s) and their invocation(s):

        // test login command
//        Request loginRequest = new LoginRequest(conn, "player");
//        loginRequest.execute();

        // test logout command (destroys connection)
//        Request logoutRequest = new LogoutRequest(conn);
//        logoutRequest.execute();

        // test get gamelist command
//        Request getGameListRequest = new GetGameListRequest(conn);
//        getGameListRequest.execute();

        // test get playerlist command
//        Request getPlayerListRequest = new GetPlayerListRequest(conn);
//        getPlayerListRequest.execute();

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

//        // start-up framework:
//        frameworkStart.args = args;
//
//        // we cannot make stage, this is created by the Application.launch(args)
//        frameworkStart.initFrameworkStartScreen(frameworkStart.stage, frameworkStart.scene);
    }

    private void initFrameworkStartScreen(Stage inStage, Scene inScene) throws Exception {
        if (inStage == null) {
            // javafx application not started
            launch(this.args);
            return;
        }

        // we have a javafx application already running @ stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Framework/GUI/fxml/View.fxml"));
        fxmlLoader.setController(new Base());
        Parent root = fxmlLoader.load();

        if (inScene == null) {
            this.scene = new Scene(root);
        } else {
            inScene.setRoot(root);
            this.scene = inScene;
        }

        inStage.setScene(this.scene);

        if (!inStage.isShowing()) {
            inStage.show();
        }
    }

    public static Start getInstance() {
        return frameworkStart;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void loadGameModule(String game) throws IOException {
        Runtime.getRuntime().exec("java -jar games/"+game+".jar");
    }
}
