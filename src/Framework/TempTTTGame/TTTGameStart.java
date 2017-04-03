package Framework.TempTTTGame;

import Framework.GameStart;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by peterzen on 2017-04-03.
 * Part of the framework project.
 */
public class TTTGameStart implements GameStart {
    private final Scene scene;
    private final Stage stage;

    public TTTGameStart(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    @Override
    public void start() {
        System.out.println("TTTGameStart.start was called!");
    }
}
