package Framework.Networking;

import Framework.AI.BotInterface;
import Framework.Config;
import Framework.Game.GameLogicInterface;
import Framework.Networking.Request.*;
import Framework.Networking.Response.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by peterzen on 2017-04-11.
 * Part of the framework project.
 */
public class SimulatedConnection implements ConnectionInterface {
    private static NetworkEvents eventHandler;
    private final BotInterface AI;
    private boolean sendResponses = false;

    private String gameType;
    private String loggedInPlayer;
    private GameLogicInterface gameLogic;
    private static int boardSize;

    public SimulatedConnection(String gameType, GameLogicInterface gameLogic, BotInterface AI, NetworkEvents eventHandler) throws IOException {
        System.out.println("[networking] Simulated connection started");
        this.gameType = gameType;
        this.AI = AI;
        this.gameLogic = gameLogic;
        this.boardSize = Integer.parseInt(Config.get("game", gameType + "-boardSize"));
        SimulatedConnection.eventHandler = eventHandler;
    }

    public static NetworkEvents getEventHandler() {
        return SimulatedConnection.eventHandler;
    }

    private void generateResponse() {
        // The request, as send by the player
        Request lastRequest = Request.getLastRequest();

        Response response = null;
        if (lastRequest instanceof ChallengeRequest) {
            if (loggedInPlayer == null) {
                Response errResponse = new ErrorResponse(lastRequest);
            }

            // because we always accept: send matchReceived response
            String botPlayer = ((ChallengeRequest) lastRequest).getPlayer();
            Random r = new Random();
            String starting = botPlayer;
            if (r.nextInt(100 - 10) > 50) {
                starting = loggedInPlayer;
            }

            response = new MatchReceivedResponse(gameType, starting, "bot");
        } else if (lastRequest instanceof ForfeitRequest) {
            response = new ErrorResponse(lastRequest); // @TODO: Request is not supported by SimulatedConnection
        } else if (lastRequest instanceof GetGameListRequest) {
            List<String> list = new LinkedList<String>();
            list.add("Tic-tac-toe");
            list.add("Othello");
            response = new GameListResponse(list);
        } else if (lastRequest instanceof GetPlayerListRequest) {
            List<String> list = new LinkedList<String>();
            list.add("bot");
            if (loggedInPlayer != null) {
                list.add(loggedInPlayer);
            }
            response = new PlayerListResponse(list);
        } else if (lastRequest instanceof HelpRequest) {
            response = new ErrorResponse(lastRequest); // @TODO: Request is not supported by SimulatedConnection
        } else if (lastRequest instanceof LoginRequest) {
            if (loggedInPlayer != null) {
                Response errResponse = new ErrorResponse(lastRequest);
            }

            loggedInPlayer = ((LoginRequest) lastRequest).getPlayer();
            // do not send response when login is accepted, OKs are ignored normally anyway
            return;
        } else if (lastRequest instanceof LogoutRequest) {
            response = new ErrorResponse(lastRequest); // @TODO: Request is not supported by SimulatedConnection
        } else if (lastRequest instanceof MoveRequest) {
            int[] move = AI.doTurn(gameLogic.getBoard());
            int pos = move[0] * boardSize + move[1];
            response = new MoveResponse("bot", "bot move", pos);
        } else if (lastRequest instanceof SubscribeRequest) {
            response = new ErrorResponse(lastRequest); // @TODO: Request is not supported by SimulatedConnection
        }

        if (response != null) {
            response.executeCallback();
        }
    }

    @Override
    public void sendRequest(String request) throws IOException, InterruptedException {
        generateResponse();
    }

    @Override
    public void sendRequest(String request, List<String> params) throws IOException, InterruptedException {
        generateResponse();
    }

    @Override
    public void setupInputObserver() {
        System.out.println("[networking] Simulated Connection input observer called, start sending responses");
        sendResponses = true;
    }
}
