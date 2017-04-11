package Framework.AI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterzen on 2017-04-11.
 * Part of the framework project.
 */
public interface BotInterface {

    public char getPlayer();

    public int[] doTurn(char[][] board);

}
