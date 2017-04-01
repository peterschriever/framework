package Framework.Networking.Response;

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
        System.out.print("[networking] PlayerListResponse callback not implemented yet\n\tPlayers found: ");
        playerList.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }
}
