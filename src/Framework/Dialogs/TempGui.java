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
    private MessageDialog messageDialog;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create username dialog
        userDialog = new UserNameDialog();
        connectionDialog = new ConnectionDialog();
        errorDialog = new ErrorDialog();
        messageDialog = new MessageDialog();

        primaryStage.setTitle("Temp gui for testing");

        // Buttons
        Button btn = new Button("Username dialog");
        Button btn1 = new Button("Connection dialog");
        Button btn2 = new Button("Error dialog");
        Button btn3 = new Button("Message dialog");
        btn.setOnAction(e -> btnClickName());
        btn1.setOnAction(e -> btnClickConnection());
        btn2.setOnAction(e -> btnClickError());
        btn3.setOnAction(e -> btnClickMessage());

        BorderPane sp = new BorderPane();
        sp.setTop(btn);
        sp.setRight(btn1);
        sp.setCenter(btn2);
        sp.setBottom(btn3);

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

    private void btnClickMessage() {
        messageDialog.display("Message dialog", "Standard message dialog", "I have a great message for you!");
    }

}
