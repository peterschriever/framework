package Framework.Networking;

import Framework.Networking.Response.*;

/**
 * Created by peterzen on 2017-04-06.
 * Part of the framework project.
 */
public interface NetworkEvents {

    void challengeCancelled(ChallengeCancelledResponse response);

    void challengeReceived(ChallengeReceivedResponse response);

    void gameEnded(GameEndResponse response);

    void gameListReceived(GameListResponse response);

    void matchReceived(MatchReceivedResponse response);

    void moveReceived(MoveResponse response);

    void ourTurn(OurTurnResponse response);

    void playerListReceived(PlayerListResponse response);

    void errorReceived(ErrorResponse response);
}
