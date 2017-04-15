package Framework.Networking.InputObserver;

import Framework.Networking.Request.Request;
import Framework.Networking.Response.*;

import java.util.*;

/**
 * Created by peterzen on 2017-03-29.
 * Part of the framework project.
 */
public class InputStreamObserver implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        if (!(observable instanceof InputStreamReader)) {
            return; // only observe InputStreamReader
        }
        if (!(o instanceof String)) {
            return;
        }

        String responseString = ((String) o);

//        System.out.println("InputStreamObserver notified: " + responseString);
        Response response = parseResponse(responseString);
        // HACK: slow down the responses so that the application has appropriate time to update
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response != null) {
            response.executeCallback();
        }
    }

    private Response parseResponse(String responseString) {
        // to prevent malicious player input, test only the start of a response:
        int endOfTest = responseString.length() >= 14 ? 14 : responseString.length();
        String testSubString = responseString.substring(0, endOfTest);
        Scanner scanner = new Scanner(testSubString);

        if (scanner.findInLine("ERR") != null) {
            return new ErrorResponse(Request.getLastRequest());
        }

        if (scanner.findInLine("SVR HELP") != null) {
            return null;
        }

        if (scanner.findInLine("SVR GAMELIST") != null) {
            List<String> gameList = ResponsePatterns.getListItems(responseString);
            return new GameListResponse(gameList);
        }

        if (scanner.findInLine("SVR PLAYERLIST") != null) {
            List<String> playerList = ResponsePatterns.getListItems(responseString);
            return new PlayerListResponse(playerList);
        }

        if (scanner.findInLine("SVR GAME") != null) {
            return parseGameResponse(responseString);
        }

        return null;
    }

    private Response parseGameResponse(String responseString) {
        // to prevent malicious player input, test only the start of a response:
        int endOfTest = responseString.length() >= 18 ? 18 : responseString.length();
        String testSubString = responseString.substring(7, endOfTest);
        Scanner scanner = new Scanner(testSubString);

        if (scanner.findInLine("YOURTURN") != null) {
            String turnMessage = ResponsePatterns.getTurnMessage(responseString);
            return new OurTurnResponse(turnMessage);
        }

        if (scanner.findInLine("MOVE") != null) {
            String movingPlayer = ResponsePatterns.getPlayer(responseString);
            String moveDetails = ResponsePatterns.getDetails(responseString);
            int movePosition = ResponsePatterns.getMove(responseString);
            return new MoveResponse(movingPlayer, moveDetails, movePosition);
        }

        if (scanner.findInLine("MATCH") != null) {
            String gameType = ResponsePatterns.getGameType(responseString);
            String startingPlayer = ResponsePatterns.getPlayerToMove(responseString);
            String opponentPlayer = ResponsePatterns.getOpponent(responseString);
            return new MatchReceivedResponse(gameType, startingPlayer, opponentPlayer);
        }

        if (scanner.findInLine("CHALLENGE") != null) {
            return parseGameChallengeResponse(responseString);
        }

        // only responses left are WIN/LOSS/DRAW
        return parseEndGameResponse(responseString, scanner);
    }

    private Response parseEndGameResponse(String responseString, Scanner scanner) {
        // @TODO: actually figure out: how do we know who is player1/player2?
        int playerOneScore = ResponsePatterns.getPlayerOneScore(responseString);
        int playerTwoScore = ResponsePatterns.getPlayerTwoScore(responseString);
        String comment = ResponsePatterns.getComment(responseString);
        String result = null;
        if (scanner.findInLine("WIN") != null) {
            result = "WIN";
        }
        if (scanner.findInLine("LOSS") != null) {
            result = "LOSS";
        }
        if (scanner.findInLine("DRAW") != null) {
            result = "DRAW";
        }
        if (result != null) {
            return new GameEndResponse(playerOneScore, playerTwoScore, comment, result);
        }
        return null;
    }

    private Response parseGameChallengeResponse(String responseString) {
        // to prevent malicious player input, test only the start of a response:
        int endOfTest = responseString.length() >= 28 ? 28 : responseString.length();
        String testSubString = responseString.substring(0, endOfTest);
        Scanner scanner = new Scanner(testSubString);

        if (scanner.findInLine("CANCELLED") != null) {
            int challengeNumber = ResponsePatterns.getChallengeNr(responseString);
            return new ChallengeCancelledResponse(challengeNumber);
        }

        String challenger = ResponsePatterns.getChallenger(responseString);
        String gameType = ResponsePatterns.getGameType(responseString);
        int challengeNumber = ResponsePatterns.getChallengeNr(responseString);

        return new ChallengeReceivedResponse(challenger, gameType, challengeNumber);
    }


}
