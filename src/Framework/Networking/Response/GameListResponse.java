package Framework.Networking.Response;

import Framework.Networking.Connection;

import java.util.List;

/**
 * Created by peterzen on 2017-03-30.
 * Part of the framework project.
 */
public class GameListResponse implements Response {
    private final List<String> gameList;

    public GameListResponse(List<String> gameList) {
        this.gameList = gameList;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().gameListReceived(this);
    }

    public List<String> getGameList() {
        return this.gameList;
    }
}
