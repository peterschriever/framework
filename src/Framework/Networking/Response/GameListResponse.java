package Framework.Networking.Response;

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
        // @TODO: implement callback
        System.out.print("[networking] GameListResponse callback not implemented yet\n\tGames found: ");
        gameList.forEach(g -> System.out.print(g + " "));
        System.out.println();
    }
}
