package Framework;

import Framework.GUI.Base;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start extends Application {
    private static final Start frameworkStart = new Start();
    private Stage stage = null;
    private Scene scene = null;
    private String[] args;

    public Start() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        frameworkStart.stage = stage;
        frameworkStart.initFrameworkStartScreen(stage, null);
    }

    public static void main(String[] args) throws Exception {
        // start-up framework:
        frameworkStart.args = args;

        // we cannot make stage, this is created by the Application.launch(args)
        frameworkStart.initFrameworkStartScreen(frameworkStart.stage, frameworkStart.scene);
    }

    private void initFrameworkStartScreen(Stage inStage, Scene inScene) throws Exception {
        if (inStage == null) {
            // javafx application not started
            launch(this.args);
            return;
        }

        // we have a javafx application already running @ stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Framework/GUI/fxml/View.fxml"));
        fxmlLoader.setController(new Base());
        Parent root = fxmlLoader.load();

        if (inScene == null) {
            this.scene = new Scene(root);
        } else {
            inScene.setRoot(root);
            this.scene = inScene;
        }

        inStage.setScene(this.scene);

        if (!inStage.isShowing()) {
            inStage.show();
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

    public void loadGameModule(String game) throws IOException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Runtime.getRuntime().exec("java -jar games/"+game+".jar");
//        URL url = new URL(path);
//        System.out.println("path: " + url.toString());
//        JarClassLoader loader = new JarClassLoader(url);
//        loader.invokeClass("GameStart", new String[]{"0"}, getStage(), getScene());
    }
}
