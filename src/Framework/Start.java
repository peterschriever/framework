package Framework;

import Framework.GUI.BaseController;
import Framework.TempTTTGame.TTTGameStart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start extends Application {
    private static final Start frameworkStart = new Start();
    private Stage stage = null;
    private Scene scene = null;
    private String[] args;
    private TTTGameStart runningGame = null;

    public Start() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World from Framework.TTTGameStart");

        System.out.println(Config.get("game", "turnTimeout"));

        // start-up framework:
        frameworkStart.args = args;

        // we cannot make stage, this is created by the Application.launch(args)
        frameworkStart.initFrameworkStartScreen(frameworkStart.stage, frameworkStart.scene);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        initFrameworkStartScreen(this.stage, this.scene);
    }

    private void initFrameworkStartScreen(Stage stage, Scene scene) throws Exception {
        if (stage == null) {
            // javafx application not started
            launch(this.args);
            return;
        }

        // we have a javafx application already running @ stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Framework/GUI/fxml/View.fxml"));
        fxmlLoader.setController(new BaseController());
        Parent root = fxmlLoader.load();

        if (scene == null) {
            this.scene = new Scene(root);
        } else {
            scene.setRoot(root);
            this.scene = scene;
        }

        stage.setScene(this.scene);

        if (!stage.isShowing()) {
            stage.show();
        }
    }

    public static Start getInstance() {
        return frameworkStart;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setRunningGame(TTTGameStart runningGame) {
        this.runningGame = runningGame;
    }

    public TTTGameStart getRunningGame() {
        return runningGame;
    }
}
