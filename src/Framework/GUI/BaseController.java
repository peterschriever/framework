package Framework.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by peterzen on 2017-04-03.
 * Part of the framework project.
 */
public class BaseController {
    @FXML
    private VBox container;

    public void initialize() {
        try {
            loadPartialViews();
        } catch (IOException e) {
            e.printStackTrace(); // @TODO: figure out how to handle this exception
        }
    }

    private void loadPartialViews() throws IOException {
        container.getChildren().add(FXMLLoader.load(getClass().getResource("/Framework/GUI/fxml/MenuView.fxml")));
        container.getChildren().add(FXMLLoader.load(getClass().getResource("/Framework/GUI/fxml/BoardView.fxml")));
    }


}
