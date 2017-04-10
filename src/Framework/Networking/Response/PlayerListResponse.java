package Framework.Networking.Response;

import Framework.Networking.Connection;

import java.util.List;

/**
 * Created by peterzen on 2017-03-31.
 * Part of the framework project.
 */
public class PlayerListResponse implements Response {
    private final List<String> playerList;

    public PlayerListResponse(List<String> playerList) {
        this.playerList = playerList;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().playerListReceived(this);
    }

    public List<String> getPlayerList() {
        return this.playerList;
    }
}
