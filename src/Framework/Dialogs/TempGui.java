package Framework.Dialogs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Class TempGui
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class TempGui extends Application {

    private UserNameDialog userDialog;
    private ConnectionDialog connectionDialog;
    private ErrorDialog errorDialog;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create username dialog
        userDialog = new UserNameDialog();
        connectionDialog = new ConnectionDialog();
        errorDialog = new ErrorDialog();

        primaryStage.setTitle("Temp gui for testing");

        // Buttons
        Button btn = new Button("Username dialog");
        Button btn1 = new Button("Connection dialog");
        Button btn2 = new Button("Error dialog");
        btn.setOnAction(e -> btnClickName());
        btn1.setOnAction(e -> btnClickConnection());
        btn2.setOnAction(e -> btnClickError());

        BorderPane sp = new BorderPane();
        sp.setLeft(btn);
        sp.setBottom(btn2);
        sp.setRight(btn1);

        Scene scene = new Scene(sp, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void btnClickConnection(){
        connectionDialog.display();
    }

    private void btnClickName(){
        userDialog.display();
    }

    private void btnClickError(){
        errorDialog.display("Wooops!", "Invalid username (test content)");
    }


}
