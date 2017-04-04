package Framework.Networking.Response;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public final class ResponsePatterns {
    private static final Pattern challengeNrPattern = Pattern.compile("CHALLENGENUMBER: \"(\\d+)\"");
    // @TODO: getting names still doesn't work when a Player takes a name with a ',' (e.g. asd,asd)
    private static final Pattern listItemsPattern = Pattern.compile("(?<=\")([^,]+)+(?=\")");
    private static final Pattern challengerPattern = Pattern.compile("CHALLENGER: \"([^,]+)\"");
    private static final Pattern gameTypePattern = Pattern.compile("GAMETYPE: \"([^,]+)\"");
    private static final Pattern playerToMovePattern = Pattern.compile("PLAYERTOMOVE: \"([^,]+)\"");
    private static final Pattern getOpponentPattern = Pattern.compile("OPPONENT: \"([^,]+)\"");
    private static final Pattern getTurnMessagePattern = Pattern.compile("TURNMESSAGE: \"([^\"]+)\"");
    private static final Pattern getPlayerPattern = Pattern.compile("PLAYER: \"([^,]+)\"");
    // @TODO: check if none of the details messages use a comma..
    private static final Pattern getDetailsPattern = Pattern.compile("DETAILS: \"([^,]+)\"");
    private static final Pattern getMovePattern = Pattern.compile("MOVE: \"(\\d+)\"");
    private static final Pattern getCommentPattern = Pattern.compile("COMMENT: \"([^,]+)\"");
    private static final Pattern getPlayerOneScorePattern = Pattern.compile("PLAYERONESCORE: \"(\\d+)\"");
    private static final Pattern getPlayerTwoScorePattern = Pattern.compile("PLAYERTWOSCORE: \"(\\d+)\"");

    private ResponsePatterns() {
    }

    public static int getChallengeNr(String responseString) {
        Matcher m = challengeNrPattern.matcher(responseString);
        if (m.find(1)) {
            return Integer.parseInt(m.group(1));
        }
        return 0;
    }

    public static ArrayList<String> getListItems(String responseString) {
        ArrayList<String> list = new ArrayList<>();
        Matcher matcher = listItemsPattern.matcher(responseString);
        if (matcher.groupCount() > 0) {
            int matchIndex = 0;
            while (matcher.find()) {
                list.add(matcher.group(matchIndex));
                matchIndex++;
            }
        }
        return list;
    }

    public static String getChallenger(String responseString) {
        Matcher m = challengerPattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getGameType(String responseString) {
        Matcher m = gameTypePattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getPlayerToMove(String responseString) {
        Matcher m = playerToMovePattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getOpponent(String responseString) {
        Matcher m = getOpponentPattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getTurnMessage(String responseString) {
        Matcher m = getTurnMessagePattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getPlayer(String responseString) {
        Matcher m = getPlayerPattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static String getDetails(String responseString) {
        Matcher m = getDetailsPattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static int getMove(String responseString) {
        Matcher m = getMovePattern.matcher(responseString);
        if (m.find(1)) {
            return Integer.parseInt(m.group(1));
        }
        return -1;
    }

    public static String getComment(String responseString) {
        Matcher m = getCommentPattern.matcher(responseString);
        if (m.find(1)) {
            return m.group(1);
        }
        return null;
    }

    public static int getPlayerOneScore(String responseString) {
        Matcher m = getPlayerOneScorePattern.matcher(responseString);
        if (m.find(1)) {
            return Integer.parseInt(m.group(1));
        }
        return 0;
    }

    public static int getPlayerTwoScore(String responseString) {
        Matcher m = getPlayerTwoScorePattern.matcher(responseString);
        if (m.find(1)) {
            return Integer.parseInt(m.group(1));
        }
        return 0;
    }
}
