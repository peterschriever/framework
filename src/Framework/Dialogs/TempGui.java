package Framework.Dialogs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Created by Ruben on 28-Mar-17.
 */
public class TempGui extends Application {

    public UserNameDialog userDialog;
    public ConnectionDialog connectionDialog;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create username dialog
        userDialog = new UserNameDialog();
        connectionDialog = new ConnectionDialog();

        primaryStage.setTitle("Temp gui for testing");

        // Button
        Button btn = new Button("Test button");
        btn.setOnAction(e -> btn_click());

        StackPane sp = new StackPane();
        sp.getChildren().add(btn);

        Scene scene = new Scene(sp, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void btn_click(){
        //userDialog.diplay();
        connectionDialog.diplay();
    }

}
