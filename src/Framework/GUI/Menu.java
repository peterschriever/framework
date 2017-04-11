package Framework.GUI;

import Framework.Dialogs.ConnectionDialog;
import Framework.Dialogs.DialogEvents;
import Framework.Dialogs.DialogInterface;
import Framework.Start;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

/**
 * Created by femkeh on 03/04/17.
 */
public class Menu {
    @FXML
    private MenuItem newTTT;

    public void newTTTGame(ActionEvent actionEvent) {
        try {
            Start.getInstance().loadGameModule("jar:file:games/tictactoe.jar!/");
        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IOException e) {
            e.printStackTrace(); // @TODO: maybe show a dialog
        }
    }

    public void newOthGame(ActionEvent actionEvent) {
        try {
            Start.getInstance().loadGameModule("jar:file:games/othello.jar!/");
        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IOException e) {
            e.printStackTrace(); // @TODO: maybe show a dialog
        }
    }

    public void pause(ActionEvent actionEvent) {
        System.out.println("Game paused");
    }

    public void endGame(ActionEvent actionEvent) {
        System.out.println("Game ended");
    }

    public void showHighScores(ActionEvent actionEvent) {
        System.out.println("High scores");
    }

    public void giveHint(ActionEvent actionEvent) {
        DialogInterface testDialog = new ConnectionDialog(new DialogEvents() {
            @Override
            public void attemptLogin(String userName) {
                System.out.println("iets");
            }
        });
        testDialog.display();
    }

    public void undoMove(ActionEvent actionEvent) {
        System.out.println("Undo move");
    }

    public void saveGame(ActionEvent actionEvent) {
        System.out.println("Saving game...");
    }

    public void quit(ActionEvent actionEvent) {
        System.out.println("Quit game");
        Platform.exit();
    }

}
